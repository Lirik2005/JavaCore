package com.lirik.exceptions.practice;

/**
 * Создать собственный класс-исключение - наследник класса Exception. Создать метод, который будет выбрасывать это исключение. Вызвать
 * метод и отловить это исключение с выводом его в консоль.
 */

public class Task_03 {

    public static void main(String[] args) {

        try {
            throwException();
        } catch (MyOwnException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static void throwException() throws MyOwnException {
        throw new MyOwnException("Это мое собственное исключение!!!");
    }
}
