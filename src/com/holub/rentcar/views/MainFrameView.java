package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class MainFrameView extends MainFrameComponentView {
    public MenuSelectionView menuSelectionView;
    public MenuView menuView;
    public MainFrameView(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
        this.menuSelectionView = new MenuSelectionView(model, controller);
        this.menuView = new MenuView(model, controller);

        setLayout(new BorderLayout());

        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        add(menuSelectionView, BorderLayout.WEST);
        add(buttonBox, BorderLayout.SOUTH);
        add(menuView, BorderLayout.CENTER);
    }

    public void update(Observable o, Object arg) {
    }
}