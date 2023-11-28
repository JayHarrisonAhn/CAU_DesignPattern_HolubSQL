package com.holub.rentcar;

import com.holub.rentcar.views.MainFrameComponentView;
import com.holub.rentcar.views.MainFrameView;
import com.holub.rentcar.views.MenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainFrameController extends JFrame implements ActionListener {
    MainFrameModel model = new MainFrameModel();
    MainFrameView view;
    MainFrameController() {
        this.view = new MainFrameView(model, this);
        this.view.menuSelectionView.infoBtn.addActionListener(this);
        this.view.menuSelectionView.locationBtn.addActionListener(this);
        this.view.menuSelectionView.timeBtn.addActionListener(this);
        this.view.menuSelectionView.resultBtn.addActionListener(this);
        model.addObserver(this.view);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.menuSelectionView.infoBtn)) {
            model.changeMenu("info");
        } else if (e.getSource().equals(view.menuSelectionView.locationBtn)) {
            model.changeMenu("location");
        } else if (e.getSource().equals(view.menuSelectionView.timeBtn)) {
            model.changeMenu("time");
        } else if (e.getSource().equals(view.menuSelectionView.resultBtn)) {
            model.changeMenu("result");
        } else if (e.getSource().equals(view.selectBtn)){

        } else if (e.getSource().equals(view.currentTime)){

        }
    }

    public void setCarInfoCheckbox(int i, boolean checked) {
        model.checkInfo(i, checked);
    }
    public void setPlaceInfoCheckbox(int i, boolean checked) {
        model.checkPlace(i, checked);
    }

    public static void main(String[] args) {
        MainFrameController controller = new MainFrameController();
    }
}
