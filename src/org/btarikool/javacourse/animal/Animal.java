package org.btarikool.javacourse.animal;

public abstract class Animal {
     String animalName;
     int inddex;

     public Animal(String name) {
         this.animalName=name;
     }
     @Override
    public String toString() {
         return this.animalName;
     }
}
