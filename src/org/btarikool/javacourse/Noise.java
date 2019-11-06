package org.btarikool.javacourse;

public class Noise {

<<<<<<< Updated upstream
    double level;
    Feature feature;
    public static class Feature {
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
=======
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
>>>>>>> Stashed changes
        }
    }
    public Noise(double level, Feature feature) {
        this.level = level;
        this.feature = feature;
    }
<<<<<<< Updated upstream

    @Override
    public String toString() {
        return "Noise{" +
                "level=" + level +
                ", feature=" + feature +
                '}';
    }
}
=======
}
>>>>>>> Stashed changes
