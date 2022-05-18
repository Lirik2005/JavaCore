package com.lirik.collections.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Сложить два многочлена заданной степени, если коэффициенты хранятся в объекте HashMap в виде:
 * Ключ: номер степени
 * Значение: значение множителя
 * Вывести результирующий многочлен в виде строки: ax^6 + bx^4 + cx^3 +dx + 8
 */

public class Task_04 {

    public static void main(String[] args) {

        Map<Integer, Integer> firstMap = Map.of(
                0, 5,
                1, 3,
                3, 2,
                5, 4,
                6, 7
        );

        Map<Integer, Integer> secondMap = Map.of(
                0, 5,
                3, 4,
                5, 5,
                6, 1
        );

//        8x^6 + 9x^5 + 6x^3 +3x^1 +10^0 - такой результат мы должны получить

        System.out.println(convertToString(sum(firstMap, secondMap)));
    }

    public static String convertToString(Map<Integer, Integer> map) {
        Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder()); // чтобы отсортировать коллекцию по убыванию
        result.putAll(map);
        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            String value = entry.getKey() == 0 ? String.valueOf(entry.getValue()) : entry.getValue() + "x^" + entry.getKey();
            list.add(value);
        }
        return String.join(" + ", list);

    }

    public static Map<Integer, Integer> sum(Map<Integer, Integer> firstMap,
                                            Map<Integer, Integer> secondMap) {
        Map<Integer, Integer> resultMap = new HashMap<>(firstMap);
        for (Map.Entry<Integer, Integer> entry : secondMap.entrySet()) {
            Integer value = resultMap.getOrDefault(entry.getKey(), 0);
            resultMap.put(entry.getKey(), value + entry.getValue());
        }
        return resultMap;
    }
}
