package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class MenuSelectionView extends MainFrameComponentView {
    public JButton infoBtn = new JButton("차량정보");
    public JButton locationBtn = new JButton("위치");
    public JButton timeBtn = new JButton("대여시간");
    public JButton resultBtn = new JButton("결과");
    MenuSelectionView(MainFrameModel model) {
        super(model);

        Box b1 = Box.createHorizontalBox();
        b1.add(Box.createHorizontalGlue());
        b1.add(infoBtn);
        b1.add(Box.createHorizontalGlue());
        Box b2 = Box.createHorizontalBox();
        b2.add(Box.createHorizontalGlue());
        b2.add(locationBtn);
        b2.add(Box.createHorizontalGlue());
        Box b3 = Box.createHorizontalBox();
        b3.add(Box.createHorizontalGlue());
        b3.add(timeBtn);
        b3.add(Box.createHorizontalGlue());
        Box b4 = Box.createHorizontalBox();
        b4.add(Box.createHorizontalGlue());
        b4.add(resultBtn);
        b4.add(Box.createHorizontalGlue());

        Box toolBox = new Box(BoxLayout.Y_AXIS);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        toolBox.add(b1);
        toolBox.add(b2);
        toolBox.add(b3);
        toolBox.add(b4);

        buttonBox.add(Box.createVerticalStrut(200)); // adjust height of buttonBox
        buttonBox.add(toolBox);

        add(buttonBox, BorderLayout.WEST);
    }

    public void update(Observable o, Object arg) {

    }
}