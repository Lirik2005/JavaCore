package com.lirik.functionalprogramming.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Дан класс Person с полями firstName, lastName, age. Вывести полное имя самого старшего человека у которого длина этого имени не
 * превышает 15 символов.
 */

public class Task_05 {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Ivan", "Ivanov", 20),
                new Person("Petr", "Petrov", 25),
                new Person("Sveta", "Svetikova", 33),
                new Person("Kate", "Ivanova", 25),
                new Person("Slava", "Slavikov", 18),
                new Person("Arni", "Kutuzov", 56)
        );

        persons.stream()
               .filter(person -> person.getFullName().length() < 15)
               .max(Comparator.comparing(Person::getAge))
               .map(person -> person.getFullName())
               .ifPresent(System.out::println);


        Map<Integer, List<Person>> collect = persons.
                stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(collect);


        Map<Integer, List<String>> map = persons
                .stream()
                .collect(Collectors
                                 .groupingBy(Person::getAge, Collectors.mapping(Person::getFullName, Collectors.toList())));
        System.out.println(map);

        Map<Integer, Person> uniqueMap = persons.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));
        /**
         * Function.identity() аналогично записи person -> person и означает, что по ключу age, положи значение person, но сейчас не
         * сработает, так как ключи не уникальны (2 раза встречается ключ 25).
         */
        System.out.println(uniqueMap);
    }
}
