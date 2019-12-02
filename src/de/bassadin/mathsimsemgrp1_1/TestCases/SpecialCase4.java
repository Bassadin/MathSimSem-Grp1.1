package de.bassadin.mathsimsemgrp1_1.TestCases;

import de.bassadin.mathsimsemgrp1_1.BaseSpringSimulation;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

public class SpecialCase4 {
    public static void main(String[] args) {
        //Same Weight
        //No start speed for second object
        //Equilibrium distance is equal to masses distance
        // -> Bodies move ('worm' like movement), center of mass moves in positive x direction
        BaseSpringSimulation testObjekt = new BaseSpringSimulation(
                Constants.testCaseDefaultMass,
                Constants.testCaseDefaultMass,
                18,
                300,
                100,
                400,
                50,
                0
        );
    }
}
