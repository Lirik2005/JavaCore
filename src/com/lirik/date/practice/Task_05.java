package com.lirik.date.practice;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Создать объект LocalDate, представляющий собой сегодняшнюю дату. Создать объект LocalDate, представляющий собой дату 07.07.2018.
 * Используя созданные объекты, найти количество дней между этими датами.
 */

public class Task_05 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2018, 7, 7);
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(localDate, currentDate);
        System.out.println("Количество лет между датами: " + period.getYears());
        System.out.println("Количество месяцев между датами: " + period.getMonths());
        System.out.println("Количество дней между датами: " + period.getDays());

        long days = ChronoUnit.DAYS.between(localDate, currentDate); // так мы получим абсолютно все дни в интервале между периодами
        System.out.println("Общее количество дней в периоде: " + days);

    }

}
