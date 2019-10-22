package org.btarikool.javacourse;

public abstract class Animals {
    String animalName;
    int index;


    public Animals(String name) {
        this.animalName = name;

    }

    @Override
    public String toString() {
        return this.animalName;
    }

}

