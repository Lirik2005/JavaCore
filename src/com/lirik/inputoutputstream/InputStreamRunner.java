package com.lirik.inputoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * FileInputStream считывает любые файлы, а не только текстовые!!! Только для текстовых файлов существует класс Reader!!!
 */

public class InputStreamRunner {

    public static void main(String[] args) throws IOException {

        /**
         * В Windows и MacOS разделитель "/" работает по разному и поэтому вот так путь к файлу записывать не стоит: "resources/test.txt"
         * Правильный синтаксис приведен в строке 15 и выглядит вот так: String.join(File.separator, "resources", "test.txt").
         * String.join() нужен для объединения строк и в нем мы указываем File.separator, где через "," перечисляем директории до нашего
         * файла!!!
         * ТАК ПИШУТ В JAVA 1.7 и РАНЕЕ!!! СЕЙЧАС ТАК НЕ ДЕЛАЮТ!!!
         */

        File oldFile = new File(String.join(File.separator, "resources", "test.txt"));

        /**
         * Начиная с JAVA 1.8 файл стоит указывать как в строке 25!!!
         */

        File file = Path.of("resources", "test.txt").toFile();

        /**
         * Это try-with-resources для автоматического закрытия потоков ввода-вывода. Потоки можно перечислять в этом блоке через ";"
         * Поток должен быть обязательно закрыт!!! Иначе это приведет к утечке памяти!!!!
         */

        try (FileInputStream inputStream = new FileInputStream(file)) {

            byte[] bytes = inputStream.readAllBytes();  // тут считываем все байты из файла и записываем в массив байтов
            String stringValue = new String(bytes); // массив байтов помещается в строку и получаем строковое представление файла!!
            System.out.println(stringValue);

            /**
             * Ниже файл считывается побайтово. Подходит для чтения больших файлов, таких как видео-файлы!!!
             */

//            byte[] byteArray = new byte[inputStream.available()];
//            int counter = 0;
//            byte currentByte;
//            while ((currentByte = (byte) inputStream.read()) != -1) {
//                byteArray[counter++] = currentByte;
//            }
//            String newStringValue = new String(byteArray);
//            System.out.println(newStringValue);
        }
    }
}
