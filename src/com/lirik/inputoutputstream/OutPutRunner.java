package com.lirik.inputoutputstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class OutPutRunner {

    public static void main(String[] args) throws IOException {

        File file = Path.of("resources", "output.txt").toFile();

        /**
         * Если в конструкторе стоит флаг true (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file,
         * true))),то текст внутри файла будет дополняться, а не перезаписываться, Если этого флага не будет, то из файла при каждом запуске
         * будет удаляться весь текст и записываться заново!!!
         */

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            String value = "Hello world!";
            outputStream.write(value.getBytes());
            outputStream.write(System.lineSeparator().getBytes()); // с помощью этой команды мы можем записывать наш текст с новой строки


        }
    }

}
