package com.lirik.collections.set;

/**
 * Структура данных HashSet НЕ ДАЕТ возможности записывать в коллекцию дубликаты, а также не сохраняет порядок добавления.
 * Структура данных LinkedHashSet НЕ ДАЕТ возможности записывать в коллекцию дубликаты, но сохраняет порядок добавления.
 * Структура данных TreeSet НЕ ДАЕТ возможности записывать в коллекцию дубликаты, но сортирует добавленные объекты. В конструктор TreeSet
 * можно передавать Comparator (Set<Person> treeSet = new TreeSet<>(Comparator.comparing(Person::getFirstName)) - здесь сортировка по
 * firstName Person'а). Если Comparator'а не будет, то сортировка будет по id.
 * SET ЭТО УСЕЧЕННАЯ MAP, которая принимает только ключ!!!
 */

import com.lirik.collections.Person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTheory {

    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>();

        hashSet.add("aaa");
        hashSet.add("bbb");
        hashSet.add("ccc");
        hashSet.add("ddd");
        hashSet.add("bbb");

        System.out.println(hashSet);
        System.out.println();

        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("aaa");
        linkedHashSet.add("bbb");
        linkedHashSet.add("ccc");
        linkedHashSet.add("ddd");
        linkedHashSet.add("bbb");

        System.out.println(linkedHashSet);
        System.out.println();

        Set<String> treeSet = new TreeSet<>();

        treeSet.add("bbb");
        treeSet.add("ddd");
        treeSet.add("ccc");
        treeSet.add("aaa");
        treeSet.add("bbb");

        System.out.println(treeSet);
        System.out.println();

        Set<Person> personSet = new TreeSet<>(Comparator.comparing(Person::getFirstName));

        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person petr = new Person(29, "Petr", "Petrov");
        Person sergey = new Person(3, "Sergey", "Sergeev");
        Person sveta = new Person(30, "Sveta", "Svetikova");
        Person maksim = new Person(45, "Maksim", "Maksimov");
        Person elena = new Person(10, "Elena", "Elenova");

        personSet.add(ivan);
        personSet.add(petr);
        personSet.add(sergey);
        personSet.add(sveta);
        personSet.add(maksim);
        personSet.add(elena);
        personSet.add(ivan);

        System.out.println(personSet);
        System.out.println();

    }
}
