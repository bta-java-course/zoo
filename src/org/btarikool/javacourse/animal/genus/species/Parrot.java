package org.btarikool.javacourse.animal.genus.species;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.AnimalSpecifications;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.animal.Price;
import org.btarikool.javacourse.animal.genus.Bird;

public class Parrot extends Bird  implements Allergenic, Noisy {

    public Parrot() {
    }

    public Parrot(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        super(nick, price, animalSpecifications, age, sex);
    }

    @Override
    public void makesNoise() {
        this.getAnimalSpecifications().setNoise(new Noise(45.4, Noise.Feature.MELODIC));
    }

    @Override
    public void makesAllergy() {
        this.getAnimalSpecifications().setAllergens(Allergen.URINE, Allergen.SALVIA);
    }
}
