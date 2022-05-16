package com.lirik.strings.string;

/**
 * Заменить все грустные смайлы в строке на веселые
 */

public class Task_01 {

    public static void main(String[] args) {

        String value = "Я глупый дурачок :( Но когда-нибудь я пойму JAVA :) Но сейчас я мало что умею и постоянно туплю :(";
        String result = replace(value);
        System.out.println(result);
        System.out.println(replace(value));  // так можно делать, если не нужна переменная для дальнейшей работы.


    }

    public static String replace(String value) {
        return value.replace(":(", ":)");
    }
}
