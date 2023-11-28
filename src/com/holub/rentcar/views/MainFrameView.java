package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class MainFrameView extends MainFrameComponentView {
    MainFrameController controller;
    public MenuSelectionView menuSelectionView;
    public JButton selectBtn = new JButton("Select");
    public JButton currentTime = new JButton("currentTime");
    MenuView menuView;
    public MainFrameView(MainFrameModel model) {
        super(model);
        this.menuSelectionView = new MenuSelectionView(model);
        this.menuView = new MenuView(model);

        setLayout(new BorderLayout());

        Box b1 = Box.createHorizontalBox();
        b1.add(Box.createHorizontalGlue());
        b1.add(selectBtn);
        b1.add(Box.createHorizontalGlue());
        Box toolBox = new Box(BoxLayout.Y_AXIS);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        toolBox.add(b1);
        buttonBox.add(toolBox);
        this.add(currentTime,BorderLayout.SOUTH);
        add(menuSelectionView, BorderLayout.WEST);
        add(buttonBox, BorderLayout.SOUTH);
        add(menuView, BorderLayout.CENTER);
    }

    public void update(Observable o, Object arg) {
        menuSelectionView.update(o, arg);
        menuView.update(o, arg);
        if(model.currentMenu == "time") {
            this.add(currentTime, BorderLayout.SOUTH);
            System.out.println("time");
        }
    }
}