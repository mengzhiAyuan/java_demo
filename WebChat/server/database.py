from pymysql import connect
from configration.config import *

class database(object) :
    """数据库操作管理类"""
    def __init__(self):
        self.conn=connect(
            host=DB_HOST,
            port=DB_PORT,
            database=DB_NAME,
            user=DB_USER,
            password=DB_PASS,
        )

        #获取游标
        self.cursor=self.conn.cursor()

    def close(self):
        """释放数据库资源"""
        self.cursor.close()
        self.conn.close()


    def get_one(self,sql):
        """使用sql语句查询用户信息"""
        #执行sql 语句
        self.cursor.execute(sql)

        #获取查询结果
        query_result=self.cursor.fetchone()
        #判断是否有结果
        if not query_result:
            return None
        #获取字段名称列表
        fileds =[filed[0] for filed in self.cursor.description]

        #使用字段和数据生成字典，供返回使用
        return_data={}
        for filed,value in zip(fileds,query_result):
            return_data[filed] =value

        return return_data

if __name__ =='__main__':
    db =database()
    data=db.get_one("select * from users where username='mengzhiayuan'")
    print(data)
    db.close()
