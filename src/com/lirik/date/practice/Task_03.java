package com.lirik.date.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Дана строка вида "26-03-1968T09:24". Получить объект LocalDateTime, представляющий собой дату, полученную из этой строки.
 */

public class Task_03 {

    public static void main(String[] args) {

        String date = "26-03-1968T09:24";

        /**
         * T не является спецсимволом и поэтому берем его в одинарные кавычки
         */
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");

         LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        System.out.println("Объект LocalDateTime: " + localDateTime);

    }

}
