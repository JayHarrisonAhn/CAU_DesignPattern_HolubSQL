package com.holub.rentcar.views;

import javax.swing.*;

public class PanelOfPlaces extends JPanel {
    public JPanel panelOfPlace = new JPanel();

    PanelOfPlaces() {
        String place1 = "중앙대 정문";
        String place2 = "중앙대 후문";
        String place3 = "중앙대 병원";
        String place4 = "숭실대";
        String place5 = "서울대입구";

        JCheckBox checkBox1 = new JCheckBox(place1);
        JCheckBox checkBox2 = new JCheckBox(place2);
        JCheckBox checkBox3 = new JCheckBox(place3);
        JCheckBox checkBox4 = new JCheckBox(place4);
        JCheckBox checkBox5 = new JCheckBox(place5);

        panelOfPlace.setLayout(new BoxLayout(panelOfPlace, BoxLayout.Y_AXIS));
        panelOfPlace.add(checkBox1);
        panelOfPlace.add(checkBox2);
        panelOfPlace.add(checkBox3);
        panelOfPlace.add(checkBox4);
        panelOfPlace.add(checkBox5);
    }
}