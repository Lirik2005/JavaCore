package com.lirik.functionalprogramming;

import java.util.stream.Stream;

/**
 * Тут надо найти максимальный возраст.
 * Вызов map() аналогичен записи map(student -> student.getAge()). Отдает нам возраст студентов.
 * Вызов reduce() аналогичен записи reduce((age1, age2) -> Math.max(age1, age2)). Отдает нам максимальный возраст студента, обернутый в
 * Optional.
 */

public class MapReduceExample {

    public static void main(String[] args) {

        Stream.of(
                      new Student(18, "Ivan"),
                      new Student(23, "Petr"),
                      new Student(34, "Lena"),
                      new Student(45, "Sveta"),
                      new Student(20, "Mary"),
                      new Student(68, "Alex"),
                      new Student(101, "Denis")
              )
              .map(Student::getAge)
              .reduce(Math::max)
              .ifPresent(System.out::println);
    }

}

