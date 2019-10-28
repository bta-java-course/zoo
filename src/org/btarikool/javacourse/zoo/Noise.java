package org.btarikool.javacourse.zoo;

public class Noise {
    private static int noiseLevel;

    public static enum NoiseType {
        MELODIC("melodic"),
        HARSH("harsh"),
        UNREASONABLE("unreasonable"),
        NEUTRAL("neutral");
        String returnNoiseType;

        NoiseType(String nType) {
            this.returnNoiseType = nType;
        }
        public String getNoiseType(){
            return returnNoiseType;
        }
    }

    public static int getNoiseLevel() {
        return noiseLevel;
    }

    public static void setNoiseLevel(int theNoiseLevel) {
        noiseLevel = theNoiseLevel;
    }
}
