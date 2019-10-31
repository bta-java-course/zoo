package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.AnimalSpecifications;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.animal.Price;
import org.btarikool.javacourse.animal.genus.Amphibian;

import java.util.HashSet;
import java.util.Set;

public class Frog extends Amphibian  implements Allergenic, Noisy {

    public Frog() {
    }

    public Frog(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        super(nick, price, animalSpecifications, age, sex);
    }

    @Override
    public void makesAllergy() {

    }

    @Override
    public void checksCompatibilityWithAnimals() {

    }

    @Override
    public void makesNoise() {

    }

    @Override
    public void checksCompatibilityWithCustomer() {

    }
}
