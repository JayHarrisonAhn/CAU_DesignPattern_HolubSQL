package com.holub.rentcar;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    private Box buttonBox;
    private Box toolBox;
    private MainPanel panel;

    public MainFrame(){
        init();
    }

    private void init(){
//        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        panel = new MainPanel();
//        mainButton.setOpaque(true);  // 패널 투명도 설정
//        setUndecorated(true);       // Do not show any window button like close, minimize etc.
//        setBackground(new Color(0, 0, 1, 1));       // background's color -> transparent

        Box b1 = Box.createHorizontalBox();
        b1.add(Box.createHorizontalGlue());
        b1.add(panel.info);
        b1.add(Box.createHorizontalGlue());

        Box b2 = Box.createHorizontalBox();
        b2.add(Box.createHorizontalGlue());
        b2.add(panel.place);
        b2.add(Box.createHorizontalGlue());

        Box b3 = Box.createHorizontalBox();
        b3.add(Box.createHorizontalGlue());
        b3.add(panel.time);
        b3.add(Box.createHorizontalGlue());

        Box b4 = Box.createHorizontalBox();
        b4.add(Box.createHorizontalGlue());
        b4.add(panel.result);
        b4.add(Box.createHorizontalGlue());

        toolBox = new Box(BoxLayout.Y_AXIS);
        toolBox.add(b1);
        toolBox.add(b2);
        toolBox.add(b3);
        toolBox.add(b4);

        buttonBox = new Box(BoxLayout.Y_AXIS);
        buttonBox.add(Box.createVerticalStrut(250));
        buttonBox.add(toolBox);
//        getContentPane().add(mainPanel);
//        pack();
        add(panel.mainPanel, BorderLayout.CENTER);
        add(buttonBox, BorderLayout.WEST);
        setVisible(true);
    }

}