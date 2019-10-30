package org.btarikool.javacourse.animal.genes.mammals;

import org.btarikool.javacourse.Allergie;
import org.btarikool.javacourse.animal.genes.Mammalia;
import org.btarikool.javacourse.animal.types.Allergene;

public class Hamster extends Mammalia implements Allergene {

    @Override
    public void makesAllergie() {
        this.makingAllergie = Allergie.FUR;
        System.out.println("Hamster makes Allergie" + this.makingAllergie);

    }

}

