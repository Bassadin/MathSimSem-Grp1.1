package de.bassadin.mathsimsemgrp1_1.Objects2D;

import java.awt.*;

public class Quad extends Object2D {
    protected int width;
    protected int height;

    public Quad(int posX, int posY, int width, int height) {
        super(posX, posY);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, width, height);
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
