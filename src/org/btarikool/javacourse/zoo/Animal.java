package org.btarikool.javacourse.zoo;

public abstract class Animal {
    private String nick;
    private String sex;
    private String price;
    private Settings settings = new Settings();

    public Animal(int i) {
        this.nick = settings.getNick(i);
        this.sex = settings.getSex(i);
        this.price = settings.getPrice(i);
    }

    public String getNick() {
        return nick;
    }

    public String getSex() {
        return sex;
    }

    public String getPrice() {
        return price;
    }

    public Settings getSettings() {
        return settings;
    }

    @Override
    public String toString() {
        return
                "nick='" + nick + '\'' +
                ", sex='" + sex + '\'' +
                ", price='" + price + '\'' +"\n";
    }
}
