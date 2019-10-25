package org.btarikool.javacourse;

import java.util.List;

public class Customer {

    private double budget;
    private CustomerSpecifications specifications;

    public Customer(List<Customer> list) {
        this.specifications = new CustomerSpecifications();
        CustomerInfoFill.fillingCustomerFields(this);
        list.add(this);
    }

    public CustomerSpecifications getSpecifications() {
        return this.specifications;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

}
