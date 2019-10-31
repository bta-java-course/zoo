package org.btarikool.javacourse;

public enum Currency {
    USD(1.17050d),
    RUB(74.90670d),
    SEK(11.34000d),
    CHF(1.10470d),
    EUR(1.0d);

    private double course;

    Currency(double course) {
        this.course = course;
    }

    public double getCourse() {
        return course;
    }

    public double convertToEur(double volume) {
        return volume / this.course;
    }

}
