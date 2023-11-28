package com.holub.rentcar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelOfResult extends JPanel {
    public JPanel panelOfResult = new JPanel();
    public JPanel chungangMainGate = new JPanel();
    public JPanel chungangBackGate = new JPanel();
    public JPanel chungangHospital = new JPanel();
    public JPanel sungsil = new JPanel();
    public JPanel seoulNational = new JPanel();
    public JTable resultOfTable = new JTable();

    PanelOfResult() {
        chungangMainGate.setSize(80,400);
        chungangBackGate.setSize(80,400);
        chungangHospital.setSize(80,400);
        sungsil.setSize(80,400);
        seoulNational.setSize(80,400);

        Object[][] placeData = {
                {"Car 1", "중앙대 정문"},
                {"Car 2", "중앙대 후문"},
                {"Car 3", "중앙대 병원"},
                {"Car 4", "숭실대"},
                {"Car 5", "서울대 입구"},
        };
        Object[] columnNames = {"Car's Info", "Car's Place"};
        DefaultTableModel model = new DefaultTableModel(placeData, columnNames);
        resultOfTable.setModel(model);
        panelOfResult.add(resultOfTable);
//        placeTable.setPreferredScrollableViewportSize(new Dimension(100, 300));

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> {
            System.out.println("selected");
        });
        panelOfResult.add(selectButton);
    }
}