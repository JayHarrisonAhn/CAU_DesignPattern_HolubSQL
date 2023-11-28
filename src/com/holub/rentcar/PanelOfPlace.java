package com.holub.rentcar;

import javax.swing.*;

public class PanelOfPlace extends JPanel{
    public JPanel panelOfPlace = new JPanel();
    PanelOfPlace() {

        CustomObject place1 = new CustomObject("중앙대 정문", 2);
        CustomObject place2 = new CustomObject("중앙대 후문", 3);
        CustomObject place3 = new CustomObject("중앙대 병원", 6);
        CustomObject place4 = new CustomObject("숭실대", 6);
        CustomObject place5 = new CustomObject("서울대입구", 12);

        CustomCheckBox checkBox1 = new CustomCheckBox(place1);
        CustomCheckBox checkBox2 = new CustomCheckBox(place2);
        CustomCheckBox checkBox3 = new CustomCheckBox(place3);
        CustomCheckBox checkBox4 = new CustomCheckBox(place4);
        CustomCheckBox checkBox5 = new CustomCheckBox(place5);

        panelOfPlace.setLayout(new BoxLayout(panelOfPlace,BoxLayout.Y_AXIS));
        panelOfPlace.add(checkBox1);
        panelOfPlace.add(checkBox2);
        panelOfPlace.add(checkBox3);
        panelOfPlace.add(checkBox4);
        panelOfPlace.add(checkBox5);

        JButton displayButton = new JButton("Select");
        panelOfPlace.add(displayButton);
        displayButton.addActionListener(e -> {
            if (checkBox1.isSelected()) {
                System.out.println("Selected: " + checkBox1.getCustomObject());
            }
            if (checkBox2.isSelected()) {
                System.out.println("Selected: " + checkBox2.getCustomObject());
            }
            if (checkBox3.isSelected()) {
                System.out.println("Selected: " + checkBox3.getCustomObject());
            }
            if (checkBox4.isSelected()) {
                System.out.println("Selected: " + checkBox4.getCustomObject());
            }
            if (checkBox5.isSelected()) {
                System.out.println("Selected: " + checkBox5.getCustomObject());
            }
        });
    }

    static class CustomObject {
        private String name;
        private int value;

        public CustomObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return name + "남은 차량 수 : " + value;
        }
    }

    static class CustomCheckBox extends JCheckBox {
        private CustomObject customObject;

        public CustomCheckBox(CustomObject customObject) {
            super(customObject.toString());
            this.customObject = customObject;
        }

        public CustomObject getCustomObject() {
            return customObject;
        }
    }
}
