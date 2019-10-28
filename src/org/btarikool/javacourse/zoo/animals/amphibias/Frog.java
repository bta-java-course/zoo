package org.btarikool.javacourse.zoo.animals.amphibias;

import org.btarikool.javacourse.zoo.Noise;
import org.btarikool.javacourse.zoo.animal.types.MakesNoise;
import org.btarikool.javacourse.zoo.genus.Amphibia;

public class Frog extends Amphibia implements MakesNoise {
    private String noiseType;
    private int noiseLevel;

    public Frog() {
        makeNoise();
    }

    @Override
    public void makeNoise() {
        Noise.setNoiseLevel(20);
        this.noiseLevel = Noise.getNoiseLevel();
        Noise.NoiseType theNoiseType = Noise.NoiseType.UNREASONABLE;
        this.noiseType = theNoiseType.getNoiseType();
    }

    public String getNoiseType() {
        return noiseType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", noiseType= " + noiseType +
                ", noiseLevel= " + noiseLevel;
    }
}
