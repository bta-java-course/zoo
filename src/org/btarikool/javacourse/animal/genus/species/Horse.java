package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.animal.genus.Mammal;

import java.util.HashSet;
import java.util.Set;

public class Horse extends Mammal {

    private Set<String> compatibility = new HashSet<>();

    public Horse() {
    }

    public Horse(String nick, int age, double price, boolean sex) {
        super(nick, age, price, sex);
    }

    public Set<String> getCompatibility() {
        return compatibility;
    }

    public void addCompatibility(String compatibility) {
        this.compatibility.add(compatibility);
    }

}
