package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.Psychotype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerSpecifications {
    private boolean afraidOfLoudSounds;
    private int volumeOfHousing;
    private boolean livingPlaceIsCity;
    private int age;
    private List<Allergen> allergens = new ArrayList<>();
    private Psychotype psychotype;

    public boolean isAfraidOfLoudSounds() {
        return afraidOfLoudSounds;
    }

    public void setAfraidOfLoudSounds(boolean afraidOfLoudSounds) {
        this.afraidOfLoudSounds = afraidOfLoudSounds;
    }

    public int getVolumeOfHousing() {
        return volumeOfHousing;
    }

    public void setVolumeOfHousing(int volumeOfHousing) {
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

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(String ... allergen) {
        if (allergen.length > 0 && !allergen[0].equals(""))
            Arrays.stream(allergen).
                    forEach(a -> this.allergens.add(Allergen.valueOf(a)));
        else return;
    }

    public void setAllergens(Allergen allergen) {
            allergens.add(allergen);
    }

    public Psychotype getPsychoType() {
        return psychotype;
    }

    public void setPsychoType(Psychotype psychotype) {
        this.psychotype = psychotype;
    }
}
