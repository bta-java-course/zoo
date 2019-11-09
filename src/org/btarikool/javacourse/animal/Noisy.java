package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.customer.Customer;

public interface Noisy {
    void makesNoise();
    default boolean checksCompatibilityNoise(Customer customer, Animal animal) {
        if (customer.getSpecifications().getNoise().getFeature() == null)
            return true;
        else {
            boolean compatible;
            compatible = animal.getAnimalSpecifications().getNoise().getFeature().equals(customer.getSpecifications().getNoise().getFeature());
            if (compatible)
                compatible = animal.getAnimalSpecifications().getNoise().getLevel() < customer.getSpecifications().getNoise().getLevel();
            return compatible;
        }
    }
}
