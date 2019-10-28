package org.btarikool.javacourse.zoo;

public class Customer {
    private Budget budget;

    class Budget {
        String currency;
        double amount;
        public Budget(double theAmount, String theCurrency){
            this.amount = theAmount;
            this.currency = theCurrency;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
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
            return "amount=" + amount +
                    ", currency='" + currency + '\'';
        }
    }
    //to be implemented..
   /* enum psychoType {
        SANGUINE, CHOLERIC, MELANCHOLIC, PHLEGMATIC;
    }*/

    public Customer(double theAmount, String theCurrency) {
        this.budget = new Budget(theAmount, theCurrency);

    }

    public Budget getBudget() {
        return this.budget;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "budget: " + budget +
                '}';
    }
}
