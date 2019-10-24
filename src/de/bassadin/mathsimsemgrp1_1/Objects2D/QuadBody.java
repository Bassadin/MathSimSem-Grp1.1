package de.bassadin.mathsimsemgrp1_1.Objects2D;

public class QuadBody extends Quad {
    protected double mass = 2.0;

    public QuadBody(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
