package com.lirik.inputoutputstream;

import java.io.File;
import java.io.IOException;

/**
 * application ---------> file (запись из приложения в файл это output stream)
 * <p>
 * application <--------- file (запись из файла в приложение это input stream)
 */

public class FileRunner {

    public static void main(String[] args) {

        File file = new File("resources/test.txt");

        /**
         * метод createNewFile() возвращает true или false, т. е. создан файл или нет. Если такой файл существует, то он не создается
         * заново и возвращается false!!!
         */

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(file.exists());    // file.exists() показывает, существует файл по указанному в конструкторе пути или нет
        System.out.println(file.isFile());    // file.isFile() показывает, файл или нет по указанному в конструкторе пути
        System.out.println(file.isDirectory());   // file.isDirectory() показывает, директория или по указанному в конструкторе пути
        System.out.println(file.getName());   // file.getName() возвращает название файла
        System.out.println(file.getParent());  // file.getParent() возвращает родительскую директорию
        System.out.println(file.length());  // file.length() возвращает размер файла, т. е. сколько в него записано

    }
}
