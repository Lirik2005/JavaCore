package com.lirik.date.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Создать объект LocalDateTime, представляющий собой дату 25.06.2020 19:47. Используя этот объект, создать другой объект LocalDateTime,
 * представляющий собой дату через 3 месяца после сегодняшней.
 * Вывести на консоль содержащиеся в нем объекты LocalDate и LocalTime.
 */

public class Task_01 {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 25, 19, 47);
        System.out.println("Исходный объект localDateTime: " + localDateTime);

        LocalDateTime newLocalDateTime = LocalDateTime.from(localDateTime.plus(3L, ChronoUnit.MONTHS));
//        LocalDateTime newLocalDateTime = localDateTime.plusMonths(3L);  // запись аналогична записи из строки 21.
        System.out.println("Модифицированный объект localDateTime: " + newLocalDateTime);

        LocalDate localDate = newLocalDateTime.toLocalDate();
        LocalTime localTime = newLocalDateTime.toLocalTime();
        System.out.println("Объект LocalDate: " + localDate);
        System.out.println("Объект LocalTime: " + localTime);


    }

}
