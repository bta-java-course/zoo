package org.btarikool.javacourse.animal.genes.birds;

import org.btarikool.javacourse.Allergie;
import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.genes.Bird;
import org.btarikool.javacourse.animal.types.Allergene;
import org.btarikool.javacourse.animal.types.Noisy;

public class Canary extends Bird implements Noisy, Allergene {
    @Override
    public void makesNoise() {
        this.noise = new Noise(60, Noise.Feature.MELODIC);
        System.out.println("Canary makes noise: " + this.noise);
    }

    @Override
    public void makesAllergie() {
        this.makingAllergie = Allergie.SMELL;
        System.out.println("Canary makes Allergie: " + this.makingAllergie);

    }
}
