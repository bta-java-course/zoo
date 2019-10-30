package org.btarikool.javacourse.zoo.animals.birds;

import org.btarikool.javacourse.zoo.Noise;
import org.btarikool.javacourse.zoo.animal.types.MakesNoise;
import org.btarikool.javacourse.zoo.genus.Bird;

public class Parrot extends Bird implements MakesNoise {
    private int noiseLevel;
    private String noiseType;

    public Parrot() {
        makeNoise();
    }

    @Override
    public void makeNoise() {
        Noise.setNoiseLevel(120);
        this.noiseLevel = Noise.getNoiseLevel();
        Noise.NoiseType theNoiseType = Noise.NoiseType.HARSH;
        this.noiseType = theNoiseType.getNoiseType();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", noiseType='" + noiseType +
                ", noiseLevel=" + noiseLevel;
    }
}
