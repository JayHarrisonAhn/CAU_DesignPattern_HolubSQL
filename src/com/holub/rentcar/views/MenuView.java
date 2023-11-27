package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class MenuView extends MainFrameComponentView {
    MenuView(MainFrameModel model) {
        super(model);
        setLayout(new CardLayout());
        add(new JScrollPane(new JButton("1")), "info");
        add(new JScrollPane(new JButton("2")), "location");
        add(new JScrollPane(new JButton("3")), "time");
        add(new JScrollPane(new JButton("4")), "result");
    }

    public void update(Observable o, Object arg) {
        CardLayout cardLayout = (CardLayout) getLayout();
        cardLayout.show(this, model.currentMenu);
    }
}