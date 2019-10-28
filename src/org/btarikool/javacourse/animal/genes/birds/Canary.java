package org.btarikool.javacourse.animal.genes.birds;

import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.genes.Bird;
import org.btarikool.javacourse.animal.types.Noisy;

public class Canary extends Bird implements Noisy {
    @Override
    public void makeNoise() {
        this.noise = new Noise(60, Noise.Feature.MELODIC);
        System.out.println("Canary makes noise:" + this.noise);

    }
}
