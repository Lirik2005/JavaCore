package com.lirik.enums;

/**
 * В блоках кода мы переопределяем абстрактный метод или интерфейс
 */

public enum Bank implements Describable {
    ALFA_BANK("Альфа-Банк") {
        @Override
        public String getInterfaceDescription() {
            return "ALFA_BANK interface description";
        }

        @Override
        public String getAbstractMethodDescription() {
            return "ALFA_BANK abstract description";
        }
    },
    TINKOFF_BANK("Тинькофф-Банк") {
        @Override
        public String getInterfaceDescription() {
            return "TINKOFF_BANK interface description";
        }

        @Override
        public String getAbstractMethodDescription() {
            return "TINKOFF_BANK abstract description";
        }
    },
    SBER_BANK("Сбербанк") {
        @Override
        public String getInterfaceDescription() {
            return "SBER_BANK interface description";
        }

        @Override
        public String getAbstractMethodDescription() {
            return "SBER_BANK abstract description";
        }
    };

    private final String name;

    Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getAbstractMethodDescription();
}
