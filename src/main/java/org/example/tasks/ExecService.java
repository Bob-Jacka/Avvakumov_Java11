package org.example.tasks;

import java.util.ArrayList;
import java.util.List;

public abstract class ExecService {

    public static void execTasks(final String[] args) {
        int size = args.length;

        if (size == 0) {
            System.out.println("Введите значение");

        } else if (size == 1) {
            if (isNumeric(args[0])) {
                FirstTask.getHello(Double.parseDouble(args[0]));
            } else {
                SecondTask.getName(args[0]);
            }

        } else if (size >= 2) {
            List<Double> list = new ArrayList<>(size);
            for (String i : args) {
                if (isNumeric(i)) {
                    list.add(Double.parseDouble(i));
                }
            }
            ThirdTask.getNumbers(list);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            if (str.contains(".")) {
                Double.parseDouble(str);
            } else {
                Integer.parseInt(str);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
