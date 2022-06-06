package com.lirik.concurrent.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchesExample {

        /**
         * регулярное выражение можно записать в переменную String!!!
         */

    public static void main(String[] args) {

        /**
         * Для регулярных выражений используется 2 основных класса. Первый из них это класс Pattern
         */

        Pattern pattern = Pattern.compile("\\d{3}"); // тут указано регулярное выражение для поиска трех любых цифр!!!

        Matcher matcher = pattern.matcher("123"); // тут показываем какая пришла строка!!!

            /**
             * Метод matches() используется для проверки полного соответствия нашей строки регулярному выражению.
             */

            System.out.println(matcher.matches()); // таким образом проверяем соответствует ли matcher нашему регулярному выражению

        String phoneNumber = "+375 (29) 777-66-55";
        Pattern phoneRegex = Pattern.compile("\\+\\d{3}\\s\\(\\d{2}\\)\\s\\d{3}-\\d{2}-\\d{2}");
        Matcher phoneMatcher = phoneRegex.matcher(phoneNumber);
        System.out.println(phoneMatcher.matches());

        /**
         * Также можно использовать метод matches() у класса Pattern, передав ему регулярное выражение и какую-то строку для сравнения.
         * Пробелы можно прописывать как в примере ниже, а можно с помощью выражения \\s!!!
         */

        System.out.println(Pattern.matches("\\+375 \\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2}", phoneNumber));

        /**
         * Метод matches() можно вызвать прямо у своей String и передать туда регулярное выражение.
         */

        System.out.println(phoneNumber.matches("\\+375 \\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2}"));

    }

}
