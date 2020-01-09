package de.bassadin.mathsimsemgrp1_1.TestCases;

import de.bassadin.mathsimsemgrp1_1.BaseSpringSimulation;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

public class SpecialCase6 {
    public static void main(String[] args) {
        //Same Weight
        //No start speed
        //Equilibrium distance is equal to masses start distance
        //Both start speeds are not 0 and equal
        // -> Bodies move next to each other continuously
        BaseSpringSimulation testObjekt = new BaseSpringSimulation(
                20f,
                10f,
                18,
                300,
                200,
                500,
                0,
                50
        );
    }
}
