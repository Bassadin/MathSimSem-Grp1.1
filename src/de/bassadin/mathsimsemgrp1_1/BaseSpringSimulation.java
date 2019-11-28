package de.bassadin.mathsimsemgrp1_1;

import de.bassadin.mathsimsemgrp1_1.Objects2D.*;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;
import de.bassadin.mathsimsemgrp1_1.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseSpringSimulation extends JFrame {
    public float mass1;
    public float mass2;

    public float springConstant;
    public float equilibriumDistance;
    public float startPosition1;
    public float startPosition2;
    public float startSpeed1;
    public float startSpeed2;

    private ArrayList<Object2D> sceneObjects = new ArrayList<Object2D>();

    private float reducedMass;
    private double sqrtDDividedByMu;

    private float A;
    private double B;

    private float equilibriumSpeedAtT0;

    private int body1SideLength, body2SideLength;

    private QuadBody quadBody1, quadBody2;

    private int springWidth;
    private Quad spring;

    private int centerOfMassSideLength;
    private Circle centerOfMass;

    public BaseSpringSimulation(float mass1, float mass2, float springConstant, float equilibriumDistance, float startPosition1, float startPosition2, float startSpeed1, float startSpeed2) {
        //Set vars
        this.mass1 = mass1;
        this.mass2 = mass2;
        this.springConstant = springConstant;
        this.equilibriumDistance = equilibriumDistance;
        this.startPosition1 = startPosition1;
        this.startPosition2 = startPosition2;
        this.startSpeed1 = startSpeed1;
        this.startSpeed2 = startSpeed2;

        reducedMass = Utils.reducedMass(mass1, mass2);
        sqrtDDividedByMu = Math.sqrt(springConstant / reducedMass);

        A = startPosition2 - startPosition1 - springConstant;
        B = (1 / sqrtDDividedByMu) * (startSpeed2 - startSpeed1);

        equilibriumSpeedAtT0 = 1 / (mass1 + mass2) * (mass1 * startSpeed1 + mass2 * startSpeed2);

        body1SideLength = Utils.widthAndHeightForMass(mass1);
        body2SideLength = Utils.widthAndHeightForMass(mass2);

        quadBody1 = new QuadBody(startPosition1, 300 - body1SideLength / 2, body1SideLength, body1SideLength, mass1);
        quadBody2 = new QuadBody(startPosition2, 300 - body2SideLength / 2, body2SideLength, body2SideLength, mass2);

        springWidth = (int) (quadBody1.getHeight() * 0.16);
        spring = new Quad(0, 300 - springWidth / 2, 0, springWidth); //Position will be updated in draw

        centerOfMassSideLength = (int) (quadBody1.getHeight() * 0.3);
        centerOfMass = new Circle(0, 300 - centerOfMassSideLength / 2, centerOfMassSideLength, centerOfMassSideLength);

        //Object Setup
        sceneObjects.add(quadBody1);
        quadBody2.setColor(Color.RED);
        sceneObjects.add(quadBody2);
        sceneObjects.add(spring);

        centerOfMass.setColor(Color.CYAN);
        sceneObjects.add(centerOfMass);

        quadBody1.setPosX(quadBody1.getPosX() + 120);

        //Window Setup
        setTitle("Harmonische Bewegung zweier gekoppelter Massen");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
        double deltaTime = 0;
        while (true) {
            this.draw(deltaTime);
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

        float equilibriumPositionAtT = (startPosition1 + equilibriumDistance / 2) + (1 / (mass1 + mass2) * (mass1 * startSpeed1 + mass2 * startSpeed2)) * (float) deltaTime;
        centerOfMass.setPosX(equilibriumPositionAtT - centerOfMassSideLength / 2);

        double sVonT = A * Math.cos(sqrtDDividedByMu * deltaTime) + B * Math.sin(sqrtDDividedByMu * deltaTime) + startPosition1;

        quadBody1.setPosX(equilibriumPositionAtT - ((mass2 * (sVonT + equilibriumDistance)) / mass1 + mass2)); //Position
        quadBody2.setPosX(equilibriumPositionAtT + (mass1 / (mass1 + mass2)) * (sVonT - equilibriumDistance)); //Position


        spring.setPosX(quadBody1.getPosX() + quadBody1.getWidth());
        spring.setWidth((int) (quadBody2.getPosX() - quadBody1.getPosX() - quadBody1.getWidth() + 2));

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


