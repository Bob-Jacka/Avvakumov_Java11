package org.example.tasks;

abstract class SecondTask {

    static void getName(final String name) {
        if (name.equalsIgnoreCase("Вячеслав")) {
            System.out.println("Привет, Вячеслав");
        } else {
            if (!name.contains(",")) {
                System.out.println("Нет такого имени");
            }
        }
    }
}
