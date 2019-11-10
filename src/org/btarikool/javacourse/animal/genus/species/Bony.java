package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.AnimalSpecifications;
import org.btarikool.javacourse.animal.Price;
import org.btarikool.javacourse.animal.genus.Fish;

public class Bony extends Fish implements Allergenic {

    public Bony() {
    }

    public Bony(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        super(nick, price, animalSpecifications, age, sex);
    }

    @Override
    public void makesAllergy() {
        this.getAnimalSpecifications().setAllergens(Allergen.SALVIA);
    }
}
