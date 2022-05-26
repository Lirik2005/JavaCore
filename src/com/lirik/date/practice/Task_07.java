package com.lirik.date.practice;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Создать объект Instant. Вывести его на консоль. Затем создать объект ZoneDateTime на основании предыдущего объекта с тайм-зоной
 * "Africa/Cairo".
 */

public class Task_07 {

    public static void main(String[] args) {

        Instant now = Instant.now();
        System.out.println("Объект Instant: " + now);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of("Africa/Cairo"));
        ZonedDateTime anotherZonedDateTime = now.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println("Объект ZonedDateTime: " + zonedDateTime);
        System.out.println("Объект ZonedDateTime, полученный вторым способом: " + anotherZonedDateTime);

    }

}
