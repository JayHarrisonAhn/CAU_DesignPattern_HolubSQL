package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.util.Observable;

public class PanelOfLogin extends MainFrameComponentView {
    public JTextField textField = new JTextField(20);
    protected PanelOfLogin(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
        add(new JLabel("ID 입력"));
        add(this.textField);
        setSize(100, 100);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        textField.setText(model.userId);
        textField.repaint();
    }
}
