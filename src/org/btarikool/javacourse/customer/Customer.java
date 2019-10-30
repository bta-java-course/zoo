package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.enums.Allergen;

import java.util.List;

public class Customer {

    private Budget budget;
    private CustomerSpecifications specifications;
    private Allergen allergen;

/*    public Customer(List<Customer> list) {
        this.specifications = new CustomerSpecifications();
        CustomerInfoFill.fillingCustomerFields(this);
        list.add(this);
    }*/

    public Customer(List<Customer> list) {
        this.specifications = new CustomerSpecifications();
        CustomerInfoFill.fillingCustomerFields(this);
        list.add(this);
    }

    public Customer(Budget budget, CustomerSpecifications specifications, Allergen allergen) {
        this.budget = budget;
        this.specifications = specifications;
        this.allergen = allergen;
    }

    public CustomerSpecifications getSpecifications() {
        return this.specifications;
    }

    public Budget getBudget() {
        return budget;
    }

}
