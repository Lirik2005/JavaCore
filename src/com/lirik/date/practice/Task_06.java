package com.lirik.date.practice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Даны два объекта LocalDate из Task_05. Подсчитать количество секунд между полуночью первой даты и полуночью второй даты.
 */

public class Task_06 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2018, 7, 7);
        LocalDate currentDate = LocalDate.now();

        /**
         * Строки 22-23 аналогичны строкам 25-26. Строки 25-26 более предпочтительны!!!!
         */

        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MIDNIGHT);
        LocalDateTime currentLocalDateTime = LocalDateTime.of(currentDate, LocalTime.MIDNIGHT);

        LocalDateTime atStartOfDay = localDate.atStartOfDay();
        LocalDateTime currentAtStartOfDay = currentDate.atStartOfDay();

        Duration between = Duration.between(atStartOfDay, currentAtStartOfDay);

        System.out.println(between.getSeconds());
    }

}
