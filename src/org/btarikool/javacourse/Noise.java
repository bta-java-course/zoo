package org.btarikool.javacourse;

public class Noise {

    public static final Noise HARD_MELODIC = new Noise(90, new Feature(true, true, false));
    double level;
    Feature feature;
    static class Feature {
        boolean melodic;
        boolean sharp;
        boolean sudden;

        public Feature(boolean melodic, boolean sharp, boolean sudden) {
            this.melodic = melodic;
            this.sharp = sharp;
            this.sudden = sudden;
        }
    }
    public Noise(double level, Feature feature) {
        this.level = level;
        this.feature = feature;
    }
}
