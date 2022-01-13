package com.company;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("За какой месяц добавить шаги?");
                String month = scanner.next();
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                System.out.println("За какой день добавить шаги?");
                int day = scanner.nextInt();
                stepTracker.saveStepsPerDay(month, steps, day);
                System.out.println("Значение сохранено!");
            } else if (command == 2) {
                System.out.println("В каком месяце искать?");
                String month = scanner.next();
                System.out.println("Пройденная дистанция: " +
                        stepTracker.stepsToKilometers(month));
                System.out.println("Количество сожжённых килокалорий: " +
                        stepTracker.stepsToCalories(month));
                System.out.println("Среднее количество шагов за " + month + " составило: " +
                        stepTracker.getAverageOfStepsInMonth(month));
                System.out.println("Общее количество шагов за " + month + " составило:" +
                        stepTracker.findSumStepsInMonth(month));
                System.out.println("Максимальное количество шагов за " + month + " составило:" +
                        stepTracker.getMaxStepsInMonth(month));
                System.out.println("Лучшая серия в месяце: " +
                        stepTracker.getBestSeriesInMonth(month) + " дня");
                stepTracker.printStepsPerDayInMonth(month);
                System.out.println();
            } else if (command == 3) {
                System.out.println("Введите целевое количество шагов");
                int targetSteps = scanner.nextInt();
                stepTracker.changeTargetStep(targetSteps);
                System.out.println("Целевое количество шагов изменено!");
            } else if (command == 4) {
                break;
            } else {
                System.out.println("Извините,такой команды нет");
            }
        }

    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1-Ввести количество шагов за день");
        System.out.println("2-Напечатать статистику за месяц");
        System.out.println("3-Изменить цель по количеству шагов в день");
        System.out.println("4-Выйти из приложения");
    }
}





























