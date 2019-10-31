package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.animal.AnimalSpecifications;
import org.btarikool.javacourse.animal.Price;
import org.btarikool.javacourse.animal.genus.Fish;

import java.util.HashSet;
import java.util.Set;

public class Bony extends Fish {

    public Bony() {
    }

    public Bony(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        super(nick, price, animalSpecifications, age, sex);
    }

}
