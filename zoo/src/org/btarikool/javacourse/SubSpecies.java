package org.btarikool.javacourse;

import java.util.Set;
import java.util.TreeSet;

public class SubSpecies extends Animal {

    private int id;
    private String genus;
    private Species species;

    public SubSpecies(String nick, int age, double price, boolean sex) {
        super(nick, age, price, sex);
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
