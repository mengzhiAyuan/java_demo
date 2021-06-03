class socketUtils(object) :
    """套接字工具类"""

    def __init__(self,sock):
        self.sock=sock

    def recv_data(self):
        """接收数据并解码为字符串"""
        try:
           return self.sock.recv(1024).decode('utf-8')
        except:
           return ""

    def send_data(self,message):
        return self.sock.send(message.encode('utf-8'))

    def close(self):
        """关闭套接字"""
        self.sock.close()

