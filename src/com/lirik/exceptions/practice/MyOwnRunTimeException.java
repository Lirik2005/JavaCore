package com.lirik.exceptions.practice;

/**
 * Конструктор нашего собственного исключения перегружен и принимает сообщение или другой Exception и много чего еще!!!
 * См. конструктор.
 */

public class MyOwnRunTimeException extends RuntimeException {

    public MyOwnRunTimeException(String message) {
        super(message);
    }

    public MyOwnRunTimeException(Throwable cause) {
        super(cause);
    }
}
