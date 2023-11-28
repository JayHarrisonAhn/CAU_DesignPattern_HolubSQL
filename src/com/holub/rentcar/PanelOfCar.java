package com.holub.rentcar;

import javax.swing.*;
import java.awt.*;

public class PanelOfCar extends JPanel{
    public JPanel panelOfCar = new JPanel();
    PanelOfCar() {
        CustomObject car1 = new CustomObject("cona", 7001);
        CustomObject car2 = new CustomObject("cona", 7002);  // doesn't need to show to User
        CustomObject car3 = new CustomObject("sportage", 8001);
        CustomObject car4 = new CustomObject("ev6", 9001);
        String car11 = new String("cona");
        String car12 = new String("sportage");
        String car13 = new String("ev6");

        JCheckBox checkBox11 = new JCheckBox(car11);
        JCheckBox checkBox12 = new JCheckBox(car12);
        JCheckBox checkBox13 = new JCheckBox(car13);

        CustomCheckBox checkBox1 = new CustomCheckBox(car1);
        CustomCheckBox checkBox3 = new CustomCheckBox(car3);
        CustomCheckBox checkBox4 = new CustomCheckBox(car4);
//        CustomCheckBox checkBox5 = new CustomCheckBox(car1);
//        CustomCheckBox checkBox6 = new CustomCheckBox(car3);
//        CustomCheckBox checkBox7 = new CustomCheckBox(car4);
//        CustomCheckBox checkBox8 = new CustomCheckBox(car1);
//        CustomCheckBox checkBox9 = new CustomCheckBox(car3);
//        CustomCheckBox checkBox10 = new CustomCheckBox(car4);
//        CustomCheckBox checkBox11 = new CustomCheckBox(car1);
//        CustomCheckBox checkBox12 = new CustomCheckBox(car3);
//        CustomCheckBox checkBox13 = new CustomCheckBox(car4);
//        CustomCheckBox checkBox14 = new CustomCheckBox(car1);
//        CustomCheckBox checkBox15 = new CustomCheckBox(car3);
//        CustomCheckBox checkBox16 = new CustomCheckBox(car1);
//        CustomCheckBox checkBox17 = new CustomCheckBox(car3);
//        CustomCheckBox checkBox18 = new CustomCheckBox(car4);
//        CustomCheckBox checkBox19 = new CustomCheckBox(car1);
//        CustomCheckBox checkBox20 = new CustomCheckBox(car4);
//        CustomCheckBox checkBox21 = new CustomCheckBox(car1);
//        CustomCheckBox checkBox22 = new CustomCheckBox(car3);
//        CustomCheckBox checkBox23 = new CustomCheckBox(car4);


        panelOfCar.setLayout(new BoxLayout(panelOfCar,BoxLayout.Y_AXIS));
        panelOfCar.add(checkBox1);
        panelOfCar.add(checkBox3);
        panelOfCar.add(checkBox4);
        panelOfCar.add(checkBox11);
        panelOfCar.add(checkBox12);
        panelOfCar.add(checkBox13);
//        panelOfCar.add(checkBox5);
//        panelOfCar.add(checkBox6);
//        panelOfCar.add(checkBox7);
//        panelOfCar.add(checkBox8);
//        panelOfCar.add(checkBox9);
//        panelOfCar.add(checkBox10);
//        panelOfCar.add(checkBox11);
//        panelOfCar.add(checkBox12);
//        panelOfCar.add(checkBox13);
//        panelOfCar.add(checkBox14);
//        panelOfCar.add(checkBox15);
//        panelOfCar.add(checkBox16);
//        panelOfCar.add(checkBox17);
//        panelOfCar.add(checkBox18);
//        panelOfCar.add(checkBox19);
//        panelOfCar.add(checkBox20);
//        panelOfCar.add(checkBox21);
//        panelOfCar.add(checkBox22);
//        panelOfCar.add(checkBox23);



        JButton displayButton = new JButton("Select");
        displayButton.addActionListener(e -> {
            if (checkBox1.isSelected()) {
                System.out.println("Selected: " + checkBox1.getCustomObject());
            }
            else if (checkBox3.isSelected()) {
                System.out.println("Selected: " + checkBox3.getCustomObject());
            }
            else if (checkBox4.isSelected()) {
                System.out.println("Selected: " + checkBox4.getCustomObject());
            }
            else if (checkBox11.isSelected()) {
                System.out.println("Selected: " + checkBox11.getText());
            }
            else if (checkBox12.isSelected()) {
                System.out.println("Selected: " + checkBox12.getText());
            }
            else if (checkBox13.isSelected()) {
                System.out.println("Selected: " + checkBox13.getText());
            }
        });
        panelOfCar.add(displayButton);

//        JScrollPane infoScroll = new JScrollPane(infoOfCarsPanel);
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(displayButton);
//        infoOfCarsPanel.add(buttonPanel);
//        infoOfCarsPanel.add(infoScroll);

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
            return name + " 차량 번호 : " + value;
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
