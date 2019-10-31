package org.btarikool.javacourse;

public class  Noise {

    double level;
    Feature feature;
    enum Feature {

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

    public Noise(double level, Feature feature) {
        this.level = level;
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "Noise{" +
                "level=" + level +
                ", feature=" + feature +
                '}';
    }
}