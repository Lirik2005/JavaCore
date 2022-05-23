package com.lirik.functionalprogramming;

import java.util.Comparator;

public class LambdaExample {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new IntegerComparator();

        System.out.println("Обычный Comparator:");
        System.out.println(comparator.compare(25, 100));  // на выходе будет -1, потому что 25 < 100
        System.out.println(comparator.compare(100, 100));  // на выходе будет 0, потому что 100 = 100
        System.out.println(comparator.compare(100, 25));  // на выходе будет 1, потому что 100 > 25

        System.out.println();
        System.out.println("Comparator в анонимном классе:");

        /**
         * Можно не имплементировать в класс Comparator, а делать следующую запись, но так сейчас уже не делают!!!
         */

        Comparator<Integer> anonymousComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(anonymousComparator.compare(25, 100));  // на выходе будет -1, потому что 25 < 100
        System.out.println(anonymousComparator.compare(100, 100));  // на выходе будет 0, потому что 100 = 100
        System.out.println(anonymousComparator.compare(100, 25));  // на выходе будет 1, потому что 100 > 25


        System.out.println();
        System.out.println("Comparator в Lambda-выражении:");

        /**
         * В случае с lambda-выражением нам не требуется все то, что написано начиная с 31 строки!!!
         */

        Comparator<Integer> lambdaComparator = (Integer o1, Integer o2) -> {
            return Integer.compare(o1, o2);
        };

        System.out.println(lambdaComparator.compare(25, 100));  // на выходе будет -1, потому что 25 < 100
        System.out.println(lambdaComparator.compare(100, 100));  // на выходе будет 0, потому что 100 = 100
        System.out.println(lambdaComparator.compare(100, 25));  // на выходе будет 1, потому что 100 > 25

        System.out.println();
        System.out.println("Улучшенная запись Comparator'а в Lambda-выражении:");

        /**
         * Если функция состоит лишь из одной строки, то фигурные скобки и слово return можно опустить. Учитывая, что наш компаратор
         * принимает Integer, то и тип данных у входных параметров тоже можно опустить.
         */

        Comparator<Integer> newLambdaComparator = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println(newLambdaComparator.compare(25, 100));  // на выходе будет -1, потому что 25 < 100
        System.out.println(newLambdaComparator.compare(100, 100));  // на выходе будет 0, потому что 100 = 100
        System.out.println(newLambdaComparator.compare(100, 25));  // на выходе будет 1, потому что 100 > 25

        System.out.println();
        System.out.println("Method reference Comparator'а в Lambda-выражении:");

        /**
         * Lambda-выражение можно представить в виде method reference. Тут подскажет IntelliJIdea!!!
         */

        Comparator<Integer> methodReferenceLambdaComparator = Integer::compare;

        System.out.println(methodReferenceLambdaComparator.compare(25, 100));  // на выходе будет -1, потому что 25 < 100
        System.out.println(methodReferenceLambdaComparator.compare(100, 100));  // на выходе будет 0, потому что 100 = 100
        System.out.println(methodReferenceLambdaComparator.compare(100, 25));  // на выходе будет 1, потому что 100 > 25
    }

    private static class IntegerComparator implements Comparator<Integer> {

        @Override

        // Метод состоит из: [модификатор доступа] - [возвращаемый тип] - [название] - ([параметры]) {[тело метода]}
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
        // Lambda-выражение функционального интерфейса не требует от нас модификатора доступа, возвращаемого типа и названия.
        // Lambda-выражение интерфейса Comparator выглядит следующим образом:

        // (Integer o1, Integer o2) {
        //     return Integer.compare(o1, o2);
        // }


    }
}
