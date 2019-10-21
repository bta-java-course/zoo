package org.btarikool.javacourse;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Configuration {

    private static final File PROPPATH = new File(System.getProperty("user.dir").concat("\\conf\\petshop.propertie"));
    private static Properties prop = new Properties();
    private static Map<String, String> map = new HashMap<>();
    private Map<String, String> tempMap = new HashMap<>();
    static {
        try (FileInputStream input = new FileInputStream(PROPPATH)) {
            prop.load(input);
            prop.entrySet().stream().forEach(a -> map.put((String)a.getKey(), (String)a.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Configuration() {

    }

    /*public void getAnimal() {
        int animalsCountInMap = map.size()/3;
        while (!map.isEmpty()) {

        }

        Map<String, String> mapw = Splitter.on

    }*/

    public void getAnimalBasicInfo(int i) {
        String a = "aaa aaa";
        map.get("animal." + i);
        map.remove("animal." + i);
    }

    public void getAnimalSubInfo(int i) {
        map.get("animal." + i + ".subInfo");
        map.remove("animal." + i + ".subInfo");
    }

    public void getAnimalSpecifications(int i) {
        map.get("animal." + i + ".specifications");
        map.remove("animal." + i + ".specifications");
    }

    private void stringToHashMap(String string) {
     Arrays.asList(string.split(";")).
             stream().map(next -> next.split(":")).
             collect(Collectors.toMap(b -> b[0], b -> b == null ? "" : b[1])).
             forEach((a, b) -> tempMap.put(a, b));
    }

}
