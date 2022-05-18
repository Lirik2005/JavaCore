package com.lirik.collections.map;

import com.lirik.collections.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * Map - это ассоциативный массив с двумя Generic-типами: ключ (уникальное значение) и значение. Одинаковые ключи перетирают друг друга!!!
 */

public class HashMapTheory {

    public static void main(String[] args) {

        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(2, "Petr", "Petrov");
        Person sergey = new Person(3, "Sergey", "Sergeev");

        /**
         * В конструкторе можно указать начальный размер map и %-заполнения при котором она увеличится в размере
         */

        Map<Integer, Person> map = new HashMap<>();

        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sergey.getId(), sergey);

        System.out.println(map.get(1));  // возвращает объект по ключу
        System.out.println(map.getOrDefault(4, ivan));  // возвращает объект по ключу и если по ключу объекта нет, то вернется ivan
        System.out.println();

        System.out.println(map.keySet());  // возвращает все ключи без объектов
        System.out.println(map.values());  // возвращает все объекты без ключей
        System.out.println(map.entrySet());  // возвращает все объекты с ключами
        System.out.println();

        /**
         * По map можно итерироваться
         */

        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println();

        for (Person person : map.values()) {
            System.out.println(person.getFirstName());
        }
        System.out.println();

        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }
}
