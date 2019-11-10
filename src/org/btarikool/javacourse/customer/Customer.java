package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.Collections;
import org.btarikool.javacourse.animal.Animal;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Customer {

    private String name;
    private Budget budget;
    private MessageDigest password;
    private CustomerSpecifications specifications;
    private Set<Animal> purchasedList;
    private Basket basket;

    public Customer() {
        purchasedList = new HashSet<>();
        basket = new Basket();
        this.budget = new Budget();
        this.specifications = new CustomerSpecifications();
    }

    public Customer(String name, Budget budget, CustomerSpecifications specifications, Allergen allergen) {
        this.name = name;
        this.budget = budget;
        this.specifications = specifications;
    }

    public MessageDigest getPassword() {
        return password;
    }

    public void setPassword(MessageDigest password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Set<Animal> getPurchasedList() {
        return purchasedList;
    }

    public void setPurchasedList(Set<Animal> purchasedList) {
        this.purchasedList = purchasedList;
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
        return "Customer #" + Collections.getInstance().getCustomersList().indexOf(this) + "\n" +
                "name: " + name
                + "\npassword: " + password.digest()
                + budget
                + specifications;
    }
}
