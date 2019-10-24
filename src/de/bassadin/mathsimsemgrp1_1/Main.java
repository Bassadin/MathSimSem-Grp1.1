package de.bassadin.mathsimsemgrp1_1;

import de.bassadin.mathsimsemgrp1_1.Objects2D.Object2D;
import de.bassadin.mathsimsemgrp1_1.Objects2D.Quad;
import de.bassadin.mathsimsemgrp1_1.Objects2D.QuadBody;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends JFrame {
    ArrayList<Object2D> sceneObjects = new ArrayList<Object2D>();

    QuadBody quad1 = new QuadBody(100, 100, 150, 150);
    QuadBody quad2 = new QuadBody(400, 100, 150, 150);

    public Main() {
        //Window Setup
        setTitle("Harmonische Bewegung zweier gekoppelter Massen");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Object Setup
        sceneObjects.add(quad1);
        quad2.setColor(Color.RED);
        sceneObjects.add(quad2);

        quad1.setPosX(quad1.getPosX() + 120);
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

        quad1.setPosX((int)(Math.sin(deltaTime * 10) * 140) + 300);
        quad1.setPosY((int)(Math.cos(deltaTime * 10) * 40) + 350);

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


