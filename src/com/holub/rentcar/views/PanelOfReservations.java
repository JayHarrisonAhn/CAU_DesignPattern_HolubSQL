package com.holub.rentcar.views;

import com.holub.database.JTableExporter;
import com.holub.database.Table;
import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.util.Observable;

public class PanelOfReservations extends MainFrameComponentView {
    protected PanelOfReservations(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
        add(new JLabel("Reservations"));
    }

    @Override
    public void update(Observable o, Object arg) {
        updateReservations(model.reservations);
    }

    private void updateReservations(Table reservations) {
        try {
            removeAll();
            JTableExporter tableBuilder = new JTableExporter();
            reservations.export(tableBuilder);
            add(tableBuilder.getJTable());
            revalidate();
            repaint();
        } catch(Exception e) { }
    }
}
