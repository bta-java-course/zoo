package org.btarikool.javacourse;

public class  Noise {

    double level;
    Feature feature;
    public enum Feature {

        SHARP("SHARP"),
        MELODIC("MELODIC"),
        UNEXPECTED("UNEXPECTED");

        String type;

        Feature(String type) {
            this.type = type;
        }

    }

    public Noise() {

    }

    public Noise(double level, Feature feature) {
        this.level = level;
        this.feature = feature;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        boolean notNull = feature != null;
        if (notNull)
            return "feature: " + feature.name() +
                    ", level: " + level;
        else
            return "empty";
    }
}