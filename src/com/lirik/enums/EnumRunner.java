package com.lirik.enums;

import java.util.Arrays;

public class EnumRunner {

    public static void main(String[] args) {

        Bank alfaBank = Bank.ALFA_BANK;
        System.out.println(alfaBank);

        Bank tinkoffBank = Bank.TINKOFF_BANK;
        System.out.println(tinkoffBank.name());
        System.out.println(tinkoffBank.toString());  //аналогично name()

        System.out.println(Bank.valueOf("ALFA_BANK"));
        System.out.println(Arrays.toString(Bank.values()));   // возвращает массив из enum
        System.out.println(Bank.ALFA_BANK.ordinal());   // возвращает порядковый номер

        System.out.println(Bank.SBER_BANK.getName());

        Bank gazprombank = Bank.SBER_BANK;
        System.out.println(gazprombank.getAbstractMethodDescription());


    }

}
