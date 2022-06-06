package com.lirik.concurrent.regular.practice;

import java.util.regex.Pattern;

/**
 * Написать программу, проверяющую, является ли введённая строка адресом почтового ящика. В названии почтового ящика разрешить
 * использование только букв, цифр и нижних подчёркиваний, при этом оно должно начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com
 */

public class Task_01 {

    public static void main(String[] args) {

        /**
         * тЧо записано в переменную regex:
         * [a-zA-Z] - означает, что в начале будет только 1 символ (буквенный) в диапазоне от a до z или от A до Z;
         * \\w+ - означает, что мы ждем буквы, цифры и подчеркивания от одного символа до бесконечности;
         * @ - означает саму себя (тут никаких скрытых вещей нет);
         * \\w{3,} - означает, что мы ждем буквы, цифры и подчеркивания от трех символов до бесконечности;
         * \\. - означает точку. Если не поставить слэши, то точка будет воспринята как любой символ;
         * (org|com) - означает, что в конце должно быть org либо com;
         */

        String regex = "[a-zA-Z]\\w+@\\w{3,}\\.(org|com)";
        String input = "myEmail123@gmail.com";
        System.out.println(Pattern.matches(regex, input));

        /**
         * Второй вариант вывода
         */

        boolean matches = input.matches(regex);
        System.out.println(matches);
    }
}