package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import java.awt.*;
import java.util.Observable;

public class MainFrameView extends MainFrameComponentView {
    MainFrameController controller;
    public MenuSelectionView menuSelectionView;
    MenuView menuView;
    public MainFrameView(MainFrameModel model) {
        super(model);
        this.menuSelectionView = new MenuSelectionView(model);
        this.menuView = new MenuView(model);

        setLayout(new BorderLayout());

        add(menuSelectionView, BorderLayout.WEST);
        add(menuView, BorderLayout.CENTER);
    }

    public void update(Observable o, Object arg) {
        menuSelectionView.update(o, arg);
        menuView.update(o, arg);
    }
}