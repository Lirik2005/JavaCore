package com.lirik.reflection.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация @Target определят кто может пользоваться написанной аннотацией. Внутри указываем ElementType и через точку, того для кого
 * пишется аннотация (класс, метод, поле и т.д.). Мы можем указывать несколько ElementType одновременно (для этого используем фигурные
 * скобки)
 */

@Target({
        ElementType.TYPE,                // TYPE указывает, что аннотацию MinAge можно ставить над классом
        ElementType.FIELD,              // FIELD указывает, что аннотацию MinAge можно ставить над полем класса
        ElementType.METHOD             // METHOD указывает, что аннотацию MinAge можно ставить над методом
})
@Retention(RetentionPolicy.RUNTIME)  // аннотация не обязательная, но лучше ее использовать
public @interface MinAge {

    int age() default 18;  // если у поля с такой аннотацией не указать возраст, то по умолчанию туда станет 18
}
