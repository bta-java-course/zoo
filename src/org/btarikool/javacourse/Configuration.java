package org.btarikool.javacourse;


import com.sun.xml.internal.ws.util.StringUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Configuration {

    private static final File PROPPATH = new File(System.getProperty("user.dir").
            concat("\\conf\\petshop.properties"));
    private static Properties prop = new Properties();
    private static final String BASICINFO = "animal.";
    private static final String SUBINFO = "animal.subInfo.";
    private static final String SPECIFICINFO = "animal.specifications.";
    private static Map<String, String> map = new HashMap<>();

    static {
        try (FileInputStream input = new FileInputStream(PROPPATH)) {
            prop.load(input);
            prop.entrySet().stream().
                    filter(a -> ((String)a.getKey()).startsWith("animal")).
                    forEach(a -> map.put((String)a.getKey(), (String)a.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Configuration() {

    }

    public static void fillAnimalsList(List<Animal> list) {
        Map<String, String> tempMap = createNextAnimalMap();
        Animal animal = getSpeciesClass(tempMap);
        newAnimalInitialisation(tempMap, animal);
        list.add(animal);
        while (getAnimalsCountInMap() > 0) fillAnimalsList(list);
    }

    private static void newAnimalInitialisation(Map<String, String> tempMap, Animal animal) {
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

    public static void addAnimalToProp(List<Animal> list) {
        try (RandomAccessFile ra = new RandomAccessFile(PROPPATH, "r")){
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Animal getSpeciesClass(Map<String, String> tempMap) {
        Animal animal = null;
        try {
            Class clazz = Class.forName("org.btarikool.javacourse.genus.species."
                    + StringUtils.capitalize(tempMap.get("species")));
            animal = (Animal) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return animal;
    }

    private static Map<String, String> createNextAnimalMap() {
        int animalFromMap = getAnimalsCountInMap();
        Map<String, String> tempMap = new HashMap<>();
        stringToHashMap(getInfoString(animalFromMap), tempMap);
        return tempMap;
    }

    private static String getInfoString(int i) {
        String info =  map.entrySet().stream().filter(a ->
                a.getKey().equals(BASICINFO + i) ||
                a.getKey().equals(SUBINFO + i)||
                a.getKey().equals(SPECIFICINFO + i)).
                map(a -> a.getValue()).
                collect(Collectors.joining(";"));
        removeInfoFromMap(i);
        return info;
    }

    private static void removeInfoFromMap(int i) {
        map.remove(BASICINFO + i);
        map.remove(SUBINFO + i);
        map.remove(SPECIFICINFO + i);
    }

    private static void stringToHashMap(String string, Map<String, String> tempMap) {
     Arrays.asList(string.split(";")).stream().
             map(next -> next.split(":")).
             collect(Collectors.toMap(
                     a -> a[0],
                     a -> a.length > 1 ? a[1] : ""
             )).
             forEach((a, b) -> tempMap.put(a, b));
    }

    private static int getAnimalsCountInMap() {
        int eachAnimalLinesCountInProp = 3;
        return map != null && map.size() > 0 ? map.size() / eachAnimalLinesCountInProp : 0;
    }

}
