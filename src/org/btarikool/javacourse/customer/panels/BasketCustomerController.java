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
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BasketCustomerController implements Initializable {

    private Customer loggedInCustomer = PetShop.getInstance().getLoggedInCustomer();
    private Map<CheckBox, Animal> checkBoxAnimalMap = new HashMap<>();
    private double moneyLeft;

    @FXML
    private Button buttonBack;
    @FXML
    private Button buttonBuy;
    @FXML
    private Button buttonRemove;
    @FXML
    private Label labelError;
    @FXML
    private Label labelTopText;
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

    private Label getLabel(Animal a) {
        Label label = new Label();
        label.setText(a.toString() + "\n");
        label.setId("nextLabel" + listGrid.impl_getRowCount());
        label.setPadding(new Insets(0, 20, 0, 20));
        return label;
    }

    @FXML
    private void removeFromBasket() {
        checkBoxAnimalMap.entrySet().stream().
                filter(e -> e.getKey().isSelected()).
                map(e -> e.getValue()).
                forEach(animal -> {
                    loggedInCustomer.getBasket().getBasketList().remove(animal);
                    mathRoundMoneyLeft(moneyLeft + animal.getPrice().getPrice());
                    labelMoneyLeft.setText(moneyLeft + " EUR");
                });
        checkBoxAnimalMap.clear();
        listGrid.getChildren().clear();
        mainGridAutoFill();
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
        buttonBuy.setDisable(true);
        buttonBuy.setOpacity(0);
        buttonRemove.setDisable(true);
        buttonRemove.setOpacity(0);
    }

    @FXML
    private void onButtonBuyAction() {
        List<Animal> selectedAnimalList = checkBoxAnimalMap.entrySet().stream().
                filter(e -> e.getKey().isSelected()).
                map(e -> e.getValue()).
                collect(Collectors.toList());
        if (checkSelectedAnimals(selectedAnimalList)) return;
        if (checkSelectedAnimalsAndBoughtAnimals(selectedAnimalList)) return;
        checkMoneyEnough(selectedAnimalList);
    }

    private boolean checkSelectedAnimalsAndBoughtAnimals(List<Animal> selectedAnimalList) {
        for (Animal selected : selectedAnimalList) {
            if (Comparator.getInstance().checkAnimalsCompatibility(loggedInCustomer, selected)) {
                labelError.setText("Selected animal : " +
                        selected.getSpecies().name() +
                        " " + selected.getNick() +
                        " not compatible with already purchased ones");
                return true;
            }
        }
        return false;
    }

    private void checkMoneyEnough(List<Animal> selectedAnimalList) {
        if (moneyLeft >= 0) {
            selectedAnimalList.stream().forEach(animal -> doActionsWithAnimalAfterBuing(animal));
            checkBoxAnimalMap.clear();
            listGrid.getChildren().clear();
            mainGridAutoFill();
        }
        else labelError.setText("Not enough money!");
    }

    private void doActionsWithAnimalAfterBuing(Animal animal) {
        loggedInCustomer.getPurchasedList().add(animal);
        loggedInCustomer.getBasket().getBasketList().remove(animal);
        loggedInCustomer.getBudget().setAmount(loggedInCustomer.getBudget().getAmount() - animal.getPrice().getPrice());
        Collections.getInstance().getAnimalsList().remove(animal);
    }

    private boolean checkSelectedAnimals(List<Animal> selectedAnimalList) {
        for (Animal a : selectedAnimalList) {
             List<Animal> filteredAnimals = selectedAnimalList.stream().
                    filter(animal -> !a.equals(animal)).collect(Collectors.toList());
            if (checkFilteredAnimals(a, filteredAnimals)) return true;
        }
        return false;
    }

    private boolean checkFilteredAnimals(Animal a, List<Animal> filteredAnimals) {
        for (Animal filtered : filteredAnimals) {
            for (Allergen allergen : filtered.getAnimalSpecifications().getAllergens()) {
                if (isNotFilteredAnimalsCompatible(a, filtered, allergen)) return true;
            }
        }
        return false;
    }

    private boolean isNotFilteredAnimalsCompatible(Animal a, Animal filtered, Allergen allergen) {
        if (a.getAnimalSpecifications().getAllergens().contains(allergen)) {
            labelError.setText(a.getSpecies().name() + " " + a.getNick() + " not compatible with " + filtered.getSpecies().name() + " " + filtered.getNick());
            return true;
        }
        return false;
    }

    private void onCheckBoxAction(Animal animal, CheckBox checkBox) {
        if (checkBox.isSelected()) {
            mathRoundMoneyLeft(moneyLeft - animal.getPrice().getPrice());
            labelMoneyLeft.setText(moneyLeft + " EUR");
            setLabelMoneyTextFill(moneyLeft < 0, Color.RED);
        }
        else {
            labelMoneyLeft.setText(moneyLeft + animal.getPrice().getPrice() + " EUR");
            mathRoundMoneyLeft(moneyLeft + animal.getPrice().getPrice());
            setLabelMoneyTextFill(moneyLeft >= 0, Color.BLACK);
        }
    }

    private void mathRoundMoneyLeft(double v) {
        moneyLeft = Math.round((v) * 100) / 100;
    }

    private void setLabelMoneyTextFill(boolean b, Color color) {
        if (b) {
            labelMoneyLeft.setTextFill(color);
            labelMoney.setTextFill(color);
        }
    }

    @FXML
    private void changeSceneToPetShopPanel() throws IOException {
        changeScene("petShopPane.fxml", PetShopController.PET_SHOP_VOL_1);
    }

    @FXML
    private void changeSceneToLoggedInCustomerPanel() throws IOException {
        changeScene("customer/panels/loggedInCustomerPane.fxml", PetShopController.PET_SHOP_VOL_1 + " / Customer's Panel");
    }

    @FXML
    private void changeSceneToBasketCustomerPanel() throws IOException {
        changeScene("customer/panels/basketCustomerPane.fxml", PetShopController.PET_SHOP_VOL_1 + " / Customer's Panel / Basket");
    }

    private void changeScene(String s, String s2) throws IOException {
        File ne = new File(PetShopController.PROPERTY.concat(PetShopController.PATH + s));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle(s2);
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