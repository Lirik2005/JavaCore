package com.lirik.exceptions.practice;

/**
 * Создать собственный класс-исключение - наследник класса RunTimeException. Создать метод, который будет выбрасывать это исключение.
 * Вызвать метод и отловить это исключение с выводом его в консоль.
 * Добавить в конструктор своего класса возможность указания сообщения.
 */

public class Task_04 {

    public static void main(String[] args) {

        throwException();
    }

    /**
     * Так как MyOwnRunTimeException унаследован от RunTimeException его не надо пробрасывать и обрабатывать блоком try - catch (это
     * непроверяемое исключение и находится на совести разработчика). Пробрасываем только проверяемые исключения (т. е. наследников
     * класса Exception).
     */
    public static void throwException() {
        throw new MyOwnRunTimeException("Это мой RunTimeException");
    }
}
