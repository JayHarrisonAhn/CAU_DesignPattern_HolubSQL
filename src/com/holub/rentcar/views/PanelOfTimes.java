package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Observable;

public class PanelOfTimes extends MainFrameComponentView {
    public JPanel panelOfTime = new JPanel();
    public JSpinner yearSpinner = new JSpinner();
    public JSpinner monthSpinner = new JSpinner();
    public JSpinner daySpinner = new JSpinner();
    PanelOfTimes(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
        JLabel dateTimeLabel = new JLabel("Current Date and Time: ");
        JButton currentTime = new JButton("현재 시간");

        panelOfTime.setLayout(new BoxLayout(panelOfTime,BoxLayout.Y_AXIS));
        panelOfTime.add(new JLabel("Year : "));
        panelOfTime.add(yearSpinner);
        panelOfTime.add(new JLabel("Month : "));
        panelOfTime.add(monthSpinner);
        panelOfTime.add(new JLabel("Day : "));
        panelOfTime.add(daySpinner);

        JButton selectButton = new JButton("Select");
        panelOfTime.add(dateTimeLabel,BorderLayout.SOUTH);
        panelOfTime.add(currentTime, BorderLayout.SOUTH);
        panelOfTime.add(selectButton, BorderLayout.SOUTH);

        updateSpinners();
    }

    @Override
    public void update(Observable o, Object arg) {
        updateSpinners();
    }

    public void updateSpinners() {
        yearSpinner.setValue(model.year);
        monthSpinner.setValue(model.month);
        daySpinner.setValue(model.day);
    }
}
