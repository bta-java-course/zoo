package org.btarikool.javacourse;

import javafx.application.Application;
import org.btarikool.javacourse.config.Configuration;
import org.btarikool.javacourse.customer.Customer;


public class PetShop {

    private static PetShop instance = new PetShop();
    private Customer loggedInCustomer;

    private PetShop() {
    }

    static {
        Configuration.getInstance().fillAnimalsList(Collections.getInstance().getAnimalsList());
    }

    public static void main(String[] args) {
       Application.launch(PetShopInterface.class, args);
    }

    public static PetShop getInstance() {
        return instance;
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public void setLoggedInCustomer(Customer loggedInCustomer) {
        this.loggedInCustomer = loggedInCustomer;
    }

}
