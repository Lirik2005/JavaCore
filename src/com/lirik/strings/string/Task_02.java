package com.lirik.strings.string;

/**
 * Написать функцию, принимающую 2 параметра: строку и слово - и возвращающую true, если строка начинается и заканчивается этим словом
 */

public class Task_02 {

    public static void main(String[] args) {
        String value = "Java - лучший язык. Да здравствует Java";
        String word = "Java";
        System.out.println(isStartAndEnd(value, word));
    }

    /**
     * Названия методов, возвращающих boolean, должны начинаться словом is.
     */
    public static boolean isStartAndEnd(String value, String word) {
        if (value.startsWith(word) && value.endsWith(word)) {
            return true;
        }
        return false;

//      return value.startsWith(word) && value.endsWith(word);  // так тоже можно сделать записать
    }
}
