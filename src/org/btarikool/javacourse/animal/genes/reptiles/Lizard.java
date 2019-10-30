package org.btarikool.javacourse.animal.genes.reptiles;

import org.btarikool.javacourse.Allergie;
import org.btarikool.javacourse.animal.genes.Reptilia;
import org.btarikool.javacourse.animal.types.Allergene;

public class Lizard extends Reptilia implements Allergene {


    @Override
    public void makesAllergie() {
        this.makingAllergie = Allergie.SMELL;
        System.out.println("Lizard makes Allergie" + this.makingAllergie);
    }

}

