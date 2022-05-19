package com.lirik.exceptions.practice;

/**
 * Конструктор нашего собственного исключения перегружен и принимает сообщение или другой Exception и много чего еще!!!
 * См. конструктор.
 */

public class MyOwnException extends Exception {

    public MyOwnException(String message) {
        super(message);
    }

}
