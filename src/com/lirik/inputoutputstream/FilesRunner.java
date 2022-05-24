package com.lirik.inputoutputstream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FilesRunner {

    public static void main(String[] args) throws IOException {

        /**
         *  Более краткая запись кода из строк 25-29. Используется, когда нужно записать в файл небольшое количество информации.
         */

        Path path = Path.of("resources", "fileWriter.txt");
        Files.write(path, List.of("New way to write file", "Java"));

        /**
         * Эта запись считывает наш файл, но поток должен закрываться и поэтому используем try-with-resources
         */

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }

        /**
         * Ниже приведен более современный аналог FileWriter'а
         */

        Path file = Path.of("resources", "writerFile.txt");
        try (BufferedWriter fileWriter = Files.newBufferedWriter(file)) {
            fileWriter.append("Hello world");
            fileWriter.newLine();
            fileWriter.append("Java");
        }
    }

}
