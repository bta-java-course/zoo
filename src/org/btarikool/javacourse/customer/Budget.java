package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.Currency;

public class Budget {
    private Currency currency;
    private double amount;

    public Budget() {
    }

    public Budget(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\nBudget: " +
                "amount: " + amount +
                ", currency: " + currency;
    }
}
