public abstract class Animal {
    private String nick;
    private String species;
    private String sex;
    private double price;
    Settings settings = new Settings();

    public  Animal(String s){
        this.settings.getNick(s);
        this.settings.getSpecies(s);
        this.settings.getSex(s);
        this.settings.getPrice(s);

    }
    public String getNick(){
        return nick;
    }
    public String getSpecies(){
        return species;
    }
    public String getSex(){
        return sex;
    }
    public double getPrice(){
        return price;
    }


}
