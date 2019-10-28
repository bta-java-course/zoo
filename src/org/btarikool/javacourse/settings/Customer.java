package org.btarikool.javacourse.settings;

import org.btarikool.javacourse.Currency;

public class Customer {
    Budget budget;
    class Budget{
        Currency currency;
        double amount;
        public  Budget(Currency currency, double amount){
            this.currency = currency;
            this.amount = amount;
        }


    }
    public Customer(double amount, Currency currency){
        this.budget = new Budget(currency, amount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "budget=" + budget +
                '}';
    }
}
