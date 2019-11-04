package org.btarikool.javacourse.customer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.btarikool.javacourse.*;
import org.btarikool.javacourse.animal.genus.Genus;
import org.btarikool.javacourse.animal.genus.species.Species;
import org.btarikool.javacourse.config.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class newCustomerController implements Initializable {

    private final static String WRONG_ANSWER = "FIELD %s: You entered something else, but not %s.";
    ObservableList<Currency> currencyList = FXCollections.observableArrayList(Currency.values());
    ObservableList<Noise.Feature> featureList = FXCollections.observableArrayList(Noise.Feature.values());
    private boolean rightInput = true;
    @FXML
    private Label labelError;
    @FXML
    private ChoiceBox choiceBoxCurrency;
    @FXML
    private ChoiceBox choiceBoxFeature;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldAge;
    @FXML
    private TextField fieldBudget;
    @FXML
    private TextField fieldNoiseLevel;
    @FXML
    private CheckBox checkBoxDandruff;
    @FXML
    private CheckBox checkBoxUrine;
    @FXML
    private CheckBox checkBoxSalvia;
    @FXML
    private CheckBox checkBoxUnexpected;
    @FXML
    private CheckBox checkBoxSharp;
    @FXML
    private CheckBox checkBoxMelodic;

    @FXML
    private void createCustomer() {

        Customer customer = new Customer();
        systemInName(customer);
        systemInBudget(customer);
        systemInAge(customer);
        systemInCurrency(customer);
        systemInAllergen(customer);
        systemInNoiseSensitivity(customer);
        if (rightInput) addCustomerWithCheck(customer);
        rightInput = true;
    }

    private void addCustomerWithCheck(Customer customer) {
        boolean duplicated= PetShop.getCollections().getCustomersList().stream().
                anyMatch(c ->
                        c.getName().equals(customer.getName()) &&
                                c.getSpecifications().getAge() == customer.getSpecifications().getAge());
        if (duplicated) {
            labelError.setText("Customer with such Name and Age already exists!");
            return;
        } else {
            PetShop.getCollections().getCustomersList().add(customer);
            labelError.setText("You are registered! Congrats!");
            new Logger().logCustomersList(PetShop.getCollections().getCustomersList());
        }
        PetShop.getCollections().getCustomersList().stream().forEach(System.out::println);
    }

    private void systemInName(Customer customer) {
        if (fieldName.getText().matches("\\s*")) {
            labelError.setText("FIELD NAME: Can not be empty!");
            rightInput = false;
            return;
        }
        customer.setName((fieldName.getText()));
    }

    private void systemInAge(Customer customer) {
        if (!fieldAge.getText().matches("\\d+")) {
            labelError.setText(String.format(WRONG_ANSWER, "AGE", "an integer"));
            rightInput = false;
            return;
        }
        else if (fieldAge.getText().matches("-\\d+|0")) {
            labelError.setText("FIELD AGE: Can not be minus value or 0!");
            rightInput = false;
            return;
        }
        else
            customer.getSpecifications().setAge(Integer.parseInt(fieldAge.getText()));
    }
    private double systemInNoiseLevel() {
        double level = -1;
        if (!fieldNoiseLevel.getText().matches("\\d+,?\\.?\\d*")) {
            labelError.setText(String.format(WRONG_ANSWER, "NOISE LEVEL", "a number"));
            rightInput = false;
        }
        else if (fieldNoiseLevel.getText().matches("-\\d+|0")) {
            labelError.setText("FIELD NOISE LEVEL: Can not be minus value or 0!");
            rightInput = false;
        }
        else
            level = (Double.parseDouble(fieldNoiseLevel.getText().replaceAll(",", ".")));

        return level;
    }

    private void systemInBudget(Customer customer) {
        if (!fieldBudget.getText().matches("\\d+,?\\.?\\d*")) {
            labelError.setText(String.format(WRONG_ANSWER, "BUDGET", "a number"));
            rightInput = false;
            return;
        }
        else if (fieldBudget.getText().matches("-\\d+|0")) {
            labelError.setText("FIELD BUDGET: Can not be minus value or 0!");
            rightInput = false;
            return;
        }
        else
            customer.getBudget().setAmount((Double.parseDouble(fieldBudget.getText().replaceAll(",", "."))));
    }

    private void systemInCurrency(Customer customer) {
        customer.getBudget().setCurrency((Currency)choiceBoxCurrency.getValue());
    }

    private void systemInAllergen(Customer customer) {
        if (checkBoxDandruff.isSelected()) customer.getSpecifications().setAllergens(Allergen.DANDRUFF);
        if (checkBoxSalvia.isSelected()) customer.getSpecifications().setAllergens(Allergen.SALVIA);
        if (checkBoxUrine.isSelected()) customer.getSpecifications().setAllergens(Allergen.URINE);
    }

    private void systemInNoiseSensitivity(Customer customer) {
        double level = systemInNoiseLevel();
        if (level != -1)
            customer.getSpecifications().setNoise(level, (Noise.Feature)choiceBoxFeature.getValue());
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


    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxCurrency.setValue(Currency.EUR);
        choiceBoxCurrency.setItems(currencyList);
        choiceBoxFeature.setValue(Noise.Feature.MELODIC);
        choiceBoxFeature.setItems(featureList);
    }

}