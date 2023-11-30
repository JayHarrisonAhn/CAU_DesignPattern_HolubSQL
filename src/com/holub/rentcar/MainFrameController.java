package com.holub.rentcar;

import com.holub.rentcar.views.MainFrameView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController extends JFrame implements ActionListener, ChangeListener {
    MainFrameModel model = new MainFrameModel();
    MainFrameView view;
    MainFrameController() {
        this.view = new MainFrameView(model, this);
        this.view.menuSelectionView.loginBtn.addActionListener(this);
        this.view.menuSelectionView.infoBtn.addActionListener(this);
        this.view.menuSelectionView.locationBtn.addActionListener(this);
        this.view.menuSelectionView.timeBtn.addActionListener(this);
        this.view.menuSelectionView.resultBtn.addActionListener(this);
        this.view.menuSelectionView.reservationsBtn.addActionListener(this);
        this.view.menuView.panelOfResult.bookButton.addActionListener(this);
        model.addObserver(this.view);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        setTime();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.menuSelectionView.loginBtn)) {
            model.setUserId(this.view.menuView.login.textField.getText());
        } else if (e.getSource().equals(view.menuSelectionView.infoBtn)) {
            model.changeMenu("info");
        } else if (e.getSource().equals(view.menuSelectionView.locationBtn)) {
            model.changeMenu("location");
        } else if (e.getSource().equals(view.menuSelectionView.timeBtn)) {
            model.changeMenu("time");
        } else if (e.getSource().equals(view.menuSelectionView.resultBtn)) {
            model.searchResults();
            model.changeMenu("result");
        } else if (e.getSource().equals(view.menuSelectionView.reservationsBtn)) {
            model.changeMenu("reservations");
        } else if (e.getSource().equals(view.menuView.panelOfResult.bookButton)){
            model.reservationCar(view.menuView.panelOfResult.resultOfTable.getSelectedRow());
        } else if (e.getSource().equals(view.currentTime)){

        }
    }

    public void stateChanged(ChangeEvent e) {
        setTime();
    }

    public void setCarInfoCheckbox(int i, boolean checked) {
        model.checkInfo(i, checked);
    }
    public void setPlaceInfoCheckbox(int i, boolean checked) {
        model.checkPlace(i, checked);
    }
    public void setTime() {
        int year = (int) this.view.menuView.panelOfTime.yearSpinner.getValue();
        int month = (int) this.view.menuView.panelOfTime.monthSpinner.getValue();
        int day = (int) this.view.menuView.panelOfTime.daySpinner.getValue();
        this.view.menuView.panelOfTime.yearSpinner.removeChangeListener(this);
        this.view.menuView.panelOfTime.monthSpinner.removeChangeListener(this);
        this.view.menuView.panelOfTime.daySpinner.removeChangeListener(this);
        model.changeTime(year, month, day);
        this.view.menuView.panelOfTime.yearSpinner.addChangeListener(this);
        this.view.menuView.panelOfTime.monthSpinner.addChangeListener(this);
        this.view.menuView.panelOfTime.daySpinner.addChangeListener(this);
    }

    public static void main(String[] args) {
        MainFrameController controller = new MainFrameController();
    }
}
