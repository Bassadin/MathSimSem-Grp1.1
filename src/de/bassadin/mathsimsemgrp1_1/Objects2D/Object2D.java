package de.bassadin.mathsimsemgrp1_1.Objects2D;

import java.awt.*;

public abstract class Object2D {
    protected float posX;
    protected float posY;
    protected Color color = Color.BLACK; //Standard color

    public Object2D(float posX, float posY) {
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

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
