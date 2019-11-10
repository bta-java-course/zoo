package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.customer.Customer;

public interface Allergenic {

    void makesAllergy();

    default boolean checksCompatibilityAllergen(Customer customer, Animal animal) {
        if (customer.getSpecifications().getAllergens().isEmpty())
            return true;
        else
            return customer.getSpecifications().getAllergens().stream().
                    noneMatch(a -> animal.getAnimalSpecifications().getAllergens().contains(a));
    }

    default boolean checksCompatibilityAnimals(Customer customer, Animal animal) {
            return customer.getPurchasedList().stream().
                    anyMatch(a ->
                            a.getAnimalSpecifications().getAllergens().stream().
                            anyMatch(b ->
                                    animal.getAnimalSpecifications().getAllergens().contains(b)));
    }

}
