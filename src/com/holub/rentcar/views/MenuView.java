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
    PanelOfCars panelOfCar = new PanelOfCars(model);
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
        this.panelOfCar.update(o, arg);
//        this.panelOfPlace.update(o, arg);
    }

    @Override
    public void setController(MainFrameController controller) {
        super.setController(controller);
        this.panelOfCar.setController(controller);
//        this.panelOfPlace.setController(controller);
//        this.panelOfTime.setController(controller);
//        this.panelOfResult.setController(controller);
    }
}