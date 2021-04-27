package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionTwo {
    public static void main(String[] args) {
        //两个按钮实现同一个监听
        //开始    停止
        Frame frame = new Frame("开始-停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");

        //可以显示的定义，出发会返回的命令，如果不显示定于，则会走默认的值
        //可以多个按钮，只写一个监听类
        button2.setActionCommand("按钮2来到内部类");

        MyMonitro myMonitro = new MyMonitro();
        button1.addActionListener(myMonitro);
        button2.addActionListener(myMonitro);

        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.pack();
    }
}

class MyMonitro implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //
        System.out.println("按钮被点击了:msg"+e.getActionCommand());
        if (e.getActionCommand().equals("stop")){
            System.out.println("停止");
        }
    }
}