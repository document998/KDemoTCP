package com.h.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemo01 {
    public static void main(String[] args) {
//      因为需要在finally里面关闭资源，但是创建了对象之后收到作用域限制无法在finally里面关闭
//      所以我们放在最上面，提升作用域，随后在final里面正常关闭
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.服务器得有一个地址
            serverSocket = new ServerSocket(9999);
            //2.等待客户端连接过来(此处可以加while不停循环启动)
            while (true){

                accept = serverSocket.accept();
                //3.读取客户端消息
                is = accept.getInputStream();

                //4.管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len=is.read(buffer)) != -1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            //管道关闭不能随意，要一节一节的关闭【谁先接，谁先断开】

            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
