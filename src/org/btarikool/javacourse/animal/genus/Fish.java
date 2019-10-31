package org.btarikool.javacourse.animal.genus;

import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.animal.AnimalSpecifications;
import org.btarikool.javacourse.animal.Price;

public class Fish extends Animal {

    public Fish() {
    }

    public Fish(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        super(nick, price, animalSpecifications, age, sex);
    }
}
