package org.btarikool.javacourse;

public class Noise {

    double level;
    Feature feature;
    static class Feature {
        public static final Feature SHARP = new Feature("SHARP");
        public static final Feature MELODIC = new Feature("MELODIC");
        public static final Feature UNEXPECTED = new Feature("UNEXPECTED");
        String type;
        private Feature(String type) {
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
