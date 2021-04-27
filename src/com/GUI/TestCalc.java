package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalc {
    public static void main(String[] args) {
            new Calculator().loadFrame();
    }
}

//计算器类
class Calculator extends Frame{
    //属性
    TextField field1,field2,field3;

    //方法
    public void loadFrame(){
        //创建基本主键
        //3个文本框
        field1 = new TextField(10);//最大能填多少个字符
        field2 = new TextField(10);//字符数
        field3 = new TextField(20);//因为是计算器，第三个加起来这么大

        //一个按钮
        Button button = new Button("=");

        //因为是计算器，所以button需要添加一个监听器来显示结果
        button.addActionListener(new MyCalculatroLisener());

        //一个标签
        Label label = new Label("+");

        //开始布局(此处为流式布局)
        setLayout(new FlowLayout());

        add(field1);
        add(label);
        add(field2);
        add(button);
        add(field3);
        setSize(300,300);
        setLocation(500,500);
        pack();
        setVisible(true);

    }

    //监听器类
    //内部李最大的好处，  就是可以畅通无阻的访问外部的属性和方法
    private class MyCalculatroLisener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //1.获得输入的两个数字
            int i1 = Integer.parseInt(field1.getText());
            int i2 = Integer.parseInt(field2.getText());

            //2.将这个值 + 法运算后，放到第三个框
            field3.setText(""+(i1+i2));

            //3.清除前两个框
            field1.setText("");
            field2.setText("");
        }
    }

}

