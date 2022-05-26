package com.lirik.date.practice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Написать свою реализацию интерфейса temporalAdjuster, которая бы прибавляла к дате 42 дня.
 */

public class Task_08 {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println("Текущая дата плюс 42 дня: " + localDateTime);
    }

}
