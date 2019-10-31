package org.btarikool.javacourse.animal.genus;

import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.animal.AnimalSpecifications;
import org.btarikool.javacourse.animal.Price;

public class Bird extends Animal {

    public Bird() {
    }

    public Bird(String nick, Price price, AnimalSpecifications animalSpecifications, int age, boolean sex) {
        super(nick, price, animalSpecifications, age, sex);
    }
}
