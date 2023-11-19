package org.example.tasks;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public abstract class ExecService {

    public static void execTasks(final String[] args) {
        int size = args.length;

        if (size == 0) {
            System.out.println("Введите значение");

        } else if (size == 1) {
            if (isNumeric(args[0])) {
                FirstTask.getHello(Float.parseFloat(args[0]));
            } else {
                SecondTask.getName(args[0]);
            }

        } else if (size >= 2) {
            List<Float> list = new ArrayList<>(size);
            for (String i : args) {
                if (isNumeric(i)) {
                    list.add((float) round(Float.parseFloat(i)));
                }
            }
            ThirdTask.getNumbers(list);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            if (str.contains(".")) {
                Float.parseFloat(str);
            } else {
                Integer.parseInt(str);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
