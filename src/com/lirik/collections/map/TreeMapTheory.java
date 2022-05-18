package com.lirik.collections.map;

import com.lirik.collections.Person;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap добавляет объекты в map предварительно отсортировав их по-порядку.
 * Если в качестве ключа передается не String или Integer, то этот объект должен реализовывать интерфейс Comparable ИЛИ передавать в
 * конструктор TreeMap Comparator (Map<Person, NewPerson> map = new TreeMap<>(Comparator.comparing(Person::getFirstName)) - здесь ключом
 * выступает Person, а значением NewPerson и сортировка по firstName Person'а).
 *
 * В основе TreeMap лежит красно-черное дерево: от корня идут потомки вправо, если они больше и влево, если они меньше.
 */

public class TreeMapTheory {

    public static void main(String[] args) {

        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(29, "Petr", "Petrov");
        Person sergey = new Person(3, "Sergey", "Sergeev");
        Person sveta = new Person(30, "Sveta", "Svetikova");
        Person maksim = new Person(45, "Maksim", "Maksimov");
        Person elena = new Person(10, "Elena", "Elenova");

        Map<Integer, Person> map = new TreeMap<>();

        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.putIfAbsent(sergey.getId(), sergey);
        map.putIfAbsent(sveta.getId(), sveta);
        map.putIfAbsent(maksim.getId(), maksim);
        map.putIfAbsent(elena.getId(), elena);

        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
