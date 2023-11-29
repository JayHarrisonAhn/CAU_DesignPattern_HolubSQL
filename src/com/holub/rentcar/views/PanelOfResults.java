package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;
import com.holub.rentcar.models.row.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class PanelOfResults extends MainFrameComponentView {
    public JPanel panelOfResult = new JPanel();
    public JTable resultOfTable = new JTable();

    PanelOfResults(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
        panelOfResult.add(resultOfTable);
//        placeTable.setPreferredScrollableViewportSize(new Dimension(100, 300));
    }

    public void update(Observable o, Object arg) {
        updateResults();
    }

    private void updateResults() {
        List<Object[]> results = new ArrayList<>();
        for (Car car : model.results) {
            results.add(car.toArray());
        }
        Object[] columnNames = new String[] {"차량번호", "차종", "대여장소"};
        Object[][] placeData = model.results.stream()
                .map(l -> l.toArray())
                .toArray(Object[][]::new);
        DefaultTableModel tableModel = new DefaultTableModel(placeData, columnNames);
        resultOfTable.setModel(tableModel);
        resultOfTable.repaint();
    }
}