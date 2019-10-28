package org.btarikool.javacourse;

public class Noise {

    // public static final Noise HARD_MELODIC = new Noise(90, new Feature(true, true, false));
    double level;
    Feature feature;

    public static class Feature {

        public static final Feature MELODIC = new Feature("Melodic");
        public static final Feature SHARP = new Feature("Sharp");
        public static final Feature SUDDEN = new Feature("Sudden");
        String type;

        private Feature(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Feature {" + "type = " + type + '\'' + '}';
        }

    }

    public Noise(double level, Feature feature) {
        this.level = level;
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "Noise {" + "level =" + level + ", feature" + '}';
    }
}



