package com.company;

public class Converter {

    double stepsToKilometers(int steps) {
        double kilometers;
        kilometers = steps / 0.75 / 1000;
        return kilometers;
    }

    double stepsToCalories(int steps) {
        double calories;
        calories = steps / 50.0 / 1000;
        return calories;
    }
}
