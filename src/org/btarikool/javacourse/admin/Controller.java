package org.btarikool.javacourse.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import org.btarikool.javacourse.Logger;
import org.btarikool.javacourse.PetShop;
import org.btarikool.javacourse.genus.Genus;
import org.btarikool.javacourse.genus.species.Species;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable

{

    @FXML
    public Button totalCost;
    public Label mainText;

    @FXML
    public void saveLog() {
        new Logger().saveLogWithPathChooser(mainText.getText());
        //new Logger().logString(mainText.getText());
    }
    public void getTotalCost() {
        mainText.setText(String.valueOf(PetShop.getCollections().getAnimalsTotalCost()));
    }
    public void getAnimals() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsList()));
    }
    public void getSortedByName() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListSortedNick()));
    }
    public void getSortedByGenus() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListSortedGenus()));
    }
    public void getSortedBySpecies() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListSortedSpecies()));
    }
    public void getSortedByPriceHighFirst() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListSortedPriceHighestFirst()));
    }
    public void getSortedByPriceLowFirst() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListSortedPriceLowestFirst()));
    }
    public void getBony() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.BONY)));
    }
    public void getGoldy() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.GOLDY)));
    }
    public void getCat() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.CAT)));
    }
    public void getDog() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.DOG)));
    }
    public void getHorse() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.HORSE)));
    }
    public void getTurtle() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.TURTLE)));
    }
    public void getCrocodile() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.CROCODILE)));
    }
    public void getParrot() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.PARROT)));
    }
    public void getFrog() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredSpecies(Species.FROG)));
    }
    public void getAmphibian() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredGenus(Genus.AMPHIBIAN)));
    }
    public void getBird() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredGenus(Genus.BIRD)));
    }
    public void getFish() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredGenus(Genus.FISH)));
    }
    public void getMammal() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredGenus(Genus.MAMMAL)));
    }
    public void getReptile() {
        mainText.setText(new Logger().listToString(PetShop.getCollections().getAnimalsListFilteredGenus(Genus.REPTILE)));
    }


    public void initialize(URL location, ResourceBundle resources) {
    }

}