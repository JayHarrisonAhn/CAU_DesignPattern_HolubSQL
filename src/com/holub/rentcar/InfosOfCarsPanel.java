package com.holub.rentcar;

import java.awt.*;
import javax.swing.*;

public class InfosOfCarsPanel extends JPanel{
    public JPanel infoOfCarsPanel = new JPanel();
    InfosOfCarsPanel() {
        CustomObject car1 = new CustomObject("cona", 7001);
        CustomObject car2 = new CustomObject("cona", 7002);  // doesn't need to show to User
        CustomObject car3 = new CustomObject("sportage", 8001);
        CustomObject car4 = new CustomObject("ev6", 9001);

        CustomCheckBox checkBox1 = new CustomCheckBox(car1);
        CustomCheckBox checkBox3 = new CustomCheckBox(car3);
        CustomCheckBox checkBox4 = new CustomCheckBox(car4);
        CustomCheckBox checkBox5 = new CustomCheckBox(car1);
        CustomCheckBox checkBox6 = new CustomCheckBox(car3);
        CustomCheckBox checkBox7 = new CustomCheckBox(car4);
        CustomCheckBox checkBox8 = new CustomCheckBox(car1);
        CustomCheckBox checkBox9 = new CustomCheckBox(car3);
        CustomCheckBox checkBox10 = new CustomCheckBox(car4);
        CustomCheckBox checkBox11 = new CustomCheckBox(car1);
        CustomCheckBox checkBox12 = new CustomCheckBox(car3);
        CustomCheckBox checkBox13 = new CustomCheckBox(car4);
        CustomCheckBox checkBox14 = new CustomCheckBox(car1);
        CustomCheckBox checkBox15 = new CustomCheckBox(car3);
        CustomCheckBox checkBox16 = new CustomCheckBox(car1);
        CustomCheckBox checkBox17 = new CustomCheckBox(car3);
        CustomCheckBox checkBox18 = new CustomCheckBox(car4);
        CustomCheckBox checkBox19 = new CustomCheckBox(car1);
        CustomCheckBox checkBox20 = new CustomCheckBox(car4);
        CustomCheckBox checkBox21 = new CustomCheckBox(car1);
        CustomCheckBox checkBox22 = new CustomCheckBox(car3);
        CustomCheckBox checkBox23 = new CustomCheckBox(car4);


        infoOfCarsPanel.setLayout(new BoxLayout(infoOfCarsPanel,BoxLayout.Y_AXIS));
        infoOfCarsPanel.add(checkBox1);
        infoOfCarsPanel.add(checkBox3);
        infoOfCarsPanel.add(checkBox4);
        infoOfCarsPanel.add(checkBox5);
        infoOfCarsPanel.add(checkBox6);
        infoOfCarsPanel.add(checkBox7);
        infoOfCarsPanel.add(checkBox8);
        infoOfCarsPanel.add(checkBox9);
        infoOfCarsPanel.add(checkBox10);
        infoOfCarsPanel.add(checkBox11);
        infoOfCarsPanel.add(checkBox13);
        infoOfCarsPanel.add(checkBox14);
        infoOfCarsPanel.add(checkBox15);
        infoOfCarsPanel.add(checkBox16);
        infoOfCarsPanel.add(checkBox17);
        infoOfCarsPanel.add(checkBox18);
        infoOfCarsPanel.add(checkBox19);
        infoOfCarsPanel.add(checkBox20);
        infoOfCarsPanel.add(checkBox21);
        infoOfCarsPanel.add(checkBox22);
        infoOfCarsPanel.add(checkBox23);



        JButton displayButton = new JButton("Select");
        displayButton.addActionListener(e -> {
            if (checkBox1.isSelected()) {
                System.out.println("Selected: " + checkBox1.getCustomObject());
            }
            if (checkBox3.isSelected()) {
                System.out.println("Selected: " + checkBox3.getCustomObject());
            }
            if (checkBox4.isSelected()) {
                System.out.println("Selected: " + checkBox3.getCustomObject());
            }
        });
        infoOfCarsPanel.add(displayButton);

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
