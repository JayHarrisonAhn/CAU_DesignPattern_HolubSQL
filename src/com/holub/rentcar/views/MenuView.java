package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameModel;
import com.holub.rentcar.PanelOfPlace;
import com.holub.rentcar.PanelOfTime;

import javax.print.attribute.standard.JobMediaSheetsCompleted;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class MenuView extends MainFrameComponentView {
    PanelOfCars panelOfCar = new PanelOfCars();
    PanelOfPlaces panelOfPlace = new PanelOfPlaces();
    PanelOfTimes panelOfTime = new PanelOfTimes();
    PanelOfResults panelOfResult = new PanelOfResults();
    MenuView(MainFrameModel model) {
        super(model);
        setLayout(new CardLayout());
        add(new JScrollPane(panelOfCar.panelOfCar), "info");
        add(new JScrollPane(panelOfPlace.panelOfPlace), "location");
        add(new JScrollPane(panelOfTime.panelOfTime), "time");
        add(new JScrollPane(panelOfResult.panelOfResult), "result");
    }

    public void update(Observable o, Object arg) {
        CardLayout cardLayout = (CardLayout) getLayout();
        cardLayout.show(this, model.currentMenu);
    }
}