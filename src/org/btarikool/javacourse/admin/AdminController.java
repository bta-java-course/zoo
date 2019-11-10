package org.btarikool.javacourse.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.btarikool.javacourse.Collections;
import org.btarikool.javacourse.PetShopController;
import org.btarikool.javacourse.PetShopInterface;
import org.btarikool.javacourse.animal.genus.Genus;
import org.btarikool.javacourse.animal.genus.species.Species;
import org.btarikool.javacourse.config.Logger;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable

{

    @FXML
    private Label mainText;

    @FXML
    public void saveLog() {
        Logger.getInstance().saveLogWithPathChooser(mainText.getText(), "animals");
    }
    public void getTotalCost() {
        mainText.setText(String.valueOf(Collections.getInstance().getAnimalsTotalCost()));
    }
    public void getAnimals() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsList()));
    }
    public void getSortedByName() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListSortedNick()));
    }
    public void getSortedByGenus() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListSortedGenus()));
    }
    public void getSortedBySpecies() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListSortedSpecies()));
    }
    public void getSortedByPriceHighFirst() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListSortedPriceHighestFirst()));
    }
    public void getSortedByPriceLowFirst() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListSortedPriceLowestFirst()));
    }
    public void getBony() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.BONY)));
    }
    public void getGoldy() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.GOLDY)));
    }
    public void getCat() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.CAT)));
    }
    public void getDog() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.DOG)));
    }
    public void getHorse() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.HORSE)));
    }
    public void getTurtle() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.TURTLE)));
    }
    public void getCrocodile() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.CROCODILE)));
    }
    public void getParrot() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.PARROT)));
    }
    public void getFrog() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredSpecies(Species.FROG)));
    }
    public void getAmphibian() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredGenus(Genus.AMPHIBIAN)));
    }
    public void getBird() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredGenus(Genus.BIRD)));
    }
    public void getFish() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredGenus(Genus.FISH)));
    }
    public void getMammal() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredGenus(Genus.MAMMAL)));
    }
    public void getReptile() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getAnimalsListFilteredGenus(Genus.REPTILE)));
    }

    public void getCustomers() {
        mainText.setText(Logger.getInstance().listToString(Collections.getInstance().getCustomersList()));
    }

    @FXML
    private void changeSceneToNewCustomerPanel() throws IOException {
        changeScene("customer/panels/newCustomerPane.fxml", PetShopController.PET_SHOP_VOL_1 + " / New Customer");
    }
    @FXML
    private void changeSceneToPetShopPanel() throws IOException {
        changeScene("petShopPane.fxml", PetShopController.PET_SHOP_VOL_1);
    }

    private void changeScene(String s, String petShopVol1) throws IOException {
        File ne = new File(PetShopController.PROPERTY.concat(PetShopController.PATH + s));
        Pane myPane = FXMLLoader.load(ne.toURL());
        PetShopInterface.getMyStage().setTitle(petShopVol1);
        PetShopInterface.getMyStage().setScene(new Scene(myPane));
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

}