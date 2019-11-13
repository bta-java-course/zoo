package org.btarikool.javacourse.zoo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Budget budget;
    private  String name;
    private List<String> allergy;
    private  int age;
    private static List<Customer> listOfCustomers = new ArrayList<>();

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

    public static List<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getAllergy() {
        return allergy;
    }

    public void setAllergy(List<String> allergy) {
        this.allergy = allergy;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "budget=" + budget +
                ", name='" + name + '\'' +
                ", allergy='" + allergy + '\'' +
                ", age=" + age +
                '}';
    }

    public static void writeToLog() {
        StringBuilder toLog = new StringBuilder("Customers: \n");
        for (Customer check : listOfCustomers) {
            toLog.append(check +"\n");
        }
        try {
            FileWriter writer = new FileWriter("log/customerslist_out.log");
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(toLog);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
