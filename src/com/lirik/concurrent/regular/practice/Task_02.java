package com.lirik.concurrent.regular.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записанных по правилам Java, с помощью регулярных выражений и
 * выводящую их на страницу.
 */

public class Task_02 {

    public static void main(String[] args) {

        String regex = "0[Xx][0 -9a-fA-F]+";
        String input = "grgrg 0Xff dsfkdgk 0x12 dfksdnfjksslkflsf 0Xad";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}