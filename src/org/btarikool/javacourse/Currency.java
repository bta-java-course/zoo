package org.btarikool.javacourse;

public enum Currency {
    EUR, USD, RUB, SEK;

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + this.name() + '\'' +
                '}';
    }
}