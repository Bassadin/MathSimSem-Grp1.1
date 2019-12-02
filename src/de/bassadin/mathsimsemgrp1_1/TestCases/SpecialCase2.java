package de.bassadin.mathsimsemgrp1_1.TestCases;

import de.bassadin.mathsimsemgrp1_1.BaseSpringSimulation;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

public class SpecialCase2 {
    public static void main(String[] args) {
        //Same Weight
        //No start speed
        //Equilibrium distance is less than masses distance
        // -> Bodies move inward, but center of mass does not move
        BaseSpringSimulation testObjekt = new BaseSpringSimulation(
                Constants.testCaseDefaultMass,
                Constants.testCaseDefaultMass,
                18,
                450,
                200,
                800,
                0,
                0
        );
    }
}
