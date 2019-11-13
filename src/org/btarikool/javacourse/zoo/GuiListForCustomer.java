package org.btarikool.javacourse.zoo;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.btarikool.javacourse.zoo.animal.types.Allergic;

import java.util.ArrayList;
import java.util.List;

public class GuiListForCustomer {
    private static List<RadioButton> rbList = new ArrayList<>();
    private static Label labelResponse = new Label();

    public static Scene nextScene() {
        int i = 1;
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(25);
        pane.setVgap(15);
        Label listOfAnimals = new Label("List of available animals:");
        pane.add(listOfAnimals, 0, 0, 3, 1);
        Scene scene = new Scene(pane, 750, 480);
        ToggleGroup tg = new ToggleGroup();

        if (listOfSuitableAnimals().isEmpty()) {
            Label noAnimals = new Label("Sorry, there is no suitable animals for you at the moment");
            pane.add(noAnimals, 0, 1, 3, 1);
            Button button2 = new Button("Exit");
            button2.setPrefWidth(100);
            GridPane.setHalignment(button2, HPos.RIGHT);
            pane.add(button2, 3, 2);
            button2.setOnAction(c ->{
                Platform.exit();
                System.exit(0);
            });
        } else {
            for (Animal animal : listOfSuitableAnimals()) {
                Label animal1 = new Label(animal.toString());
                pane.add(animal1, 0, i, 3, 1);
                RadioButton button = new RadioButton();
                button.setAccessibleHelp(animal.getNick());
                rbList.add(button);
                pane.add(button, 4, i);
                button.setToggleGroup(tg);
                i++;
            }

            labelResponse.setTextFill(Color.web("#ff0000"));
            pane.add(labelResponse, 0, i, 3, 1);
            Button button1 = new Button("Buy");
            button1.setPrefWidth(100);
            GridPane.setHalignment(button1, HPos.RIGHT);
            pane.add(button1, 3, listOfSuitableAnimals().size() + 1);
            button1.setOnAction(e -> {

                getBudget().setAmount(getBudget().getAmount() -
                        getPrice());
                labelResponse.setText("Successfully purchased! Your budget now is: " + getBudget());
               pane.getChildren().remove(button1);

                Button button2 = new Button("Exit");
                button2.setPrefWidth(100);
                GridPane.setHalignment(button2, HPos.RIGHT);
                pane.add(button2, 3, listOfSuitableAnimals().size() + 1);
                button2.setOnAction(c ->{
                    Platform.exit();
                    System.exit(0);
                });
            });

        }
        return scene;
    }

    public static List<Animal> listOfSuitableAnimals() {
        List<Animal> list = new ArrayList<>();
        for (Animal animal : Animal.getListOfAnimals()) {
            if (animal instanceof Allergic) {
                if (checkAllergies(animal) && animal.getPrice() < getBudget().getAmount()) {
                    list.add(animal);
                }
            } else if (animal.getPrice() < getBudget().getAmount()) {
                list.add(animal);
            }
        }
        return list;
    }


    public static boolean checkAllergies(Animal animal) {
        for (String str : Customer.getListOfCustomers().get(0).getAllergy()) {
            if (((Allergic) animal).getAllergyName().equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static double getPrice() {


        for (Animal animal : Animal.getListOfAnimals()) {
            if (animal.getNick().equals(nameOfAnimal())) {
                return animal.getPrice();
            }
        }
        return 0;
    }


    public static String nameOfAnimal() {
        for (RadioButton cb : rbList) {
            if (cb.isSelected()) {
                return cb.getAccessibleHelp();
            }
        }
        return null;
    }

    public static Customer.Budget getBudget(){
        return Customer.getListOfCustomers().get(0).getBudget();
    }
}