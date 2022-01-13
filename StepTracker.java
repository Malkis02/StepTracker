package com.company;

import java.util.HashMap;

public class StepTracker {

    HashMap<String, int[]> stepsPerMonth = new HashMap<>();
    int targetStep = 10000;
    Converter converter = new Converter();


    void saveStepsPerDay(String month, int steps, int day) {
        if (stepsPerMonth.containsKey(month)) {
            int[] step = stepsPerMonth.get(month);
            step[day - 1] = steps;
        } else {
            int[] step2 = new int[30];
            step2[day - 1] = steps;
            stepsPerMonth.put(month, step2);
        }

    }

    void printStepsPerDayInMonth(String month) {
        if (stepsPerMonth.containsKey(month)) {
            int[] stepPerDay = stepsPerMonth.get(month);
            for (int i = 0; i < stepPerDay.length; i++) {
                System.out.print((i + 1) + " день: " + stepPerDay[i] + ", ");
            }

        }
    }

    int findSumStepsInMonth(String month) {
        int sum = 0;
        if (stepsPerMonth.containsKey(month)) {
            int[] sumOfSteps = stepsPerMonth.get(month);
            for (int result : sumOfSteps) {
                sum += result;
            }

        }
        return sum;
    }

    int getMaxStepsInMonth(String month) {
        int maxSteps = 0;
        if (stepsPerMonth.containsKey(month)) {
            int[] maxStep = stepsPerMonth.get(month);
            for (int result : maxStep) {
                if (result > maxSteps) {
                    maxSteps = result;

                }
            }


        }
        return maxSteps;
    }

    double getAverageOfStepsInMonth(String month) {
        int result = 0;
        if (stepsPerMonth.containsKey(month)) {
            int[] sumOfSteps = stepsPerMonth.get(month);
            for (int sum : sumOfSteps) {
                result = result + sum / sumOfSteps.length;
            }
        }
        return result;
    }

    int getBestSeriesInMonth(String month) {
        int maxSeriesInMonth = 0;
        int maxSeries = 0;
        if (stepsPerMonth.containsKey(month)) {
            int[] stepsByDay = stepsPerMonth.get(month);
            for (int steps : stepsByDay) {
                if (steps > targetStep) {
                    maxSeries += 1;
                } else {
                    if (maxSeries > maxSeriesInMonth) {
                        maxSeriesInMonth = maxSeries;
                    }
                    maxSeries = 0;
                }
            }
        }
        return maxSeriesInMonth;
    }

    void changeTargetStep(int targetSteps) {
        if (targetSteps > 0) {
            targetStep = targetSteps;
        } else {
            System.out.println("Нельзя выбрать отрицательное значение");
        }
    }

    double stepsToKilometers(String month) {
        double kilometers;
        kilometers = converter.stepsToKilometers(findSumStepsInMonth(month));
        return kilometers;
    }

    double stepsToCalories(String month) {

        double calories;
        calories = converter.stepsToCalories(findSumStepsInMonth(month));
        return calories;
    }

}
