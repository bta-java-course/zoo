package org.btarikool.javacourse;

public class Currency {
    private  Currency(String name) {
        this.name = name;
    }
    public static  final  Currency EUR = new Currency("EUR");
    public static  final  Currency USD = new Currency("USD");
    public static  final  Currency RUB = new Currency("RUB");
    public static  final  Currency SEK = new Currency("SEK");
    }

