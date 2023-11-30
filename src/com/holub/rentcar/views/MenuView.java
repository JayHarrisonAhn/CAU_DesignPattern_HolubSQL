package com.holub.rentcar.views;

import com.holub.rentcar.MainFrameController;
import com.holub.rentcar.MainFrameModel;
import com.holub.rentcar.PanelOfPlace;
import com.holub.rentcar.PanelOfTime;

import javax.print.attribute.standard.JobMediaSheetsCompleted;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class MenuView extends MainFrameComponentView {
    public PanelOfLogin login = new PanelOfLogin(model, controller);
    public PanelOfCars panelOfCar = new PanelOfCars(model, controller);
    public PanelOfPlaces panelOfPlace = new PanelOfPlaces(model, controller);
    public PanelOfTimes panelOfTime = new PanelOfTimes(model, controller);
    public PanelOfResults panelOfResult = new PanelOfResults(model, controller);
    MenuView(MainFrameModel model, MainFrameController controller) {
        super(model, controller);
        setLayout(new CardLayout());
        add(new JScrollPane(login), "login");
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