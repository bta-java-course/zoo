package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.PetShop;

import java.util.List;

public class Customer {

    private String name;
    private Budget budget;
    private CustomerSpecifications specifications;
    private Allergen allergen;

    public Customer() {
        this.budget = new Budget();
        this.specifications = new CustomerSpecifications();
    }

    public Customer(String name, Budget budget, CustomerSpecifications specifications, Allergen allergen) {
        this.name = name;
        this.budget = budget;
        this.specifications = specifications;
        this.allergen = allergen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerSpecifications getSpecifications() {
        return this.specifications;
    }

    public Budget getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Customer #" + PetShop.getCollections().getCustomersList().indexOf(this) + "\n" +
                "name: " + name
                + budget
                + specifications;
    }
}
