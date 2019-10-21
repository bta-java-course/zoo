package org.btarikool.javacourse;

public class AnimalSpecifications {
    private boolean isLoud;
    private double size;
    private boolean cityLivingAble;
    private int livingYears;
    private Allergen[] allergen;
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
