package de.bassadin.mathsimsemgrp1_1.utils;

import de.bassadin.mathsimsemgrp1_1.Objects2D.Object2D;
import de.bassadin.mathsimsemgrp1_1.Objects2D.Quad;
import de.bassadin.mathsimsemgrp1_1.Objects2D.QuadBody;

public class SimulationFormulas {

    float startDistant;
    float startSpeed1;
    float startSpeed2;

    public static float speed(float mass1, float mass2, float startSpeed1, float startSpeed2, float deltaTime){
        float speed = (1 / mass1 + mass2) * ((mass1 * (startSpeed1 * deltaTime) + (mass2 * (startSpeed2 * deltaTime))));
        return speed;
    }


}
