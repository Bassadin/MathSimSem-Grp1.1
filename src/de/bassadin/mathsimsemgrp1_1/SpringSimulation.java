package de.bassadin.mathsimsemgrp1_1;

import de.bassadin.mathsimsemgrp1_1.Objects2D.*;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SpringSimulation extends JFrame {
    ArrayList<Object2D> sceneObjects = new ArrayList<Object2D>();

    float mass1 = 1.5f;
    float mass2 = 2;
    float SpringConstant = 1;
    float equilibirumDistance = 5;
    float startPosition1 = 50;
    float startPosition2 = 450;
    float startSpeed1 = 1;
    float startSpeed2 = 3;

    QuadBody quadBody1 = new QuadBody(startPosition1, 125, 150, 150, mass1);
    QuadBody quadBody2 = new QuadBody(startPosition2, 100, 200, 200, mass2);
    Quad spring = new Quad(200, 190, 250, 20);

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


