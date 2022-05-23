package com.lirik.functionalprogramming;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamForPrimitives {

    public static void main(String[] args) {

        /**
         * Вызов mapToInt() аналогичен записи mapToInt(integerValue -> integerValue.intValue()). Здесь мы преобразуем Integer в int,
         * чтобы получить доступ к методам примитивных типов (max(), min(), average(), sum(), summaryStatistics() и т. д.).
         * Метод summaryStatistics() вернет всю статистику.
         */

        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");

        IntSummaryStatistics statistics = strings.stream()
                                                 .map(value -> value + value)
                                                 .map(Integer::valueOf)
                                                 .filter(integerValue -> integerValue % 2 == 0)
                                                 .mapToInt(Integer::intValue)
                                                 .summaryStatistics();
        System.out.println(statistics);
        System.out.println();

        /**
         * Вызов mapToObj() аналогичен mapToObj(intValue -> Integer.valueOf(intValue)) и преобразует наши примитивные int обратно в Integer.
         */

        strings.stream()
               .map(value -> value + value)
               .map(Integer::valueOf)
               .filter(integerValue -> integerValue % 2 == 0)
               .mapToInt(Integer::intValue)
               .mapToObj(Integer::valueOf)
               .forEach(System.out::println);

        System.out.println();

        /**
         *  Stream.of("88", "11", "22", "33", "44", "55", "66") позволяет не создавая коллекции запустить стрим из объектов.
         *  Создание стрима из примитивных типов данных (int, long, double):
         *  IntStream.of()
         *  DoubleStream.of()
         *  LongStream.of()
         */

    }
}
