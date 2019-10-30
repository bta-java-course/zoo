package org.btarikool.javacourse.settings;

import org.btarikool.javacourse.Allergie;
import org.btarikool.javacourse.Currency;
import org.btarikool.javacourse.Noise;

public class Customer {
    Budget budget;
    Allergie allergie;
    Noise noseSensitivity;

    public Customer(double amount, Currency currency, Allergie allergie, Noise noseSensitivity) {
        this.budget = new Budget(currency, amount);
        this.allergie = allergie;
        this.noseSensitivity = noseSensitivity;
    }


    class Budget {
        Currency currency;
        double amount;

        public Budget(Currency currency, double amount) {
            this.currency = currency;
            this.amount = amount;
        }


        @Override
        public String toString() {
            return "Budget{" +
                    "currency=" + currency +
                    ",amount= " + amount +
                    '}';

        }
    }
    @Override
    public String  toString(){
        return "Customer{" +
                "Budget =" + budget +
                ", allergie =" + allergie +
                ", noiseSensitivity =" + noseSensitivity +
                '}';
    }

}