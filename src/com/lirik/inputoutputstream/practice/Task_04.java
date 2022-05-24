package com.lirik.inputoutputstream.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Задан файл с JAVA-кодом. Прочитать текст программы из файла и все слова public в объявлении атрибутов и методов класса заменить на
 * слово private. Результат сохранить в другой заранее созданный файл.
 */

public class Task_04 {

    public static void main(String[] args) throws IOException {

        Path sourcePath = Path.of("src", "com", "lirik", "inputoutputstream", "practice", "Task_03.java");

        String stringValue = Files.readString(sourcePath);
        String result = stringValue.replace("public", "private");
        Path resultPath = Path.of("resources", "Task_03.java");
        Files.writeString(resultPath, result);
    }
}
