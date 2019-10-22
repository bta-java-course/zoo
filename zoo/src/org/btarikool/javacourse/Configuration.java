package org.btarikool.javacourse;


import com.sun.xml.internal.ws.util.StringUtils;
import org.btarikool.javacourse.genus.species.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Configuration {

    private static final File PATH = new File(System.getProperty("user.dir").concat("\\zoo\\conf\\petshop.properties"));
    private static Properties prop = new Properties();
    private static Map<String, String> map = new HashMap<>();

    static {
        try (FileInputStream input = new FileInputStream(PATH)) {
            prop.load(input);
            prop.entrySet().stream().
                    filter(a -> ((String)a.getKey()).startsWith("animal")).
                    forEach(a -> map.put((String)a.getKey(), (String)a.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Configuration() {

    }

    public void fillAnimalsList(List<Animal> list) {
        Map<String, String> tempMap = createNextAnimalMap();
        Animal animal = getSpeciesClass(tempMap);
        newAnimalInitialisation(tempMap, animal);
        list.add(animal);
        while (getAnimalsCountInMap() > 0) fillAnimalsList(list);
    }

    private void newAnimalInitialisation(Map<String, String> tempMap, Animal animal) {
        animal.setNick(StringUtils.capitalize(tempMap.get("nick")));
        animal.setAge(Integer.parseInt(tempMap.get("age")));
        animal.setPrice(Double.parseDouble(tempMap.get("price")));
        animal.setSex(tempMap.get("sex").equals("true") ? true : false);
        animal.setGenus(tempMap.get("genus"));
        animal.setSpecies(tempMap.get("species"));
        animal.getAnimalSpecifications().setLoud(tempMap.get("isLoud").equals("true") ? true : false);
        animal.getAnimalSpecifications().setCityLivingAble(tempMap.get("cityLivingAble").equals("true") ? true : false);
        animal.getAnimalSpecifications().setSize(Double.parseDouble(tempMap.get("size")));
        animal.getAnimalSpecifications().setLivingYears(Integer.parseInt(tempMap.get("livingYears")));
        animal.getAnimalSpecifications().setAllergens(tempMap.get("allergen").toUpperCase().split(","));
        animal.getAnimalSpecifications().setPsychotype(tempMap.get("psychoType").toUpperCase());
    }

    private Animal getSpeciesClass(Map<String, String> tempMap) {
        Animal animal = null;
        switch (tempMap.get("species")) {
            case "frog":
                animal = new Frog();
                break;
            case "cat":
                animal = new Cat();
                break;
            case "bony":
                animal = new Bony();
                break;
            case "parrot":
                animal = new Parrot();
                break;
            case "turtle":
                animal = new Turtle();
                break;
        }
        return animal;
    }

    public Map<String, String> createNextAnimalMap() {
        int animalFromMap = getAnimalsCountInMap();
        Map<String, String> tempMap = new HashMap<>();
        stringToHashMap(getBasicInfoString(animalFromMap), tempMap);
        stringToHashMap(getSubInfoString(animalFromMap), tempMap);
        stringToHashMap(getSpecificationsString(animalFromMap), tempMap);
        return tempMap;
    }

    public String getBasicInfoString(int i) {
        String basicInfo = map.get("animal." + i);
        map.remove("animal." + i);
        return basicInfo;
    }

    public String getSubInfoString(int i) {
        String subInfo = map.get("animal." + i + ".subInfo");
        map.remove("animal." + i + ".subInfo");
        return subInfo;
    }

    public String getSpecificationsString(int i) {
        String specifications = map.get("animal." + i + ".specifications");
        map.remove("animal." + i + ".specifications");
        return specifications;
    }

    private void stringToHashMap(String string, Map<String, String> tempMap) {
     Arrays.asList(string.split(";")).
             stream().map(next -> next.split(":")).
             collect(Collectors.toMap(
                     a -> a[0],
                     a -> a.length > 1 ? a[1] : ""
             )).
             forEach((a, b) -> tempMap.put(a, b));
    }

    public int getAnimalsCountInMap() {
        int eachAnimalLinesCountInProp = 3;
        return map != null && map.size() > 0 ? map.size() / eachAnimalLinesCountInProp : 0;
    }

    public static void log(String message) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(
                    new FileWriter(
                            System.getProperty("user.dir").
                                    concat("\\zoo\\log\\log_".
                                            concat(String.valueOf(new Date().getTime())).
                                            concat(".log"))), true);
            out.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

}
