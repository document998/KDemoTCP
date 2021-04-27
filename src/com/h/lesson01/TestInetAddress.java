package com.h.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

//测试IP
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddresses1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddresses1);

            InetAddress inetAddresses3 = InetAddress.getByName("localhost");
            System.out.println(inetAddresses3);

            InetAddress inetAddresses4 = InetAddress.getLocalHost();
            System.out.println(inetAddresses4);



            //查询网站ip地址
            InetAddress inetAddresses2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddresses2);

            //常用方法
            System.out.println(inetAddresses2.getAddress());
            System.out.println(inetAddresses2.getCanonicalHostName());//获得规范的名字
            System.out.println(inetAddresses2.getHostName());//ip
            System.out.println(inetAddresses2.getHostAddress());//域名，或者自己电脑的名字

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
