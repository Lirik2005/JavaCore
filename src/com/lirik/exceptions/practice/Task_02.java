package com.lirik.exceptions.practice;

/**
 * Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException
 */

public class Task_02 {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int i = 0;

        try {
            i = array[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e);
        }
    }

}
