package com.GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//练习的Demo
public class EXDemo {
    public static void main(String[] args) {
        //首先设置主窗口格式，然后是高宽，xy点，背景颜色，主面板是否显示
        Frame frame = new Frame();
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(400,300);
        frame.setLocation(300,400);
        frame.setBackground(Color.gray);
        frame.setVisible(true);

        //然后设置面板
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));

        p1.add(new Button("p1-1"),BorderLayout.EAST);
        p1.add(new Button("p1-2"),BorderLayout.WEST);
        p2.add(new Button("P2-1"));
        p2.add(new Button("P2-2"));
        p1.add(p2,BorderLayout.CENTER);

        p3.add(new Button("p3-1"),BorderLayout.EAST);
        p3.add(new Button("p3-2"),BorderLayout.WEST);
        for (int i = 0; i < 4; i++) {
            p4.add(new Button("for-"+i));
        }
        p3.add(p4,BorderLayout.CENTER);

        frame.add(p1);
        frame.add(p3);

        frame.setLayout(new GridLayout(2,1));



        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });



    }
}
