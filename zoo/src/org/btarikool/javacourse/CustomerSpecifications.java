package org.btarikool.javacourse;

public class CustomerSpecifications {
    private boolean afraidOfLoudSounds;
    private double volumeOfHousing;
    private boolean livingPlaceIsCity;
    private int age;
    private Allergen[] allergen;
    private Psychotype psychotype;

    public boolean isAfraidOfLoudSounds() {
        return afraidOfLoudSounds;
    }

    public void setAfraidOfLoudSounds(boolean afraidOfLoudSounds) {
        this.afraidOfLoudSounds = afraidOfLoudSounds;
    }

    public double getVolumeOfHousing() {
        return volumeOfHousing;
    }

    public void setVolumeOfHousing(double volumeOfHousing) {
        this.volumeOfHousing = volumeOfHousing;
    }

    public boolean isLivingPlaceIsCity() {
        return livingPlaceIsCity;
    }

    public void setLivingPlaceIsCity(boolean livingPlaceIsCity) {
        this.livingPlaceIsCity = livingPlaceIsCity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Allergen[] getAllergen() {
        return allergen;
    }

    public void setAllergen(Allergen ... allergen) {
        this.allergen = allergen;
    }

    public Psychotype getPsychotype() {
        return psychotype;
    }

    public void setPsychotype(Psychotype psychotype) {
        this.psychotype = psychotype;
    }
}
