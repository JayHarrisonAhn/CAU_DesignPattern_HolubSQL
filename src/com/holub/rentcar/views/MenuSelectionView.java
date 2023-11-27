package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.util.Observable;

public class MenuSelectionView extends MainFrameComponentView {
    public JButton infoBtn = new JButton("차량정보");
    public JButton locationBtn = new JButton("위치");
    public JButton timeBtn = new JButton("대여시간");
    public JButton resultBtn = new JButton("결과");
    MenuSelectionView(MainFrameModel model) {
        super(model);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        buttonBox.add(infoBtn);
        buttonBox.add(locationBtn);
        buttonBox.add(timeBtn);
        buttonBox.add(resultBtn);
        add(buttonBox);
    }

    public void update(Observable o, Object arg) {

    }
}