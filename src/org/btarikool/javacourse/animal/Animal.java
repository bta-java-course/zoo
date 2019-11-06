package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.Allergie;
import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.types.Allergene;

public abstract class Animal {
    private String nick;
    private double price;
    private String sex;
    public Noise noise;
    public Allergie makingAllergie;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nick='" + nick + '\'' +
                ", price=" + price +
                ", sex='" + sex + '\'' +
                (noise == null ? "" : ", noise=" + noise)+
                (makingAllergie == null ? "" :", makingAllergie=" + makingAllergie) +
                '}';
    }
}
