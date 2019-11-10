package org.btarikool.javacourse;

import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    private static Comparator instance = new Comparator();

    private Comparator() {
    }

    public static Comparator getInstance() {
        return instance;
    }

    public boolean checkCompatibilityAnimalCustomer(Customer customer, Animal animal) {
        List<Boolean> checkingList = new ArrayList<>();
        checkingList.add(checkForNoise(customer, animal));
        checkingList.add(checkForPrice(customer, animal));
        checkingList.add(checkForAllergen(customer, animal));
        checkingList.forEach(System.out::println);
        return !checkingList.contains(false);
    }

    private boolean checkForNoise(Customer customer, Animal animal) {
        boolean comp = true;
        if (animal instanceof Noisy)  comp = ((Noisy) animal).checksCompatibilityNoise(customer, animal);
        return comp;
    }

    private boolean checkForAllergen(Customer customer, Animal animal) {
        boolean comp = true;
        if (animal instanceof Allergenic)  comp = ((Allergenic) animal).checksCompatibilityAllergen(customer, animal);
        return comp;
    }

    private boolean checkForPrice(Customer customer, Animal animal) {
        return customer.getBudget().getCurrency().convertToEur(customer.getBudget().getAmount()) >= animal.getPrice().getPrice();
    }

    public boolean checkAnimalsCompatibility(Customer customer, Animal animal) {
        boolean comp = false;
        if (animal instanceof Allergenic) comp = ((Allergenic) animal).checksCompatibilityAnimals(customer, animal);
        return comp;
    }

}
