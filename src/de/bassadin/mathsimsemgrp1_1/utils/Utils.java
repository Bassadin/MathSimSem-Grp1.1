package de.bassadin.mathsimsemgrp1_1.utils;

import static de.bassadin.mathsimsemgrp1_1.utils.Constants.*;

public class Utils {
    public static float reducedMass(float mass1, float mass2) {
        return (mass1 * mass2) / (mass1 + mass2);
    }

    public static int widthAndHeightForMass(double mass) {
        return (int)(massSizeMultiplicator * mass);
    }
}
