package org.btarikool.javacourse.customer;

import org.btarikool.javacourse.Allergen;
import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.Psychotype;
import org.btarikool.javacourse.animal.Noisy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerSpecifications {
    private int volumeOfHousing;
    private boolean livingPlaceIsCity;
    private int age;
    private List<Noise> noiseList= new ArrayList<>();
    private List<Allergen> allergens = new ArrayList<>();
    private Psychotype psychotype;

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

    public void addNoise(Noise.Feature feature) {
        Noise noise = new Noise();
        noise.setFeature(feature);
        noiseList.add(noise);
    }

    public Psychotype getPsychoType() {
        return psychotype;
    }

    public void setPsychoType(Psychotype psychotype) {
        this.psychotype = psychotype;
    }

    @Override
    public String toString() {
        return "\nCustomerSpecifications: " +
                "age :" + age +
                ", volumeOfHousing: " + volumeOfHousing +
                ", living place is city: " + livingPlaceIsCity +
                "\nNoise sensitivity: " + noiseList +
                "\nAllergens: " + allergens +
                "\nPsycho Type: " + psychotype;
    }
}
