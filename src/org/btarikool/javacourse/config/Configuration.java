package org.btarikool.javacourse.config;


import com.sun.xml.internal.ws.util.StringUtils;
import org.btarikool.javacourse.Currency;
import org.btarikool.javacourse.animal.Allergenic;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.animal.Noisy;
import org.btarikool.javacourse.animal.genus.Genus;
import org.btarikool.javacourse.animal.genus.species.Species;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Configuration {

    private static Configuration instance = new Configuration();

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

    public static Configuration getInstance() {
        return instance;
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
        animal.setSex(tempMap.get("sex").equals("true") ? true : false);
        animal.setGenus(Genus.valueOf(tempMap.get("genus").toUpperCase()));
        animal.setSpecies(Species.valueOf(tempMap.get("species").toUpperCase()));
        animal.getPrice().setPrice(Double.parseDouble(tempMap.get("price")));
        animal.getPrice().setCurrency(Currency.EUR);
        animal.getAnimalSpecifications().setCityLivingAble(tempMap.get("cityLivingAble").equals("true") ? true : false);
        animal.getAnimalSpecifications().setSize(Double.parseDouble(tempMap.get("size")));
        animal.getAnimalSpecifications().setLivingYears(Integer.parseInt(tempMap.get("livingYears")));
        animal.getAnimalSpecifications().setPsychotype(tempMap.get("psychoType").toUpperCase());
        if (animal instanceof Allergenic) ((Allergenic) animal).makesAllergy();
        if (animal instanceof Noisy) ((Noisy) animal).makesNoise();
    }

    public void addAnimalToProp(String[] props) {
        try (RandomAccessFile ra = new RandomAccessFile(PROPPATH, "rw")){
            ra.seek(PROPPATH.length());
            String newProp = Arrays.asList(props).stream().collect(Collectors.joining("\n"));
            ra.write(newProp.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Animal getSpeciesClass(Map<String, String> tempMap) {
        Animal animal = null;
        try {
            Class clazz = Class.forName("org.btarikool.javacourse.animal.genus.species."
                    + StringUtils.capitalize(tempMap.get("species")));
            animal = (Animal) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return animal;
    }

    private Map<String, String> createNextAnimalMap() {
        int animalFromMap = getAnimalsCountInMap();
        Map<String, String> tempMap = new HashMap<>();
        stringToHashMap(getInfoString(animalFromMap), tempMap);
        return tempMap;
    }

    private String getInfoString(int i) {
        String info =  map.entrySet().stream().filter(a ->
                a.getKey().equals(BASICINFO + i) ||
                a.getKey().equals(SUBINFO + i)||
                a.getKey().equals(SPECIFICINFO + i)).
                map(a -> a.getValue()).
                collect(Collectors.joining(";"));
        removeInfoFromMap(i);
        return info;
    }

    private void removeInfoFromMap(int i) {
        map.remove(BASICINFO + i);
        map.remove(SUBINFO + i);
        map.remove(SPECIFICINFO + i);
    }

    private void stringToHashMap(String string, Map<String, String> tempMap) {
     Arrays.asList(string.split(";")).stream().
             map(next -> next.split(":")).
             collect(Collectors.toMap(
                     a -> a[0],
                     a -> a.length > 1 ? a[1] : ""
             )).
             forEach((a, b) -> tempMap.put(a, b));
    }

    private int getAnimalsCountInMap() {
        int eachAnimalLinesCountInProp = 3;
        return map != null && map.size() > 0 ? map.size() / eachAnimalLinesCountInProp : 0;
    }

}
