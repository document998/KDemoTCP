package com.h.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

//不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立一个Socket
        DatagramSocket dsocket = new DatagramSocket();

        //2.建立一个包
        String msg = "你好！";

        //发送给谁
        InetAddress byName = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, byName, port);


        //3.发送包
        dsocket.send(packet);

        //关闭流
        dsocket.close();
    }
}
