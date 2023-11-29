package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;
import com.holub.rentcar.models.Selection;
import com.holub.rentcar.models.row.CarType;
import com.holub.rentcar.models.row.Place;

import javax.swing.*;
import java.util.Observable;

public class PanelOfPlaces extends MainFrameComponentView {
    public JPanel panelOfPlace = new JPanel();

    PanelOfPlaces(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
        panelOfPlace.setLayout(new BoxLayout(panelOfPlace, BoxLayout.Y_AXIS));
        updateCheckboxes();
    }

    @Override
    public void update(Observable o, Object arg) {
        updateCheckboxes();
    }
    void updateCheckboxes() {
        panelOfPlace.removeAll();
        for(int i=0; i<model.places.size(); i++) {
            Selection<Place> place = model.places.get(i);
            JCheckBox checkBox = new JCheckBox(place.obj.name);
            checkBox.setSelected(model.places.get(i).selected);
            int finalI = i;
            checkBox.addActionListener(event -> {
                controller.setPlaceInfoCheckbox(finalI, !model.places.get(finalI).selected);
            });
            panelOfPlace.add(checkBox);
        }
        panelOfPlace.revalidate();
        panelOfPlace.repaint();
    }
}