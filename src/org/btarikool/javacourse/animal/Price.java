package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.Currency;

public class Price {
    private double price;
    private Currency currency;

    public Price(double price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public Price() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price: " + price +
                ", Currency: " + currency;
    }
}
