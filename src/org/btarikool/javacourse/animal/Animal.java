package org.btarikool.javacourse.animal;

import org.btarikool.javacourse.Allergie;
import org.btarikool.javacourse.Customer;
import org.btarikool.javacourse.Noise;
import org.btarikool.javacourse.animal.types.Allergene;

import java.util.Iterator;

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

    public boolean isCustomerAllergieCompatible(Customer c) {
        if(this instanceof Allergene && this.makingAllergie != null) {
            Iterator it = c.getAllergies().iterator();
            while(it.hasNext()) {
                if ((Allergie) it.next() == this.makingAllergie) {
                    return false;
                }
            }
        }
        return true;
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
