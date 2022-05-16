package com.lirik.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);  // неизменяемая коллекция
        List<Integer> newList = new ArrayList<>(list);

        /**
         * Ниже приведен итератор или по-другому цикл foreach (для быстрого вызова достаточно написать iter)
         */

        for (Integer integer : list) {
            System.out.print(integer);
        }
        System.out.println();

        /**
         * По указанному ниже принципу и работает итератор (реализация через while)
         */

        Iterator<Integer> firstIterator = list.iterator();
        while (firstIterator.hasNext()) {
            Integer next = firstIterator.next();
            System.out.print(next);
        }
        System.out.println();

        /**
         * По указанному ниже принципу и работает итератор (реализация через for)
         */

        for (Iterator<Integer> secondIterator = list.iterator(); secondIterator.hasNext(); ) {
            Integer next = secondIterator.next();
            System.out.print(next);
        }
        System.out.println();

        /**
         * Указанным ниже способом мы можем удалить из коллекции значения (в цикле foreach это сделать нельзя, т.к. он только для чтения)
         */

        for (Iterator<Integer> thirdIterator = newList.iterator(); thirdIterator.hasNext(); ) {
            Integer next = thirdIterator.next();
            if (next == 4 || next == 5) {
                thirdIterator.remove();
            }
        }
        System.out.print(newList);

    }
}
