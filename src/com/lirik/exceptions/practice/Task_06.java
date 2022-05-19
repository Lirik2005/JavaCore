package com.lirik.exceptions.practice;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Random;

/**
 * Создать метод случайным образом выбрасывающий одно из 3-х видов исключений. Вызвать этот метод в блоке try - catch, отлавливающее
 * любое из 3-х.
 */

public class Task_06 {

    public static final Map<Integer, Throwable> EXCEPTIONS = Map.of(
            0, new RuntimeException("runtime"),
            1, new FileNotFoundException("file not found"),
            2, new IndexOutOfBoundsException("index exception")
    );

    public static void main(String[] args) {

        Random random = new Random();

        /**
         * Блоки catch выстраиваются по иерархии снизу вверх, т. е. от потомков к родителям!!!
         */

        try {
            unsafe(random.nextInt(4));  // Число 4 не входит в диапазон. Объект random может быть равен 0, 1, 2, 3
        } catch (IndexOutOfBoundsException exception) {
            System.err.println("Отработал первый catch");
            exception.printStackTrace();
        } catch (RuntimeException exception) {
            System.err.println("Отработал второй catch");
            exception.printStackTrace();
        } catch (FileNotFoundException exception) {
            System.err.println("Отработал третий catch");
            exception.printStackTrace();
        } catch (Throwable exception) {
            System.err.println("Отработал четвертый catch");
            exception.printStackTrace();
        }
    }

    public static void unsafe(int randomValue) throws Throwable {
        Throwable exception;
        exception = EXCEPTIONS.getOrDefault(randomValue, new MyOwnException("exception not found"));
        throw exception;
    }
}
