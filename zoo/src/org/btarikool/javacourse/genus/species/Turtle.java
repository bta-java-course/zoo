package org.btarikool.javacourse.genus.species;

import org.btarikool.javacourse.genus.Reptile;

import java.util.HashSet;
import java.util.Set;

public class Turtle extends Reptile {

    private Set<String> compatibility = new HashSet<>();

    public Turtle() {
    }

    public Turtle(String nick, int age, double price, boolean sex) {
        super(nick, age, price, sex);
    }

    public Set<String> getCompatibility() {
        return compatibility;
    }

    public void addCompatibility(String compatibility) {
        this.compatibility.add(compatibility);
    }

}
