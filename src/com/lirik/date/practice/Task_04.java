package com.lirik.date.practice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Использовать LocalDateTime из задания Task_03, преобразовать его в объект типа Instant, указав тайм-зону "America/Chicago". Вывести
 * количество прошедших миллисекунд.
 */

public class Task_04 {

    public static void main(String[] args) {
        String date = "26-03-1968T09:24";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);

        Instant instant = localDateTime.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(localDateTime));
        System.out.println("Объект localDateTime с айм-зоной \"America/Chicago: м" + instant);
        System.out.println("Количество прошедших миллисекунд с начала отсчета Unix-времени: " + instant.toEpochMilli());
    }
}
