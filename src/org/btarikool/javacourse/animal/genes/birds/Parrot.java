package org.btarikool.javacourse.animal.genes.birds;

import org.btarikool.javacourse.animal.genes.Bird;

public class Parrot extends Bird implements Noisy {
    Noise noise;
    @Override
    public void makeNoise() {
        System.out.println("Parrot makes Noise: " + this.noise);
        this.noise = new Noise(level 100, Noise.Feature.UNEXPECTED);
    }
}
