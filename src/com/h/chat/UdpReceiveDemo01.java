package com.h.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        while (true){
            //准备接收包裹
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
            socket.receive(packet);//阻塞式接收包裹

            //断开连接 bye
            byte[] data = packet.getData();
            String recevieData = new String(data, 0, data.length);
            System.out.println(recevieData);

            //如果传输bye则断开连接
            if (recevieData.equals("bye")) {
                break;
            }

        }
        socket.close();

    }
}
