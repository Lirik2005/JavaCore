package com.lirik.exceptions.practice;

/**
 * Бросить одно из существующих JDK исключений, отловить его и выбросить свое собственное, указав в качестве причины отловленное исключение.
 */

public class Task_05 {

    public static void main(String[] args) {

        try {
            catchCustomException();
        } catch (MyOwnRunTimeException exception) {
            System.out.println("Отловили MyOwnRunTimeException в методе main");
        }
    }

    public static void catchCustomException() {
        try {
            unsafe();
        } catch (RuntimeException exception) {
            System.out.println("Отловили RunTimeException в методе catchCustomException");
            throw new MyOwnRunTimeException(exception);
        }
    }

    public static void unsafe() {
        throw new RuntimeException("We've got a problem!!!");
    }
}
