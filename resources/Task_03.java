package com.lirik.inputoutputstream.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Задан файл с текстом (resources -> test2.txt). В каждой строке найти и вывести наибольшее число цифр, идущих подряд
 */

private class Task_03 {

    private static void main(String[] args) throws IOException {

        Path path = Path.of("resources", "test2.txt");

        Files.readAllLines(path).stream()
             .map(Task_03::getStringObjectFunction)
             .forEach(System.out::println);


    }

    private static Integer getStringObjectFunction(String lines) {
        int result = 0;
        int counter = 0;
        for (int i = 0; i < lines.length(); i++) {
            if (Character.isDigit(lines.charAt(i))) {
                counter++;
            } else {
                if (result < counter) {
                    result = counter;
                }
                counter = 0;
            }

        }
        return result;
    }


}
