package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//文本框监听
public class TestText01 {
    public static void main(String[] args) {
        //main方法只放启动！
        new MyFrame();
    }
}

class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        //监听这个文本框输入的文字
        MyActionListener1 myActionListener1 = new MyActionListener1();
        //按下回车，就会触发这个输入框的事件
        textField.addActionListener(myActionListener1);

        //设置替换编码
        textField.setEchoChar('*');

        setSize(300,300);
        setLocation(300,300);
        setVisible(true);
        pack();
    }
}

class MyActionListener1 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
//        e.getSource();//获得一些资源,返回的是一个对象,默认返回的类型是Object，可以任意转化返回类型
        TextField field= (TextField) e.getSource();//监听了谁，TextField这里就是谁
        System.out.println(field.getText());
        field.setText("");//回车之后，设置成空
    }
}