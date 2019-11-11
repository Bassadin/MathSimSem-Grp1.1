package de.bassadin.mathsimsemgrp1_1;

import de.bassadin.mathsimsemgrp1_1.Objects2D.*;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class SpringSimulation extends JFrame {
    ArrayList<Object2D> sceneObjects = new ArrayList<Object2D>();

    private BufferedImage backBuffer;

    float mass1 = 2f;
    float mass2 = 2f;
    float SpringConstant = 1;
    float equilibirumDistance = 5;
    float startPosition1 = 600;
    float startPosition2 = 800;
    float startSpeed1 = 1;
    float startSpeed2 = 3;

    double rootSpringPerMass = Math.sqrt(SpringConstant/mass1);

    float A = startPosition1 / 2;
    float B = startPosition2 / 2;

    QuadBody quadBody1 = new QuadBody(startPosition1, 150, 50, 50, mass1);
    QuadBody quadBody2 = new QuadBody(startPosition2, 150, 50, 50, mass2);
    Quad spring = new Quad(Constants.WINDOW_WIDTH/2, Constants.WINDOW_HEIGHT/2, 1200, 20);

    public SpringSimulation() {
        //Window Setup
        setTitle("Harmonische Bewegung zweier gekoppelter Massen");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backBuffer = new BufferedImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);

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
        Graphics bbg = backBuffer.getGraphics();
        //Fill Scene Background
        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        quadBody1.setPosX((A * Math.cos(rootSpringPerMass * deltaTime) + startPosition1) / 2);
        //quadBody2.setPosY((-B * Math.sin(rootSpringPerMass * deltaTime) + startPosition2) / 2);
        quadBody2.setPosX((-B * Math.cos(rootSpringPerMass * deltaTime) + startPosition2) / 2);

        g.drawImage(backBuffer,0,0,null);
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


