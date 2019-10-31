package org.btarikool.javacourse;

import java.util.ArrayList;
import java.util.List;

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

        @Override
        public String toString() {
            return "Feature{" +
                    "type='" + type + '\'' +
                    '}';
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
        return "feature: " + feature.name() +
                "(level: " + level + ")";

    }
}