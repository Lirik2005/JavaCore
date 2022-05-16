package com.lirik.generic;

/**
 * Сначала был List без парамера и мы работали с массивом object'ов (private Object [] objects), что вело к проблемам указанным в
 * комментариях в классе ListRunner. Добавив параметризацию <T> классу List и его методам мы избавились от проблем с которыми
 * сталкивались ранее (а именно необходимостью приведения типов и ошибок, связанных с приведением типов)
 */

public class List<T> {

    private T[] objects;
    private int size;

    public List(int initialSize) {
        this.objects = (T[]) new Object[initialSize];
    }

    public void add(T element) {
        objects[size++] = element;
    }

    public T get(int index) {
        return objects[index];
    }

    public int getSize() {
        return size;
    }
}
