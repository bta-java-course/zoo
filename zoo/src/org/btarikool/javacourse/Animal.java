package org.btarikool.javacourse;

public abstract class Animal {
    private String nick;
    private int id;
    private static int idCounter = 0;
    private int age;
    private double price;
    private boolean sex;
    private AnimalSpecifications animalSpecifications;

    public Animal() {
        this.id = idCounter;
        idCounter++;
        this.animalSpecifications = new AnimalSpecifications();
    }

    public Animal(String nick, int age, double price, boolean sex) {
        this.nick = nick;
        this.id = idCounter;
        idCounter++;
        this.age = age;
        this.price = price;
        this.sex = sex;
        this.animalSpecifications = new AnimalSpecifications();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}
