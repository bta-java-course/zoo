package org.btarikool.javacourse.animal.genes.mammals;

import org.btarikool.javacourse.animal.genes.Mammalia;

public class Macaque extends Mammalia {
    Noise noise;
    @Override
    public void makeNoise() {
        System.out.println("Macaque makes Noise: " + this.noise);
        this.noise = new Noise(level 100, Noise.Feature.UNEXPECTED);
    }
}
}
