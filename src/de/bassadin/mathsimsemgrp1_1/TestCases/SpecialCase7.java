package de.bassadin.mathsimsemgrp1_1.TestCases;

import de.bassadin.mathsimsemgrp1_1.BaseSpringSimulation;

public class SpecialCase7 {
    public static void main(String[] args) {
        //Same Weight
        //No start speed
        //Equilibrium distance is equal to masses start distance
        //Both start speeds are not 0 and equal
        // -> Bodies move next to each other continuously
        BaseSpringSimulation testObjekt = new BaseSpringSimulation(
                3f,
                4f,
                70,
                300,
                300,
                380,
                0,
                50
        );
    }
}
