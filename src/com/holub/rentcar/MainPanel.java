package com.holub.rentcar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame implements ActionListener {
    //    public JPanel mainPanel = new JPanel();
    public JPanel mainPanel = new JPanel(new CardLayout());
    private InfosOfCarsPanel infosOfCarsPanel;
    private PlacesOfCarsPanel placesOfCarsPanel;
    private TimeOfCarsPanel timeOfCarsPanel;
    private ResultOfCarsPanel resultOfCarsPanel;
    public JButton info = new JButton("차량정보");
    public JButton place = new JButton("위치");
    public JButton time = new JButton("대여시간");
    public JButton result = new JButton("결과");
    String shapeString = "차량정보";

    MainPanel() {
        infosOfCarsPanel = new InfosOfCarsPanel();
        placesOfCarsPanel = new PlacesOfCarsPanel();
        timeOfCarsPanel = new TimeOfCarsPanel();
        resultOfCarsPanel = new ResultOfCarsPanel();
        JScrollPane infoScroll = new JScrollPane(infosOfCarsPanel.infoOfCarsPanel);
        JScrollPane placeScroll = new JScrollPane(placesOfCarsPanel.placesOfCarsPanel);
        JScrollPane timeScroll = new JScrollPane(timeOfCarsPanel.timeOfCarsPanel);
        JScrollPane resultScroll = new JScrollPane(resultOfCarsPanel.resultOfCarsPanel);
        mainPanel.add(infoScroll, "info");
        mainPanel.add(placeScroll, "place");
        mainPanel.add(timeScroll, "time");
        mainPanel.add(resultScroll, "result");

        place.addActionListener(this);
        place.setSize(80, 80);
        info.addActionListener(this);
        info.setSize(80, 80);
        time.addActionListener(this);
        time.setSize(80, 80);
        result.addActionListener(this);
        result.setSize(80, 80);

    }

    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout(); // mainPanel.setLayout(cardLayout);

        if (e.getSource().getClass().toString().contains("JButton")) {
            shapeString = e.getActionCommand();
            if (e.getActionCommand().toString() == "차량정보") {
                shapeString = "info";
                cardLayout.show(mainPanel, shapeString);
            } else if (e.getActionCommand().toString() == "위치") {
                shapeString = "place";
                cardLayout.show(mainPanel, shapeString);
            } else if (e.getActionCommand().toString() == "대여시간") {
                shapeString = "time";
                cardLayout.show(mainPanel, shapeString);
            } else if (e.getActionCommand().toString() == "결과") {

                shapeString = "result";
                cardLayout.show(mainPanel, shapeString);
//                JFrame newFrame = new JFrame("New Frame");
//                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                newFrame.setSize(300, 200);
//                newFrame.setLocationRelativeTo(null);
//                newFrame.setLayout(new BorderLayout());
//                JPanel resultPanel = new JPanel(cardLayout);
//                cardLayout.show(resultPanel, shapeString);
//                newFrame.add(resultPanel).set;
//                newFrame.setVisible(true);

//                showNewFrame(newFrame, mainPanel, cardLayout, shapeString);
//                cardLayout.show(mainPanel, shapeString);
            }
        }
    }
}