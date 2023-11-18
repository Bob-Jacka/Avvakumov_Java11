package org.example.tasks;

import java.util.List;

abstract class ThirdTask {

    static void getNumbers(List<Double> numbers) {
        for (double i : numbers) {
            if (i % 3 == 0) {
                System.out.println("Число кратное трём: " + i);
            }
        }
    }
}
