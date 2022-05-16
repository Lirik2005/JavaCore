package com.lirik.generic;

public class ListRunner {

    public static void main(String[] args) {

        List<String> list = new List<>(10);
        list.add("String_1");
        list.add("String_2");
        // list.add(25);

        Object element1 = list.get(0);  // метод get() возвращает уже Object, а не String, который мы добавляли в строках 8-10!!!
        System.out.println(element1);

        String element2 = (String) list.get(1);  // можно использовать приведение типов, чтобы получить доступ к методам класса String.
        System.out.println(element2);

        String element3 = (String) list.get(2);  // тут будет ошибка, т. к. мы пытаемся привести int к String
        System.out.println(element3);
    }

}
