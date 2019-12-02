package de.bassadin.mathsimsemgrp1_1.TestCases;

import de.bassadin.mathsimsemgrp1_1.BaseSpringSimulation;
import de.bassadin.mathsimsemgrp1_1.utils.Constants;

public class SpecialCase3 {
    public static void main(String[] args) {
        //Same Weight
        //No start speed
        //Equilibrium distance is greater than masses distance
        // -> Bodies move outward, but center of mass does not move
        BaseSpringSimulation testObjekt = new BaseSpringSimulation(
                Constants.testCaseDefaultMass,
                Constants.testCaseDefaultMass,
                18,
                550,
                300,
                700,
                0,
                0
        );
    }
}
