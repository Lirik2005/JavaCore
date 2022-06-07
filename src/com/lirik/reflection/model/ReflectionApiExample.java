package com.lirik.reflection.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionApiExample {

    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        User ivan = new User(25L, "Ivan", 15);


        Class<? extends User> userClass = ivan.getClass();
        Class<User> userClass1 = User.class;
        System.out.println(userClass == userClass1);
        System.out.println();

        System.out.println("Код выше уже не актуален. Он показывает, что  ссылки равны");
        System.out.println();

        testConstructor();
        System.out.println();
        testFields(ivan);
        System.out.println();

        testMethods(ivan);
        System.out.println();


    }

    private static void testConstructor()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = User.class.getConstructor(Long.class, String.class, int.class);
        User petr = constructor.newInstance(25L, "Petr", 15);
        System.out.println(petr);
    }

    private static void testFields(User user) throws IllegalAccessException {
        Field[] declaredFields = User.class.getDeclaredFields(); // возвращает поля класса User
        Field[] fields = User.class.getSuperclass().getDeclaredFields();// возвращает поля класса Person
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);  // данная запись позволяет игнорировать модификатор private
            int modifier = declaredField.getModifiers(); // данная запись возвращает модификаторы доступа
            boolean aPrivate = Modifier.isPrivate(modifier); // класс Modifier несет много разных интересных методов
            System.out.println(aPrivate);
            Object value = declaredField.get(user);
            System.out.println(value);
        }
    }


    private static void testMethods(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getMethod = user.getClass().getDeclaredMethod("getName"); // метод getName() ничего не принимает
        System.out.println(getMethod.invoke(user)); // печатаем в консоль имя юзера
        Method setMethod = user.getClass().getDeclaredMethod("setName", String.class); // метод setName() принимает String
        setMethod.invoke(user, "Kiril");  // записываем юзеру новое имя
        System.out.println(getMethod.invoke(user)); // печатаем в консоль новое имя юзера
    }
}


