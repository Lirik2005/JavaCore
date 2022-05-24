package com.lirik.inputoutputstream.practice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Задан файл с текстом (resources -> test.txt), найти и вывести в консоль все слова, для которых последняя буква одного слова совпадает
 * с первой буквой
 * следующего слова.
 */

public class Task_02 {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("resources", "test.txt");

        try (Scanner scanner = new Scanner(path)) {
            String previousWord = null;
            if (scanner.hasNext()) {
                previousWord = scanner.next();
            }
            while (scanner.hasNext()) {
                String currentWord = scanner.next();
                if (isEqualLastSymbolAndFirstSymbol(previousWord, currentWord)) {
                    System.out.println(previousWord + " " + currentWord);
                }
                previousWord = currentWord;
            }
        }
    }

    private static boolean isEqualLastSymbolAndFirstSymbol(String previousWord, String currentWord) {
        return previousWord.charAt(previousWord.length() - 1) == currentWord.charAt(0);
    }
}


