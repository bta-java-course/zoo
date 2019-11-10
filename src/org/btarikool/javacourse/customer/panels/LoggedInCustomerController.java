package org.btarikool.javacourse.customer.panels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.btarikool.javacourse.*;
import org.btarikool.javacourse.animal.Animal;
import org.btarikool.javacourse.customer.Customer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LoggedInCustomerController implements Initializable {

    private Customer loggedInCustomer = PetShop.getInstance().getLoggedInCustomer();
    private Map<CheckBox, Animal> checkBoxAnimalMap = new HashMap<>();
    private double moneyLeft;
    @FXML
    private Label labelError;
    @FXML
    private Label labelTopText;
    @FXML
    private Button buttonAddToBasket;
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
    private void mainGridAutoFill() {
        Collections.getInstance().getAnimalsList().stream().
                filter(animal -> Comparator.getInstance().checkCompatibilityAnimalCustomer(loggedInCustomer, animal)).
                filter(a -> !loggedInCustomer.getBasket().getBasketList().contains(a)).
                forEach(a -> {
                    Label label = getLabel(a);
                    CheckBox checkBox = getCheckBox(a);
                    checkBoxAnimalMap.put(checkBox, a);
                    listGrid.addRow(listGrid.impl_getRowCount(), new Label());
                    listGrid.add(label, 1, listGrid.impl_getRowCount() - 1);
                    listGrid.add(checkBox, 0, listGrid.impl_getRowCount() - 1);
                        }
                );
    }

    private CheckBox getCheckBox(Animal a) {
        CheckBox checkBox = new CheckBox();
        checkBox.setId("checkBox" + listGrid.impl_getRowCount());
        checkBox.setPadding(new Insets(0, 20, 10, 20));
        checkBox.setAlignment(Pos.TOP_RIGHT);
        checkBox.setOnAction(event -> onCheckBoxAction(a, checkBox));
        return checkBox;
    }

    @FXML
    private void showPurchaseHistory() {
        listGrid.getChildren().clear();
        loggedInCustomer.getPurchasedList().stream().
                forEach(animal -> {
                            Label label = getLabel(animal);
                            listGrid.addRow(listGrid.impl_getRowCount(), new Label());
                            listGrid.add(label, 1, listGrid.impl_getRowCount() - 1);
                        }
                );
        labelTopText.setText("History:");
        labelError.setText("");
        buttonAddToBasket.setDisable(true);
        buttonAddToBasket.setOpacity(0);
    }

    private Label getLabel(Animal a) {
        Label label = new Label();
        label.setText(a.toString() + "\n");
        label.setId("nextLabel" + listGrid.impl_getRowCount());
        label.setPadding(new Insets(0, 20, 0, 20));
        return label;
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
            moneyLeft = Math.round((moneyLeft - animal.getPrice().getPrice()) * 100) / 100;
            labelMoneyLeft.setText(moneyLeft + " EUR");
            if (moneyLeft < 0) {
                labelMoneyLeft.setTextFill(Color.RED);
                labelMoney.setTextFill(Color.RED);
            }
        }
        else {
            labelMoneyLeft.setText(moneyLeft + animal.getPrice().getPrice() + " EUR");
            moneyLeft = Math.round((moneyLeft + animal.getPrice().getPrice()) * 100) / 100;
            if (moneyLeft >= 0) {
                labelMoneyLeft.setTextFill(Color.BLACK);
                labelMoney.setTextFill(Color.BLACK);
            }
        }
    }

    @FXML
    private void changeSceneToBasketPanel() throws IOException {
        changeScene("customer/panels/basketCustomerPane.fxml", PetShopController.PET_SHOP_VOL_1 + " / Customer's Panel / Basket");
    }

    @FXML
    private void changeSceneToPetShopPanel() throws IOException {
        changeScene("petShopPane.fxml", PetShopController.PET_SHOP_VOL_1);
    }

    @FXML
    private void changeSceneToLoggedInCustomerPanel() throws IOException {
        changeScene("customer/panels/loggedInCustomerPane.fxml", PetShopController.PET_SHOP_VOL_1 + " / Customer's Panel");
    }

    private void changeScene(String s, String petShopVol1) throws IOException {
        File ne = new File(PetShopController.PROPERTY.concat(PetShopController.PATH + s));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle(petShopVol1);
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