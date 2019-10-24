package de.bassadin.mathsimsemgrp1_1;

import de.bassadin.mathsimsemgrp1_1.Objects2D.Object2D;
import de.bassadin.mathsimsemgrp1_1.Objects2D.QuadBody;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends JFrame {
    ArrayList<Object2D> sceneObjects = new ArrayList<Object2D>();

    QuadBody quadBody1 = new QuadBody(50, 125, 150, 150, 1.5);
    QuadBody quadBody2 = new QuadBody(450, 100, 200, 200, 2);

    public Main() {
        //Window Setup
        setTitle("Harmonische Bewegung zweier gekoppelter Massen");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Object Setup
        sceneObjects.add(quadBody1);
        quadBody2.setColor(Color.RED);
        sceneObjects.add(quadBody2);

        quadBody1.setPosX(quadBody1.getPosX() + 120);
    }

    public static void main(String[] args) {
        Main testObjekt = new Main();

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


