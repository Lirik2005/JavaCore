package com.lirik.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("123", "345", "14", "678"); // данную коллекцию можно изменять в отличие от List.of()
        Collections.sort(strings);
        System.out.println(strings);
        System.out.println();

        List<Person> personList = Arrays.asList(
                new Person(1, "ZIvan", "Ivanov"),
                new Person(29, "Petr", "Petrov"),
                new Person(3, "Sergey", "Sergeev")
        );

        /**
         * Чтобы сравнивать объекты, необходимо реализовать в классе Person интерфейс Comparable и параметризовать его классом Person.
         * Смотри реализацию в классе Person (сортировка идет только по id)
         * Реализация интерфейса Comparable позволяет сортировать только в одном единственном варианте!!!
         */

        Collections.sort(personList);
        System.out.println(personList);
        System.out.println();

        personList.sort(new FirstNameComparator());
        System.out.println(personList);
        System.out.println();

        /**
         * С JAVA 1.8 появился еще один способ сортировки не требующий действий, приведенных на строках 50 - 56 !!!!
         * Сортировать можно сколько хочешь!
         */
        personList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
        System.out.println(personList);
    }

    /**
     * Таким образом мы можем сортировать объекты по всем полям!!!
     * Начиная с JAVA 1.8 подобные манипуляции не требуются!!!
     */

    public static class FirstNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }
}
