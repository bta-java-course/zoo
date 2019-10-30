package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.enums.Psychotype;
import org.btarikool.javacourse.enums.Allergen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalSpecifications {
    private boolean isLoud;
    private double size;
    private boolean cityLivingAble;
    private int livingYears;
    private List<Allergen> allergens = new ArrayList<>();
    private Psychotype psychotype;

    public boolean isLoud() {
        return isLoud;
    }

    public void setLoud(boolean loud) {
        isLoud = loud;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isCityLivingAble() {
        return cityLivingAble;
    }

    public void setCityLivingAble(boolean cityLivingAble) {
        this.cityLivingAble = cityLivingAble;
    }

    public int getLivingYears() {
        return livingYears;
    }

    public void setLivingYears(int livingYears) {
        this.livingYears = livingYears;
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

    public Psychotype getPsychotype() {
        return psychotype;
    }

    public void setPsychotype(String psychotype) {
        this.psychotype = Psychotype.valueOf(psychotype);
    }

    @Override
    public String toString() {
        return "AnimalSpecifications: " +
                "Is loud: " + isLoud +
                ", Size: " + size +
                ", CityLivingAble: " + cityLivingAble +
                ", LivingYears: " + livingYears +
                ", Allergens: " + allergens +
                ", Psychotype: " + psychotype + "\n";
    }
}
