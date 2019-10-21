package org.btarikool.javacourse.zoo;

public class Customer {
    private double budget;
    private psychoType psychoTypeOfCustomer;
    enum Allergy {

    }

    enum psychoType {
        SANGUINE, CHOLERIC, MELANCHOLIC, PHLEGMATIC;
    }

    public Customer(double theBudget, String pt) {
        this.budget = theBudget;
        psychoTypeOfCustomer = psychoType.valueOf(pt);
    }

    public double getBudget() {
        return budget;
    }

    public psychoType getPsychoTypeOfCustomer() {
        return psychoTypeOfCustomer;
    }
}
