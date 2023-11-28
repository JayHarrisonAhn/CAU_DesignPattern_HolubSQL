package com.holub.rentcar.views;

import javax.swing.*;

public class PanelOfCars extends JPanel {
    public JPanel panelOfCar = new JPanel();
    PanelOfCars() {
        String car1 = "cona";
        String car2 = "sportage";
        String car3 = "ev6";

        JCheckBox checkBox1 = new JCheckBox(car1);
        JCheckBox checkBox2 = new JCheckBox(car2);
        JCheckBox checkBox3 = new JCheckBox(car3);

        panelOfCar.setLayout(new BoxLayout(panelOfCar, BoxLayout.Y_AXIS));
        panelOfCar.add(checkBox1);
        panelOfCar.add(checkBox2);
        panelOfCar.add(checkBox3);
    }
}