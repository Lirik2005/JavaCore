package com.lirik.collections.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Написать метод isUnique, который принимает Map<String, String> и возвращает true, если каждому ключу соответствует свое уникальное
 * значение.
 * Например, в данном случае вернется true:
 * {Marty=Step, Stuart=Rages, Jessica=Miller, Amanda=Camp, Hal=Perkins}
 * А в данном случае вернется false:
 * {Kendrick-Perkins, Stuart=Rages, Jessica=Miller, Bruce=Rages, Amanda=Camp, Hal=Perkins}
 */

public class Task_03 {

    public static void main(String[] args) {

        Map<String, String> trueMap = new HashMap<>();

        trueMap.put("Marty", "Step");
        trueMap.put("Stuart", "Rages");
        trueMap.put("Jessica", "Miller");
        trueMap.put("Amanda", "Camp");
        trueMap.put("Hal", "Perkins");

        Map<String, String> falseMap = Map.of(
                "Kendrick", "Perkins",
                "Stuart", "Rages",
                "Jessica", "Miller",
                "Bruce", "Rages",
                "Amanda", "Camp",
                "Hal", "Perkins"
        );

        System.out.println(isUnique(trueMap));
        System.out.println(isUnique(falseMap));
    }

    public static boolean isUnique(Map<String, String> map) {
        Set<String> set = new HashSet<>(map.values());
        return map.size() == set.size();

        /**
         * Можно и через if-else, но запись в строке 45 более прапвильная!!!
         */

       /* if (map.size() == set.size()) {
            return true;
        }
        return false; */
    }
}

