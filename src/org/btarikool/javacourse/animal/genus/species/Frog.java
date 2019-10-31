package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.animal.genus.Amphibian;

import java.util.HashSet;
import java.util.Set;

public class Frog extends Amphibian  implements Allergenic, Noisy {

    private Set<String> compatibility = new HashSet<>();

    public Frog() {
    }

    public Frog(String nick, int age, double price, boolean sex) {
        super(nick, age, price, sex);
    }

    public Set<String> getCompatibility() {
        return compatibility;
    }

    public void addCompatibility(String compatibility) {
        this.compatibility.add(compatibility);
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
