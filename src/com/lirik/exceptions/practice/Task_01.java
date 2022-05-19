package com.lirik.exceptions.practice;

/**
 * Объявите переменную со значением null. Вызовите метод у этой переменной. Отловите возникшее исключение.
 */

public class Task_01 {

    public static void main(String[] args) {

        String name = null;

        try{
            name.length();
        } catch (NullPointerException exception) {
            System.err.println(exception);
        }

    }

}
