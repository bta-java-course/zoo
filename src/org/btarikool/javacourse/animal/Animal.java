package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.animal.genus.Genus;
import org.btarikool.javacourse.animal.genus.species.Species;

public abstract class Animal {
    private String nick;
    private Genus genus;
    private Species species;
    private int id;
    private static int idCounter = 0;
    private int age;
    private boolean sex;
    private Price price;
    private AnimalSpecifications animalSpecifications;

    public Animal() {
        this.id = idCounter;
        idCounter++;
        this.price = new Price();
        this.animalSpecifications = new AnimalSpecifications();
    }

    public Animal(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        this.nick = nick;
        this.id = idCounter;
        idCounter++;
        this.age = age;
        this.sex = sex;
        this.price = price;
        this.animalSpecifications = animalSpecifications;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public AnimalSpecifications getAnimalSpecifications() {
        return animalSpecifications;
    }

    public Genus getGenus() {
        return genus;
    }

    public String getGenusString() {
        return genus.name();
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }

    public Species getSpecies() {
        return species;
    }

    public String getSpeciesString() {
        return species.name();
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Price getPrice() {
        return price;
    }

    public double getDoublePrice() {
        return this.price.getPrice();
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SubInfo: " +
                "Id:" + id +
                ", Nick: " + nick +
                ", Genus: " + genus +
                ", Species: " + species +
                ", Age: " + age +
                ", " + price +
                ", Sex: " + (sex == true ? "Male" : "Female") +
                "\n" + animalSpecifications;
    }
}



