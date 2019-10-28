package org.btarikool.javacourse.animal.genes.mammals;

import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.genes.Mammalia;
import org.btarikool.javacourse.animal.types.Noisy;

public class Dog extends Mammalia implements Noisy {

    @Override
    public void makeNoise(){
        this.noise = new Noise(100, Noise.Feature.SHARP);
        System.out.println("Dog makes noise" + this.noise);

    }
}
