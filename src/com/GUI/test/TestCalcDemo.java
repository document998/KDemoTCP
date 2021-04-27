package com.GUI.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCalcDemo {
    public static void main(String[] args) {
        new Calculator().CalculatorFrame();
    }
}
//计算器类
class Calculator extends Frame{
    //属性:需要用到的常量
    private TextField field1,field2,field3;

    //方法
    public void CalculatorFrame(){
        Frame frame = new Frame();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();

        field1 = new TextField(10);
        field2 = new TextField(20);
        field3 = new TextField(30);

        Button badd = new Button("+");
        Button bdelect = new Button("-");
        Button bcheng = new Button("*");
        Button bchu = new Button("/");

        badd.addActionListener(new MyCalculator());
        bdelect.addActionListener(new MyCalculator());
        bcheng.addActionListener(new MyCalculator());
        bchu.addActionListener(new MyCalculator());

        Label label1 = new Label("+");
        Label label2 = new Label("=");

        frame.setLayout(new GridLayout(2,1));
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());

        panel1.add(field1);
        panel1.add(label1);
        panel1.add(field2);
        panel1.add(label2);
        panel1.add(field3);

        panel2.add(badd);
        panel2.add(bdelect);
        panel2.add(bcheng);
        panel2.add(bchu);

        frame.add(panel1);
        frame.add(panel2);

        frame.setVisible(true);
        frame.setSize(300,300);
        frame.setLocation(500,500);
        frame.pack();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    //监听器类
    private class MyCalculator implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int i1 = Integer.parseInt(field1.getText());
            int i2 = Integer.parseInt(field2.getText());

            if (e.getActionCommand().equals("+")){
                field3.setText(""+(i1+i2));
            }else if(e.getActionCommand().equals("-")){
                field3.setText(""+(i1-i2));
            }else if(e.getActionCommand().equals("*")){
                field3.setText(""+(i1*i2));
            }else if(e.getActionCommand().equals("/")){
                field3.setText(""+(i1/i2));
            }


        }
    }



}
