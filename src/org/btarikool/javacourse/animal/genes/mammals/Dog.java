package org.btarikool.javacourse.animal.genes.mammals;

 HEAD
public class Dog {

import org.btarikool.javacourse.animal.genes.Mammalia;

public class Dog extends Mammalia {
    Noise noise;
    @Override
    public void makeNoise() {
        System.out.println("Dog makes Noise: " + this.noise);
        this.noise = new Noise(level 100, Noise.Feature.UNEXPECTED);
    }
}
}

