package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.AnimalSpecifications;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.animal.Price;
import org.btarikool.javacourse.animal.genus.Mammal;

public class Cat extends Mammal implements Allergenic, Noisy {

    public Cat() {
    }

    public Cat(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        super(nick, price, animalSpecifications, age, sex);
    }

    @Override
    public void makesAllergy() {
        this.getAnimalSpecifications().setAllergens(Allergen.URINE, Allergen.DANDRUFF, Allergen.SALVIA);
    }

    @Override
    public void makesNoise() {
        this.getAnimalSpecifications().setNoise(new Noise(33.1, Noise.Feature.SHARP));
    }

}
