package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.animal.genus.Reptile;

import java.util.HashSet;
import java.util.Set;

public class Crocodile extends Reptile {

    private Set<String> compatibility = new HashSet<>();

    public Crocodile() {
    }

    public Crocodile(String nick, int age, double price, boolean sex) {
        super(nick, age, price, sex);
    }

    public Set<String> getCompatibility() {
        return compatibility;
    }

    public void addCompatibility(String compatibility) {
        this.compatibility.add(compatibility);
    }

}
