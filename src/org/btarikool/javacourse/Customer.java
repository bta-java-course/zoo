package org.btarikool.javacourse;

import java.util.List;

public class Customer {
    String name;
    int age;
    Budget budget;
    List<Allergie> allergies;
    Noise noiseSensitivity;
    public Customer(String name, int age, double amount, Currency currency,
                    List<Allergie> allergies, Noise noiseSensitivity) {
        this.name = name;
        this.age = age;
        this.budget = new Budget(currency, amount);
        this.allergies = allergies;
        this.noiseSensitivity = noiseSensitivity;

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
                    ", amount=" + amount +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name=" + name +
                "age=" + age +
                "budget=" + budget +
                ", allergies=" + allergies +
                ", noiseSensitivity=" + noiseSensitivity +
                '}';
    }
}