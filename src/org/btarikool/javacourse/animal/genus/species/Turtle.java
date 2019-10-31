package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.animal.genus.Reptile;

import java.util.HashSet;
import java.util.Set;

public class Turtle extends Reptile  implements Allergenic{

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

    @Override
    public void makesAllergy() {

    }

    @Override
    public void checksCompatibilityWithAnimals() {

    }
}
