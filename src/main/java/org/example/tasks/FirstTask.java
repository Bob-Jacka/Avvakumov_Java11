package org.example.tasks;

import static java.lang.Math.round;

abstract class FirstTask {

    static void getHello(final double number) {
        if (round(number) > 7) {
            System.out.println("Привет");
        }
    }
}