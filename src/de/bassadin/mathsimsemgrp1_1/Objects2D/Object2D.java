package de.bassadin.mathsimsemgrp1_1.Objects2D;

import java.awt.*;

public abstract class Object2D {
    protected double posX;
    protected double posY;
    protected Color color = Color.BLACK; //Standard color

    public Object2D(double posX, double posY) {
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

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
