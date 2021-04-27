package com.h.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(7777);

        //准备数据：从控制台读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){

            String data = reader.readLine();
            byte[] bytes = data.getBytes();

            DatagramPacket packet = new DatagramPacket(bytes,0,data.length(),new InetSocketAddress("localhost",6666));

            //发送
            socket.send(packet);

            if (data.equals("bye")) {
                break;
            }
        }



        socket.close();
    }
}
