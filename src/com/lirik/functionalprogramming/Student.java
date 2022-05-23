package com.lirik.functionalprogramming;

public class Student {

    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Студента зовут %s и его возраст %d", name, age);
    }
}
