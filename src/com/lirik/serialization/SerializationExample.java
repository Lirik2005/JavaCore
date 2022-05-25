package com.lirik.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path path = Path.of("resources", "person.out");

        writeObject(path);

        readObject(path);
    }

    /**
     * Этот метод позволяет записать или сериализовать объект в файл созданный объект!!!
     */
    private static void writeObject(Path path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            Person ivan = new Person(20, "Ivan"); //создали объект
            Person sergey = new Person(22, "sergey"); //создали объект
            objectOutputStream.writeObject(ivan); // записали объект в файл
            objectOutputStream.writeObject(sergey); // записали объект в файл
        }
    }

    /**
     * Этот метод позволяет прочитать или десериализовать (извлечь) объект из файла!!!
     * objectInputStream.readObject() возвращает нам объект класса Object. Если мы на 100% уверены, что метод вернет нам конкретный
     * класс, то можно выполнить приведение типов!
     * Метод objectInputStream.readObject() последовательно считывает объекты из файла. Если в файле 2 объекта, то этот метод надо
     * вызвать 2 раза и так далее!
     */
    private static void readObject(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Object object = objectInputStream.readObject();
            Object object1 = objectInputStream.readObject();
//            Person object = (Person) objectInputStream.readObject();  // выполнено приведение типов!!!
            System.out.println(object);
            System.out.println(object1);
        }
    }

}
