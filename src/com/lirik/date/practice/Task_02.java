package com.lirik.date.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Создать объект LocalDate, представляющий собой сегодняшнюю дату. Преобразовать дату в строку вида "05.05.2017".  Вывести эту строку в
 * консоль.
 */

public class Task_02 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalDate newLocalDate = localDate.minusYears(5L).minusDays(20L);
        System.out.println("Неформатированная дата: " + newLocalDate);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"); // пример формата для даты и времени

        String formatNewLocalDate = newLocalDate.format(dateFormatter);

        System.out.println("Форматированная дата: " + formatNewLocalDate);

    }

}
