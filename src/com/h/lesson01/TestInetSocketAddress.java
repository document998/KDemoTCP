package com.h.lesson01;

import java.net.InetSocketAddress;

//
public class TestInetSocketAddress {
    public static void main(String[] args) {

        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(inetSocketAddress1);

        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost",8080);
        System.out.println(inetSocketAddress2);

        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress1.getHostName());//host:C:\Windows\System32\drivers\etc\hosts
        System.out.println(inetSocketAddress1.getPort());//端口



    }
}
