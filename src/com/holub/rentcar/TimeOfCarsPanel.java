package com.holub.rentcar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class TimeOfCarsPanel extends JPanel{
    public JPanel timeOfCarsPanel = new JPanel();
    TimeOfCarsPanel() {
        JLabel dateTimeLabel = new JLabel("Current Date and Time: ");
        JButton currentTime = new JButton("현재시간");
        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(2023, 1900, 2100, 1));
        JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));

        timeOfCarsPanel.setLayout(new BoxLayout(timeOfCarsPanel,BoxLayout.Y_AXIS));
        timeOfCarsPanel.add(new JLabel("Year : "));
        timeOfCarsPanel.add(yearSpinner);
        timeOfCarsPanel.add(new JLabel("Month : "));
        timeOfCarsPanel.add(monthSpinner);
        timeOfCarsPanel.add(new JLabel("Day : "));
        timeOfCarsPanel.add(daySpinner);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime currentDateTime = LocalDateTime.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = currentDateTime.format(formatter);

                dateTimeLabel.setText("Current Date : " + formattedDate);
            }
        });

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> {
            int year = (int) yearSpinner.getValue();
            int month = (int) monthSpinner.getValue();
            int day = (int) daySpinner.getValue();

            LocalDate selectedDate = LocalDate.of(year, month, day);
            System.out.println(selectedDate);
        });

        timer.start();
        timeOfCarsPanel.add(dateTimeLabel);
        timeOfCarsPanel.add(currentTime);
        timeOfCarsPanel.add(selectButton);
        currentTime.addActionListener(e -> {
            timer.restart();
            LocalDateTime currentDateTime = LocalDateTime.now();
            yearSpinner.setValue(currentDateTime.getYear());
            monthSpinner.setValue(currentDateTime.getMonthValue());
            daySpinner.setValue(currentDateTime.getDayOfMonth());

            System.out.println("timer restart");
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
        private PlacesOfCarsPanel.CustomObject customObject;

        public CustomCheckBox(PlacesOfCarsPanel.CustomObject customObject) {
            super(customObject.toString());
            this.customObject = customObject;
        }

        public PlacesOfCarsPanel.CustomObject getCustomObject() {
            return customObject;
        }
    }
}
