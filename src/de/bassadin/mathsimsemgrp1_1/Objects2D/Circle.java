package de.bassadin.mathsimsemgrp1_1.Objects2D;

import java.awt.*;

public class Circle extends Object2D {
    protected int width;
    protected int height;

    public Circle(double posX, double posY, int width, int height) {
        super(posX, posY);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)posX, (int)posY, width, height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
