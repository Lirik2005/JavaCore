package com.lirik.collections.map;

import com.lirik.collections.Person;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap добавляет объекты в map ровно в той последовательности в которой указано в программе. Т. е. сохраняется
 * последовательность добавления объектов
 */

public class LinkedHashMapTheory {

    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(29, "Petr", "Petrov");
        Person sergey = new Person(3, "Sergey", "Sergeev");

        Map<Integer, Person> map = new LinkedHashMap<>();

        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sergey.getId(), sergey);

        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
