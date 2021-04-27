package com.h.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
//要等待客户端连接
public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {

        //服务器需要开放端口
        DatagramSocket socket = new DatagramSocket(9090);

        //开放端口，接收数据包
        byte[] bytes = new byte[1024];
        //数组需要封装
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);//接收只管接收
        socket.receive(packet);//阻塞接收，

        //输出一下接收到的数据
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));



        //关闭连接
        socket.close();

    }
}
