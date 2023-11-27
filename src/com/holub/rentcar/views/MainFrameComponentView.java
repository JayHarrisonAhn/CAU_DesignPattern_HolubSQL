package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.util.Observer;

public abstract class MainFrameComponentView extends JPanel implements Observer {
    MainFrameController controller;
    MainFrameModel model;
    protected MainFrameComponentView(MainFrameModel model) {
        super();
        this.model = model;
    }
}
