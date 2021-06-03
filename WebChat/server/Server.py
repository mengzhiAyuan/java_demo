from server.configration.socketUtils import socketUtils
from server.database import database
from server_socket import ServerSocket
from threading import Thread
from server.configration.config import *
from configration.response_protocal import *

class Server(object):
    """服务器核心类"""
    def __init__(self):
        #创建服务器套接字
        self.server_socket=ServerSocket()
        #创建保存当前用户的字典
        self.clients ={}
        #创建数据库管理对象
        self.db=database()

    def startup(self):
        """获取客户端连接，并提供服务"""
        while True :
            print('正在获取客户端连接')
            soc,addr= self.server_socket.accept()
            #使用套接字生成包装对象
            client_soc=socketUtils(soc)

            t=Thread(target=self.request_handle,args=(client_soc,))
            t.start()

            # 关闭客户端套接字
            # soc.close()开启子线程，欢迎之门为客户端连接开启新门  !!!!!注意不要关闭服务器欢迎套接字

    def request_handle(self,client_soc):
        """处理用户端请求"""
        while True:
            recv_data = client_soc.recv_data()
            if not recv_data:
                #没有接收到数据客户端应该已经关闭
                self.remove_user(client_soc)
                client_soc.close()
                break
            # print('服务器接收的数据是' + recv_data)
            # client_soc.send_data(recv_data.upper())

            #解析数据
            parse_data=self.parse_request_text(recv_data)
            print('获取到解析后的内容： %s' % parse_data)

            #分析请求类型，并根据请求类型调用相应的处理函数
            if parse_data['request_id']==REQUEST_LOGIN:
                self.request_login_handle(client_soc,parse_data)
            elif parse_data['request_id']==REQUEST_CHAT:
                self.request_chat_handle(client_soc,parse_data)


    @staticmethod
    def remove_user(self,client_soc):
        """客户端下线的请求"""
        print('有客户端下线了')

    def parse_request_text(self, recv_data):
        """
        解析客户端发送来的数据
        登录信息 ：0001|username|password
        聊天信息 ：0002|username|message
        """
        print('解析----------')
        request_list=recv_data.split(DELIMITER)
        #按照类型解析数据
        request_data= {'request_id': request_list[0]}
        if request_data['request_id']==REQUEST_LOGIN:
            """用户请求登录"""
            request_data['username']=request_list[1]
            request_data['password']=request_list[2]
        elif request_data['request_id']==REQUEST_CHAT:
            """用户发来聊天消息"""
            request_data['username']=request_list[1]
            request_data['message']=request_list[2]

        return request_data

    def request_chat_handle(self,client_soc,parse_data):
        """处理用户请求"""
        print('chat------>handing>>>>>>>>')
        #获取消息内容
        username= parse_data['username']
        message=parse_data['message']
        nickname=self.clients[username]['nickname']
        #拼接发送给客户端的消息文本
        msg=ResponseProtocal.response_chat(nickname,message)

        #转发消息给在线用户
        for u_name,info in self.clients.items():
            if username==u_name : continue
            info['sock'].send_data(msg)

    def request_login_handle(self,client_soc,request_data):
        """处理登录请求"""
        print('收到登陆请求——————————准备处理')
        #获取到账号密码
        username=request_data['username']
        password=request_data['password']

        #检查登录是否成功
        ret,nickname,username=self.check_username_login(username,password)

        #登录成功需要保存当前用户
        if ret=='1':
            self.clients[username]={'sock':client_soc,'nickname':nickname}
        #拼接给客户端的消息
        response_test=ResponseProtocal.response_login_result(ret,nickname,username)
        #把消息发送给客户端
        client_soc.send_data(response_test)

    def check_username_login(self, username, password):
        """检查用户是否登录成功，并返回检查结果
            (0/失败，1/成功)，nickname，用户账号
        """

        #从数据库查询用户信息
        sql="select * from users where username='%s' " %username
        result =self.db.get_one(sql);

        #没有查到结果则说明，用户不存在，登录失败
        if not result :
            return '0','',username


        return '1',result['user_nickname'],username


if __name__=='__main__':
    Server().startup()