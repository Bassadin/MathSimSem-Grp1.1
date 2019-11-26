package de.bassadin.mathsimsemgrp1_1;

import de.bassadin.mathsimsemgrp1_1.Objects2D.*;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;
import de.bassadin.mathsimsemgrp1_1.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SpringSimulation extends JFrame {
    ArrayList<Object2D> sceneObjects = new ArrayList<Object2D>();

    float mass1 = 6f;
    float mass2 = 6f;

    float springConstant = 10;
    float equilibriumDistance = 0.5f;
    float startPosition1 = 500;
    float startPosition2 = 600;
    float startSpeed1 = 30;
    float startSpeed2 = 0;

    float reducedMass = Utils.reducedMass(mass1, mass2);
    double sqrtDDividedByMu = Math.sqrt(springConstant / reducedMass);

    float A = startPosition2 - startPosition1 - springConstant;
    double B = (1 / sqrtDDividedByMu) * (startSpeed2 - startSpeed1);

    float equilibriumSpeedAtT0 = 1 / (mass1 + mass2) * (mass1 * startSpeed1 + mass2 * startSpeed2);

    int body1SideLength = Utils.widthAndHeightForMass(mass1);
    int body2SideLength = Utils.widthAndHeightForMass(mass2);

    QuadBody quadBody1 = new QuadBody(startPosition1, 300 - body1SideLength / 2, body1SideLength, body1SideLength, mass1);
    QuadBody quadBody2 = new QuadBody(startPosition2, 300 - body2SideLength / 2, body2SideLength, body2SideLength, mass2);
    Quad spring = new Quad(0, 300 - (int)(quadBody1.getHeight() * 0.2) / 2, 0, (int)(quadBody1.getHeight() * 0.2)); //Position will be updated in draw
    Circle centerOfMass = new Circle(0, 300 - (int)(quadBody1.getHeight() * 0.4) / 2, (int)(quadBody1.getHeight() * 0.4), (int)(quadBody1.getHeight() * 0.4));

    public SpringSimulation() {
        //Window Setup
        setTitle("Harmonische Bewegung zweier gekoppelter Massen");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Object Setup
        sceneObjects.add(quadBody1);
        quadBody2.setColor(Color.RED);
        sceneObjects.add(quadBody2);
        sceneObjects.add(spring);

        centerOfMass.setColor(Color.CYAN);
        sceneObjects.add(centerOfMass);

        quadBody1.setPosX(quadBody1.getPosX() + 120);
    }

    public static void main(String[] args) {
        SpringSimulation testObjekt = new SpringSimulation();

        testObjekt.setVisible(true);
        double deltaTime = 0;
        while (true) {
            testObjekt.draw(deltaTime);
            try {
                Thread.sleep((int) (Constants.TPF * 1000));
                deltaTime += Constants.TPF;
            } catch (InterruptedException e) {
            }
        }

    }

    void draw(double deltaTime) {
        Graphics g = getGraphics();

        //Fill Scene Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        float equilibriumPositionAtT = (startPosition1 + equilibriumDistance / 2) + (1 / (mass1 + mass2) * (mass1 * startSpeed1 + mass2 * startSpeed2)) * (float)deltaTime;
        centerOfMass.setPosX(equilibriumPositionAtT);

        double sVonT = A * Math.cos(sqrtDDividedByMu * deltaTime) + B * Math.sin(sqrtDDividedByMu * deltaTime) + startPosition1;

        quadBody1.setPosX(equilibriumPositionAtT - ((mass2 * (sVonT + equilibriumDistance)) / mass1 + mass2)); //Position
        quadBody2.setPosX(equilibriumPositionAtT + (mass1 / (mass1 + mass2)) * (sVonT - equilibriumDistance)); //Position


        spring.setPosX(quadBody1.getPosX() + quadBody1.getWidth());
        spring.setWidth((int)(quadBody2.getPosX() - quadBody1.getPosX() - quadBody1.getWidth() + 2));

        if (spring.getWidth() < 0) {
            spring.setPosX(spring.getPosX() + spring.getWidth() + quadBody2.getWidth());
            spring.setWidth(spring.getWidth() * -1 - quadBody1.getWidth());
        }

        drawSceneObjects(g);
    }

    void drawSceneObjects(Graphics g) {
        Iterator<Object2D> iterator = sceneObjects.iterator();
        while (iterator.hasNext()) {
            Object2D object = iterator.next();
            object.draw(g);
        }
    }
}


