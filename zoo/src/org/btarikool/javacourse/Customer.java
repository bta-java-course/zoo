package org.btarikool.javacourse;

public class Customer {

    private CustomerSpecifications specifications;

    public Customer() {
        this.specifications = new CustomerSpecifications();
    }

    public CustomerSpecifications getSpecifications() {
        return this.specifications;
    }

}
