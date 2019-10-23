package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.animal.genes.birds.Canary;
import org.btarikool.javacourse.animal.genes.birds.Gyps;
import org.btarikool.javacourse.animal.genes.birds.Parrot;
import org.btarikool.javacourse.animal.genes.fishes.Guppy;
import org.btarikool.javacourse.animal.genes.fishes.Oscar;
import org.btarikool.javacourse.animal.genes.fishes.Piranha;
import org.btarikool.javacourse.animal.genes.mammals.*;
import org.btarikool.javacourse.animal.genes.reptiles.Crocodile;
import org.btarikool.javacourse.animal.genes.reptiles.Lizard;
import org.btarikool.javacourse.animal.genes.reptiles.Turtle;

public abstract class Species {
    public static final int CANARY = 0;
    public static final int GYPS = 1;
    public static final int PARROT = 2;
    public static final int GUPPY = 3;
    public static final int OSCAR = 4;
    public static final int PIRANHA = 5;
    public static final int HAMSTER = 6;
    public static final int MACAQUE = 7;
    public static final int RABBIT = 8;
    public static final int DOG = 9;
    public static final int CAT = 10;
    public static final int CROCODILE = 11;
    public static final int LIZARD = 12;
    public static final int TURTLE = 13;

    public static Animal getNewAnimalBySpeciesId(int speciesId,
                                          String nick, double price, String sex) {
        Animal animal;
        switch(speciesId){
            case CANARY:
                animal = new Canary();
                break;
            case GYPS:
                animal = new Gyps();
                break;
            case PARROT:
                animal = new Parrot();
                break;
            case GUPPY:
                animal = new Guppy();
                break;
            case OSCAR:
                animal = new Oscar();
                break;
            case PIRANHA:
                animal = new Piranha();
                break;
            case HAMSTER:
                animal = new Hamster();
                break;
            case MACAQUE:
                animal = new Macaque();
                break;
            case RABBIT:
                animal = new Rabbit();
                break;
            case DOG:
                animal = new Dog();
                break;
            case CAT:
                animal = new Cat();
                break;
            case CROCODILE:
                animal = new Crocodile();
                break;
            case LIZARD:
                animal = new Lizard();
                break;
            case TURTLE:
                animal = new Turtle();
                break;
            default:
                return null;
        }
        animal.setNick(nick);
        animal.setPrice(price);
        animal.setSex(sex);
        return animal;

    }
}
