package com.lirik.functionalprogramming;

import java.util.List;

public class StreamExample {

    public static void main(String[] args) {

        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");

        /**
         * Так было до появления JAVA 1.8 и Stream API в ней.
         */

        for (String string : strings) {
            String value = string + string;
            Integer intValue = Integer.valueOf(value);
            if (intValue % 2 == 0) {
                System.out.println(intValue);
            }
        }
        System.out.println();
        System.out.println("То же самое, но с помощью Stream API:");

        /**
         * Теперь тот же самый код, но только используя JAVA 1.8 и Stream API.
         * Первый вызов map() аналогичен записи map((String value) -> value+value). Тут складываем 2 String и возвращаем новый String.
         * Второй вызов map() аналогичен записи map(value -> Integer.valueOf(value)). Тут отдаем полученный ранее String и получаем Integer.
         * Вызов filter() аналогичен записи filter((Integer intValue) -> intValue % 2 == 0). тут фильтруем intValue и то, что делится на 2
         * без остатка (т. е. четные числа) идет дальше в следующий метод.
         * Вызов терминальной операции forEach() аналогичен записи forEach(intValue -> System.out.println(intValue)). После терминальной
         * операции ничего больше вызвать нельзя, т. к. она void!!!
         * Вызов sorted() сортирует наши Integer. Если у объекта нге реализован интерфейс Comparable, то в методе нужно вызвать Comparator.
         * Вызов skip() позволяет нам пропустить указанное количество элементов и не выводить их. В данном случае метод пропустит 1 элемент.
         * Вызов limit() позволяет ограничить количество выводимых значений. В данном случае в консоль будет выведено только 2 элемента,
         * которые удовлетворяют требованиям.
         */

        strings.stream()
               .map(value -> value + value)
               .map(Integer::valueOf)
               .filter(intValue -> intValue % 2 == 0)
               .sorted()
               .skip(1)
               .limit(2)
               .forEach(System.out::println);
    }
}
