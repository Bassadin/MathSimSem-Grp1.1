package de.bassadin.mathsimsemgrp1_1.TestCases;

import de.bassadin.mathsimsemgrp1_1.BaseSpringSimulation;

public class SpecialCase1 {
    public static void main(String[] args) {
        //Same Weight
        //No start speed
        //Equilibrium distance is equal to masses distance -> no movement
        BaseSpringSimulation testObjekt = new BaseSpringSimulation(
                9f,
                9f,
                12,
                200,
                200,
                400,
                0,
                0
        );
    }
}
