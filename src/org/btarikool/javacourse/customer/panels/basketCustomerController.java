package org.btarikool.javacourse.customer.panels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.btarikool.javacourse.*;
import org.btarikool.javacourse.Collections;
import org.btarikool.javacourse.Comparator;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.customer.Customer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class basketCustomerController implements Initializable {

    private Customer loggedInCustomer = PetShop.getInstance().getLoggedInCustomer();
    private Map<CheckBox, Animal> checkBoxAnimalMap = new HashMap<>();
    private double moneyLeft;
    @FXML
    private Label labelError;
    @FXML
    private Label labelMoneyLeft;
    @FXML
    private Label labelMoney;
    @FXML
    private Label labelCustomerName;
    @FXML
    private GridPane listGrid;

    @FXML
    private void logOut() throws IOException {
        loggedInCustomer.getBasket().getBasketList().clear();
        int indexOfCustomer = Collections.getInstance().getCustomersList().indexOf(loggedInCustomer);
        Collections.getInstance().getCustomersList().set(indexOfCustomer, loggedInCustomer);
        changeSceneToPetShopPanel();
        PetShop.getInstance().setLoggedInCustomer(null);
    }

    @FXML
    private void mainGridAutoFill() {
        loggedInCustomer.getBasket().getBasketList().stream().
                forEach(a -> {
                    Label label = new Label();
                    label.setText(a.toString() + "\n");
                    label.setId("nextLabel" + listGrid.impl_getRowCount());
                    label.setPadding(new Insets(0, 20, 0, 20));
                    CheckBox checkBox = new CheckBox();
                    checkBox.setId("checkBox" + listGrid.impl_getRowCount());
                    checkBox.setPadding(new Insets(0, 20, 10, 20));
                    checkBox.setAlignment(Pos.TOP_RIGHT);
                    checkBox.setOnAction(event -> onCheckBoxAction(a, checkBox));
                    checkBoxAnimalMap.put(checkBox, a);
                    listGrid.addRow(listGrid.impl_getRowCount(), new Label());
                    listGrid.add(label, 1, listGrid.impl_getRowCount() - 1);
                    listGrid.add(checkBox, 0, listGrid.impl_getRowCount() - 1);
                        }
                );
    }

    @FXML
    private void onButtonBuyAction() {
        List<Animal> selectedAnimalList = checkBoxAnimalMap.entrySet().stream().
                filter(e -> e.getKey().isSelected()).
                map(e -> e.getValue()).
                collect(Collectors.toList());

        if (checkSelectedAnimals(selectedAnimalList)) return;

        for (Animal selected : selectedAnimalList) {
            if (Comparator.getInstance().checkAnimalsCompatibility(loggedInCustomer, selected)) {
                labelError.setText("Selected animal : " + selected.getSpecies().name() + " " + selected.getNick() + " not compatible with already purchased ones");
                return;
            }
        }



        checkMoneyEnough(selectedAnimalList);
    }

    private void checkMoneyEnough(List<Animal> selectedAnimalList) {
        if (moneyLeft >= 0) {
            selectedAnimalList.stream().
                    forEach(animal -> {
                        loggedInCustomer.getPurchasedList().add(animal);
                        loggedInCustomer.getBasket().getBasketList().remove(animal);
                        loggedInCustomer.getBudget().setAmount(loggedInCustomer.getBudget().getAmount() - animal.getPrice().getPrice());
                        Collections.getInstance().getAnimalsList().remove(animal);
        });
            checkBoxAnimalMap.clear();
            listGrid.getChildren().clear();
            mainGridAutoFill();
        }
        else labelError.setText("Not enough money!");
    }

    private boolean checkSelectedAnimals(List<Animal> selectedAnimalList) {
        for (Animal a : selectedAnimalList) {
             List<Animal> filteredAnimals = selectedAnimalList.stream().
                    filter(animal -> !a.equals(animal)).collect(Collectors.toList());
             for (Animal filtered : filteredAnimals) {
                 for (Allergen allergen : filtered.getAnimalSpecifications().getAllergens()) {
                     if (a.getAnimalSpecifications().getAllergens().contains(allergen)) {
                         labelError.setText(a.getSpecies().name() + " " + a.getNick() + " not compatible with " + filtered.getSpecies().name() + " " + filtered.getNick());
                         return true;
                     }
                 }
             }
        }
        return false;
    }

    private void onCheckBoxAction(Animal animal, CheckBox checkBox) {
        if (checkBox.isSelected()) {
            moneyLeft -= animal.getPrice().getPrice();
            labelMoneyLeft.setText(moneyLeft + " EUR");
            if (moneyLeft < 0) {
                labelMoneyLeft.setTextFill(Color.RED);
                labelMoney.setTextFill(Color.RED);
            }
        }
        else {
            labelMoneyLeft.setText(moneyLeft + animal.getPrice().getPrice() + " EUR");
            moneyLeft += animal.getPrice().getPrice();
            if (moneyLeft >= 0) {
                labelMoneyLeft.setTextFill(Color.BLACK);
                labelMoney.setTextFill(Color.BLACK);
            }
        }
    }

    @FXML
    private void changeSceneToBasketPanel() throws IOException {

    }

    @FXML
    private void changeSceneToAdminsPanel() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/admin/adminsPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1 / Admins Panel");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    @FXML
    private void changeSceneToPetShopPanel() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/petShopPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    @FXML
    private void changeSceneToLoggedInCustomerPanel() throws IOException {
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/customer/panels/loggedInCustomerPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1 / Customer's Panel");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }


    public void initialize(URL location, ResourceBundle resources) {
        labelCustomerName.setText(loggedInCustomer.getName());
        moneyLeft = Math.round(loggedInCustomer.
                getBudget().
                getCurrency().
                convertToEur(loggedInCustomer.getBudget().getAmount()) * 100.0) / 100.0;
        labelMoneyLeft.setText(moneyLeft + " EUR");
        mainGridAutoFill();
    }

}