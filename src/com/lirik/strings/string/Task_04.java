package com.lirik.strings.string;

/**
 * Посчитать количество всех точек, запятых и восклицательных знаков в строке.
 */

public class Task_04 {

    public static void main(String[] args) {

        String value = "Java is the best language! Many different programmes were written o JAVA. It is great, that i can understand " +
                "this language and write come code on it. But, I still have to improve my own knowledge!!!";

        System.out.println("Первый способ: " + countSymbols(value));
        System.out.println("Второй способ: " + count(value));
    }

    /**
     * Так тоже можно решать. Заменяем в строке нужные нам символы на пустое значение и находим разницу длины исходной строки и строки с
     * замененными символами.
     */

    public static int countSymbols(String value) {
        String replace = value.replace(".", "").replace(",", "").replace("!", "");
        // метод replace возвращает String и его можно вызывать несколько раз через точку
        return value.length() - replace.length();
    }

    /**
     * Так тоже можно решать. Представляем строку в виде массива char'ов и в for'е перебираем массив. Если находим совпадение, то
     * увеличиваем счетчик.
     */
    public static int count(String value) {
        int count = 0;
        char[] chars = value.toCharArray();
        for (int i = 0; i < value.toCharArray().length; i++) {
            if ('!' == chars[i] || '.' == chars[i] || ',' == chars[i]) {
                count++;
            }
        }
        return count;
    }
}