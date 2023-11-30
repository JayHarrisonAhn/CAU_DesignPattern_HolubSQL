package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class MenuSelectionView extends MainFrameComponentView {
    public JLabel usernameLabel = new JLabel("aaaa");
    public JButton loginBtn = new JButton("로그인");
    public JButton infoBtn = new JButton("차량정보");
    public JButton locationBtn = new JButton("위치");
    public JButton timeBtn = new JButton("대여시간");
    public JButton resultBtn = new JButton("차량 예약하기");
    MenuSelectionView(MainFrameModel model, MainFrameController controller) {
        super(model, controller);

        Box loginbox = box(loginBtn);
        Box b1 = box(infoBtn);
        Box b2 = box(locationBtn);
        Box b3 = box(timeBtn);
        Box b4 = box(resultBtn);

        Box toolBox = new Box(BoxLayout.Y_AXIS);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        toolBox.add(usernameLabel);
        toolBox.add(loginbox);
        toolBox.add(b1);
        toolBox.add(b2);
        toolBox.add(b3);
        toolBox.add(b4);

        buttonBox.add(Box.createVerticalStrut(200)); // adjust height of buttonBox
        buttonBox.add(toolBox);

        add(buttonBox, BorderLayout.WEST);
    }

    public void update(Observable o, Object arg) {
        removeAll();
        Box toolBox = new Box(BoxLayout.Y_AXIS);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        toolBox.add(usernameLabel);
        if (model.userName == null) {
            usernameLabel.setText("이용자 : 로그인 필요");
            Box loginbox = box(loginBtn);
            toolBox.add(loginbox);
        } else {
            usernameLabel.setText("이용자 : "+model.userName);
            Box b1 = box(infoBtn);
            Box b2 = box(locationBtn);
            Box b3 = box(timeBtn);
            Box b4 = box(resultBtn);
            toolBox.add(b1);
            toolBox.add(b2);
            toolBox.add(b3);
            toolBox.add(b4);
        }
        buttonBox.add(Box.createVerticalStrut(200)); // adjust height of buttonBox
        buttonBox.add(toolBox);

        add(buttonBox, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    private Box box(JComponent panel) {
        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        box.add(panel);
        box.add(Box.createHorizontalGlue());
        return box;
    }
}