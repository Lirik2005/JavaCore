package com.lirik.functionalprogramming;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Если раскомментировать строку 23 в которой записано filter(student -> student.getAge() < 18), то в строке 26 ничего не напечатается в
 * консоль, так как все студенты будут отфильтрованы и дальше не пойдут.
 */

public class OptionalExample {

    public static void main(String[] args) {

        Optional<Student> maybeStudent = Stream.of(
                                                       new Student(18, "Ivan"),
                                                       new Student(23, "Petr"),
                                                       new Student(34, "Lena"),
                                                       new Student(45, "Sveta"),
                                                       new Student(20, "Mary"),
                                                       new Student(68, "Alex"),
                                                       new Student(101, "Denis")
                                               )
//                                               .filter(student -> student.getAge() < 18)
                                               .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);

        maybeStudent.ifPresent(System.out::println);

        maybeStudent
                .map(Student::getAge)           // map() преобразует наш Optional уже в другой Optional
                .filter(age -> age > 25)        // filter() отфильтрует или в данном случае проверит, соответствует или нет условие
//                .get()   // позволяет достать значение, но метод бросает исключение, если Optional == null. Нужна проверка ifPresent()
                .ifPresent(System.out::println);
    }

}
