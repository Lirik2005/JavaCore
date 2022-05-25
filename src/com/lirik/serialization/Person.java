package com.lirik.serialization;

import java.io.Serializable;

/**
 * Чтобы объект класса можно было сериализовать / демериализовать, класс должен реализовывать интерфейс Serializable. Это
 * интерфейс-маркер, в котором нет методов!!!
 * <p>
 * Поле serialVersionUID необходимо для того, чтобы при изменении нашего класса объект смог правильно десириализоваться из файла. Без
 * этого поля будет exception!!!
 * Если поле пометить словом transient, то данное поле сериализоваться в файл не будет
 */

public class Person implements Serializable {

    private static final long serialVersionUID = -7966413792559994323L;  // значение может быть абсолютно любым!!!
    private int age;

    private String firstName;

    private transient String lastName;

    public Person(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
