package com.lirik.inputoutputstream.practice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Задан файл (resources -> test.txt) с текстом, найти и вывести в консоль слова, начинающиеся с гласной буквы.
 */

public class Task_01 {

    private static final String VOWELS = "уеыаоэёяию";

    public static void main(String[] args) throws IOException {

        Path path = Path.of("resources", "test.txt");

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                String firstSymbol = String.valueOf(word.charAt(0)); //метод charAt() возвращает char, метод valueOf делает из него String
                if (VOWELS.contains(firstSymbol)) { //методу contains() нужно передавать String, поэтому приводим firstSymbol к String
                    System.out.println(word);
                }
                /**
                 * Еще один способ записать цикл if (z не очень понимаю поэтому остается для примера в задокументированном виде
                 */

//                char charFirstSymbol = word.charAt(0);
//                if (VOWELS.indexOf(charFirstSymbol) != -1) {
//                    System.out.println(word);
//                }
            }
        }
    }
}
