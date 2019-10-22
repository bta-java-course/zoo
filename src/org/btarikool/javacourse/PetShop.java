package org.btarikool.javacourse;

class PetShop {

    public static void main(String[] args) {
        String[] petNames = Settings.getShopPetsNicks();
        Bird bird1 = new Bird (petNames[4]);
        Fish fish1 = new Fish (petNames [3]);
        Reptilia reptilia1 = new Reptilia (petNames[0]);
        Amphibia amphibia = new Amphibia(petNames [1]);
        Mammalia mammalia = new Mammalia(petNames [2]);

        System.out.println(bird1);
        System.out.println(fish1);
        System.out.println(reptilia1);
        System.out.println(amphibia);
        System.out.println(mammalia);
    }

}
