package com.lirik.inputoutputstream.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

/**
 * Задан файл с JAVA-кодом. Прочитать текст программы итз файла и записать в другой файл в обратном порядке символы каждой строки
 */

public class Task_05 {

    public static void main(String[] args) throws IOException {

        Path sourcePath = Path.of("src", "com", "lirik", "inputoutputstream", "practice", "Task_04.java");
        Path resultPath = Path.of("resources", "Task_04.java");

        /**
         * BufferedWriter использован лишь для примера!!! В идеале эту задачу можно решить с помощью Files
         */

        try (Stream<String> lines = Files.lines(sourcePath);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(resultPath, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            lines.map(line -> new StringBuilder(line))
                 .map(line -> line.reverse()).forEach(line -> {
                     try {
                         bufferedWriter.write(line.toString());
                         bufferedWriter.newLine();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 });
        }

    }
}
