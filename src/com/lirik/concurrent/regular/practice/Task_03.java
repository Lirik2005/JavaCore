package com.lirik.concurrent.regular.practice;

/**
 * Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть параметры, например <p id = "p1">, и
 * замену их на простые теги абзацев <p>.
 */

public class Task_03 {

    public static void main(String[] args) {

        /**
         * Здесь знак вопроса делает наш квантификатор ленивым!!! Это необходимо чтобы строка правильно отобразилась. Если не поставить
         * вопросительный знак, то получится херня!!!
         * С помощью круглых скобок мы разбиваем наше выражение на группы
         */

        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p>hgfhfghfgh hfghfghfh </p> <b> fbgfhbfgh </b> ddfgdfgfdfgdg fbfdbb <p id = \"p1\"> kjdskldkvdklfv </p> " +
                "dfdffdghdfghg <p>  fdfgdfgdfgd";

        /**
         * В методе replaceAll() первым параметром мы указываем наше регулярное выражение, а вторым параметром на что его заменяем. Здесь
         * "<p>$2" мы указываем, что мы вставляем <p> вместо <p id = "p1"> и после этого у нас идет $2 т.е. группа закрывающего тега!!!
         */

        System.out.println(input.replaceAll(regex, "<p>$2"));
        System.out.println();
    }
}
