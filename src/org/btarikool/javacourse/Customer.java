package org.btarikool.javacourse;

public class Customer {
    Budget budget;
    Allergie allergie;
    Noise noiseSensitivity;
    public Customer(double amount, Currency currency, Allergie allergie, Noise noiseSensitivity) {
        this.budget = new Budget(currency, amount);
        this.allergie = allergie;
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
                "budget=" + budget +
                ", allergie=" + allergie +
                ", noiseSensitivity=" + noiseSensitivity +
                '}';
    }
}
