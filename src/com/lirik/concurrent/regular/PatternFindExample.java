package com.lirik.concurrent.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {

    public static void main(String[] args) {

        /**
         * Метод find() позволяет извлечь из строки подстроку, которая соответствует регулярному выражению
         */

        String phoneNumber = "dfgdgfdh +375 (33) 777-66-55 bfbffdbdbdbdbdgbbgfg +375 (29) 111-66-55 vbfdgfdbg +375 (44) 222-66-55 " +
                "bfgbnfghfgghfgh +375 (25) 333-66-55 fghfghfghfghf";
        String regex = "\\+\\d{3}\\s\\(\\d{2}\\)\\s\\d{3}-\\d{2}-\\d{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }

        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "XXX");
        }
        System.out.println(stringBuilder);


    }
}
