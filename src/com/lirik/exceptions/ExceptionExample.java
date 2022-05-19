package com.lirik.exceptions;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

public class ExceptionExample {

    public static void main(String[] args) {

        /**
         * Обрабатывать в блоке try-catch необходимо каждое проброшенное исключение. Главное правило - это обрабатывать от самого узкого
         * исключения и вверх по иерархии т.е. от ПОТОМКА и до САМОГО СТАРШЕГО РОДИТЕЛЯ!!!
         * Блок finally отработает всегда, даже если будет исключение!!!
         * !!!ВАЖНО!!! Если в блоке try упадет JVM, то блоки catch и finally уже не выполнятся (это теоретический вопрос и на практике
         * бывает редко).
         * Возможные варианты:
         * 1) try - catch - finally
         * 2) try - catch
         * 3) try - finally (необходимо с помощью throws пробросить исключение дальше. Используется, чтобы выполнить код из finally)
         * 4) try
         */

        System.out.println("main start");

        System.out.println(finallyTest());

        try {
            unsafe(-10);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (TimeoutException exception) {
            System.err.println(exception);
        } finally {
            System.out.println("finally");
        }
        System.out.println("main end");
    }

    /**
     * Ключевое слово throw позволяет нам вызвать (создать) исключение.
     * Ключевое слово throws позволяет нам лишь пробросить исключение выше, чтобы не обрабатывать его в этом методе.
     * Пробрасывать можно несколько исключений с помощью слова throws
     */

    public static void unsafe(int value) throws FileNotFoundException, TimeoutException {
        System.out.println("unsafe start");
        if (value > 0) {
            throw new FileNotFoundException();
        }
        System.out.println("unsafe end"); //  т.к. exception не обработан, то в случае его появления код после строки 26 не выполнится!!!
    }

    /**
     * Из блока finally не стоит ничего возвращать потому что в любом случае мы получим только результат из этого блока!!!
     * Таких конструкций лучше избегать!!!
     */
    public static int finallyTest() {
        try {
            return 2;
        } catch (Exception exception) {
            return 3;
        } finally {
            return 4;
        }
    }
}
