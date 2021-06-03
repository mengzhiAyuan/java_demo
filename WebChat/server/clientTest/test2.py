import socket
def test2():
    #多个客户端同时收发数据
    client_socket =socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    client_socket.connect(('10.147.4.112',8063))
    while True :
        msg=input('input Your want')
        client_socket.send(msg.encode('utf-8'))
        # recv_data=client_socket.recv(1024)
        # print(recv_data.decode('utf-8'))

if __name__=='__main__':
    test2()