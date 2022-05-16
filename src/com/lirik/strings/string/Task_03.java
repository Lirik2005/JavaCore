package com.lirik.strings.string;

/**
 * Написать функцию, принимающую в качестве параметров имя, фамилию и отчество и возвращающую инициалы.
 * В формате "Ф. И. О." необходимо учесть, что входные параметры могут быть в любом регистре, а результирующая срока должна быть в верхнем.
 */

public class Task_03 {

    public static void main(String[] args) {

        String name = "кирилл";
        String secondName = "Владимирович";
        String surName = "гусаков";

        System.out.println(initials(surName, name, secondName));
    }

    public static String initials(String surName, String name, String secondName) {
        return String.format("%s. %s. %s.", surName.toUpperCase().charAt(0), name.toUpperCase().charAt(0),
                             secondName.toUpperCase().charAt(0));
    }
}
