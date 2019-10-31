package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.animal.genus.Bird;

import java.util.HashSet;
import java.util.Set;

public class Parrot extends Bird  implements Noisy {

    private Set<String> compatibility = new HashSet<>();

    public Parrot() {
    }

    public Parrot(String nick, int age, double price, boolean sex) {
        super(nick, age, price, sex);
    }

    public Set<String> getCompatibility() {
        return compatibility;
    }

    public void addCompatibility(String compatibility) {
        this.compatibility.add(compatibility);
    }

    @Override
    public void makesNoise() {

    }

    @Override
    public void checksCompatibilityWithCustomer() {

    }
}
