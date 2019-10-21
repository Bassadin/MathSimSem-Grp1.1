import de.bassadin.mathsimsemgrp1_1.Objects2D.Object2D;
import de.bassadin.mathsimsemgrp1_1.Objects2D.Quad;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends JFrame {
    ArrayList<Object2D> sceneObjects = new ArrayList<Object2D>();

    public Main() {
        //Window Setup
        setTitle("Harmonische Bewegung zweier gekoppelter Massen");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Object Setup
        sceneObjects.add(new Quad(100, 100, 150, 150));
        Quad quad2 = new Quad(400, 100, 150, 150);
        quad2.setColor(Color.RED);
        sceneObjects.add(quad2);
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
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        Iterator<Object2D> iterator = sceneObjects.iterator();
        while (iterator.hasNext()) {
            Object2D object = iterator.next();
            object.draw(g);
        }
    }
}

