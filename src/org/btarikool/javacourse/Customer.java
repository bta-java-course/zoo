package org.btarikool.javacourse;

public class Customer {
<<<<<<< HEAD
   class budget {
       int budget = 5000;
       double summa;

   }

   public interface CurrencyConverter {
        float convert(String currencyFrom, String currencyTo)
                throws Exception;
    }
   public static void allergie() {
         String dogAllergy;
         String catAllergy;
         String featherAllergy;
=======
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
>>>>>>> origin/master_p2-7_2-8
    }
}
