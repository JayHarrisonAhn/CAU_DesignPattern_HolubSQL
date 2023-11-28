package com.holub.rentcar.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PanelOfTimes extends JPanel{
    public JPanel panelOfTime = new JPanel();
    PanelOfTimes() {
        JLabel dateTimeLabel = new JLabel("Current Date and Time: ");
        JButton currentTime = new JButton("현재 시간");
        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(2023, 1900, 2100, 1));
        JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));

//        Box b1 = Box.createHorizontalBox();
//        b1.add(Box.createHorizontalGlue());
//        b1.add(yearSpinner);
//        b1.add(Box.createHorizontalGlue());
//        Box b2 = Box.createHorizontalBox();
//        b2.add(Box.createHorizontalGlue());
//        b2.add(monthSpinner);
//        b2.add(Box.createHorizontalGlue());
//        Box b3 = Box.createHorizontalBox();
//        b3.add(Box.createHorizontalGlue());
//        b3.add(daySpinner);
//        b3.add(Box.createHorizontalGlue());

//        Box toolBox = new Box(BoxLayout.X_AXIS);
//        Box dateBox = new Box(BoxLayout.X_AXIS);
//        toolBox.add(b1);
//        toolBox.add(b2);
//        toolBox.add(b3);
//        dateBox.add(toolBox);
        panelOfTime.setLayout(new BoxLayout(panelOfTime,BoxLayout.Y_AXIS));
        panelOfTime.add(new JLabel("Year : "));
        panelOfTime.add(yearSpinner);
        panelOfTime.add(new JLabel("Month : "));
        panelOfTime.add(monthSpinner);
        panelOfTime.add(new JLabel("Day : "));
        panelOfTime.add(daySpinner);

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

//        panelOfTime.add(dateBox, BorderLayout.CENTER);
        panelOfTime.add(dateTimeLabel,BorderLayout.SOUTH);
        panelOfTime.add(currentTime, BorderLayout.SOUTH);
        panelOfTime.add(selectButton, BorderLayout.SOUTH);
        currentTime.addActionListener(e -> {
            timer.restart();
            LocalDateTime currentDateTime = LocalDateTime.now();
            yearSpinner.setValue(currentDateTime.getYear());
            monthSpinner.setValue(currentDateTime.getMonthValue());
            daySpinner.setValue(currentDateTime.getDayOfMonth());

            System.out.println("timer restart");
        });
    }
}
