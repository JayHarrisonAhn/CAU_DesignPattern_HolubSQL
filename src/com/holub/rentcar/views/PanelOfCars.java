package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;
import com.holub.rentcar.models.row.CarType;
import com.holub.rentcar.models.Selection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;

public class PanelOfCars extends MainFrameComponentView {
    public JPanel panelOfCar = new JPanel();
    PanelOfCars(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
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
        for(int i=0; i<model.infos.size(); i++) {
            Selection<CarType> info = model.infos.get(i);
            JCheckBox checkBox = new JCheckBox(info.obj.name);
            checkBox.setSelected(model.infos.get(i).selected);
            int finalI = i;
            checkBox.addActionListener(event -> {
                controller.setCarInfoCheckbox(finalI, !model.infos.get(finalI).selected);
            });
            panelOfCar.add(checkBox);
        }
        panelOfCar.revalidate();
        panelOfCar.repaint();
    }
}