package org.btarikool.javacourse.customer.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.btarikool.javacourse.*;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.config.Logger;
import org.btarikool.javacourse.customer.Customer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class loggedInCustomerController implements Initializable {

    private final static String WRONG_ANSWER = "FIELD %s: You entered something else, but not %s.";
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
        changeSceneToPetShopPanel();
        PetShop.getInstance().setLoggedInCustomer(null);
    }

    @FXML
    private void addToBasket() throws IOException {

        changeSceneToLoggedInCustomerPanel();
    }

    @FXML
    private void mainGridAutoFill() {
        Collections.getInstance().getAnimalsList().stream().
                filter(animal -> Comparator.getInstance().checkCompatibilityAnimalCustomer(loggedInCustomer, animal)).
                filter(a -> !loggedInCustomer.getBasket().getBasketList().contains(a)).
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
    private void addToBasketAction() {
        labelError.setText("");
        if (moneyLeft >= 0) {
            checkBoxAnimalMap.entrySet().stream().
                    filter((e -> e.getKey().isSelected())).
                    forEach(e -> loggedInCustomer.getBasket().getBasketList().add(e.getValue()));
            checkBoxAnimalMap.clear();
            listGrid.getChildren().clear();
            mainGridAutoFill();
        }
        else labelError.setText("Not enough money!");
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
        File ne = new File(System.getProperty("user.dir").concat("/src/org/btarikool/javacourse/customer/panels/basketCustomerPane.fxml"));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle("PetShop Vol.1 / Customer's Panel / Basket");
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
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