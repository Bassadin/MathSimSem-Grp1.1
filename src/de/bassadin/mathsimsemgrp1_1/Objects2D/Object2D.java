package de.bassadin.mathsimsemgrp1_1.Objects2D;

import java.awt.*;

public abstract class Object2D {
    protected int posX;
    protected int posY;
    protected Color color = Color.BLACK; //Standard color

    public Object2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract void draw(Graphics g);

    //public abstract void update(double deltaTime);

    public void move(int moveX, int moveY) {
        this.posX += moveX;
        this.posY += moveY;
    }

    public void printPosition() {
        System.out.println("Position: X=" + this.getPosX() + ", Y=" + this.getPosY());
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
