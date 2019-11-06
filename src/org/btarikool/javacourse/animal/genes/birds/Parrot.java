package org.btarikool.javacourse.animal.genes.birds;

import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.genes.Bird;
import org.btarikool.javacourse.animal.types.Noisy;

public class Parrot extends Bird implements Noisy {
    @Override
    public void makesNoise() {
        this.noise = new Noise(100, Noise.Feature.UNEXPECTED);
        System.out.println("Parrot makes noise: " + this.noise);
    }
}
