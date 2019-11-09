package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.animal.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basket {
    private List<Animal> basketList;

    public Basket() {
        basketList = new ArrayList<>();
    }

    public List<Animal> getBasketList() {
        return basketList;
    }

    public void setBasketList(List<Animal> basketList) {
        this.basketList = basketList;
    }

    public boolean checkBasketListAnimalsAllergens(List<Allergen> allergensList) {
        boolean compatible = false;
        for (Animal animalFromBasket : basketList) {
            if (allergensList.stream().
                    anyMatch(allergen -> animalFromBasket.getAnimalSpecifications().getAllergens().contains(allergen)))
                compatible = true;
        }
        return compatible;
    }
}
