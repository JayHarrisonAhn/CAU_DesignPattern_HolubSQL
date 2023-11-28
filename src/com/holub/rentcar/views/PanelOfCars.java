package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameModel;
import com.holub.rentcar.Selection;

import javax.swing.*;
import java.util.Observable;

public class PanelOfCars extends MainFrameComponentView {
    public JPanel panelOfCar = new JPanel();
    PanelOfCars(MainFrameModel model) {
        super(model);
        panelOfCar.setLayout(new BoxLayout(panelOfCar, BoxLayout.Y_AXIS));
        updateCheckboxes();
    }

    public void update(Observable o, Object arg) {
        if(o instanceof MainFrameModel) {
            updateCheckboxes();
        }
    }

    void updateCheckboxes() {
        panelOfCar.removeAll();
        for(Selection info: model.infos) {
            JCheckBox checkBox = new JCheckBox(info.key);
            panelOfCar.add(checkBox);
        }
    }
}