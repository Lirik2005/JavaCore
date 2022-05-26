package com.lirik.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeExample {

    public static void main(String[] args) {

        /**
         * Класс ZonedDateTime самый мощный инструмент. Он показывает точную текущую дату (2022-05-25), через символ Т мы видим точное
         * текущее время (10:36:40.733995), смещение относительно UTC (+03:00) и название нашей тайм-зоны ([Europe/Minsk]).
         * UTC - Всемирное Координированное Время.
         * Unix-время - это количество секунд с 01 января 1970 года 00:00:00 UTC. Время Unix никогда не двигается назад.
         */

        ZonedDateTime now = ZonedDateTime.now();  // этот метод просто возвращает информацию о текущем времени
        System.out.println("Текущие полные дата и время: " + now);

        Instant instant = now.toInstant(); // этот метод показывает время по UTC, то есть без смещения и тайм-зоны
        System.out.println("Текущие полные дата и время без смещения: " + instant);

        long epochMilli = now.toInstant().toEpochMilli(); // так получаем количество миллисекунд от момента создания Unix-времени
        System.out.println("С 01 января 1970 года прошло " + epochMilli + " миллисекунд");

        /**
         * В ChronoUnit через точку можно указывать разные параметры: дни, часы минуты, секунды и т.д.
         */

        ZonedDateTime plusDay = now.plus(1L, ChronoUnit.DAYS);  // изменяет текущую дату прибавив к ней 1 день
        System.out.println("Текущая дата плюс 1 день: " + plusDay);

        ZonedDateTime minusDay = now.minus(1L, ChronoUnit.DAYS);  // изменяет текущую дату отняв у нее 1 день
        System.out.println("Текущая дата минус 1 день: " + minusDay);

        ZonedDateTime zonedDateTime = now.truncatedTo(ChronoUnit.SECONDS); // позволяет обнулить дату и время до указанного параметра
        System.out.println("Текущая дата обнуленная до секунд: " + zonedDateTime); // убрали миллисекунды из вывода даты

        /**
         * Имеется огромное количество геттеров
         */

        int year = now.getYear();
        Month month = now.getMonth();
        int monthValue = now.getMonthValue();
        int dayOfYear = now.getDayOfYear();
        int dayOfMonth = now.getDayOfMonth();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int nano = now.getNano();
        ZoneOffset offset = now.getOffset();
        ZoneId zone = now.getZone();
        System.out.printf("Год: %d, месяц: %s, порядковый месяца: %d, день года: %d,  день месяца: %d, день недели: %s, часы: %d, минуты:" +
                                  " %d, секунды: %d, миллисекунды: %d, часовое смещение: %s, часовая зона: %s", year, month, monthValue,
                          dayOfYear, dayOfMonth, dayOfWeek, hour, minute, second, nano, offset, zone);

        /**
         * Работа с LocalDateTime LocalDate и LocalTime аналогична работе с ZonedDateTime
         */

        LocalDateTime dateTime = LocalDateTime.of(2022, 5, 17, 22, 12); // конструктор перегружен

        LocalDate localDate = LocalDate.now();

        LocalTime localTime = LocalTime.now();


    }
}
