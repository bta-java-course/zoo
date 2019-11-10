package org.btarikool.javacourse;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class WebShop extends Application {
    public void start(Stage stage) {
        PetShop.initAnimals();
        GridPane pane = new GridPane();    // создаем область с абс.
        pane.setPadding(new Insets(20)); // устанавливаем
        pane.setHgap(25);                    // внешние горизонтальные
        pane.setVgap(15);                    // и вертикальные отступы

        Label nameLbl = new Label("Name:"); // надпись для поля ввода текста
        pane.add(nameLbl, 0, 0); // добавляем надпись к области
        Label ageLbl = new Label("Age:"); // надпись для поля ввода текста
        pane.add(ageLbl, 0, 1); // добавляем надпись к области
        Label budgetLbl = new Label("Budget:"); // надпись для поля ввода текста
        pane.add(budgetLbl, 0, 2); // добавляем надпись к области
        Label currencyLbl = new Label("Currency:"); // надпись для поля ввода текста
        pane.add(currencyLbl, 0, 3); // добавляем надпись к области
        TextField nameInput = new TextField(""); // создаем поле ввода текста
        pane.add(nameInput, 1, 0); // добавляем его к области
        TextField ageInput = new TextField(""); // создаем поле ввода текста
        pane.add(ageInput, 1, 1); // добавляем его к области
        TextField budgetInput = new TextField(""); // создаем поле ввода текста
        pane.add(budgetInput, 1, 2); // добавляем его к области
        ChoiceBox currencySelect = new ChoiceBox(FXCollections.observableArrayList(
                "","EUR", "USD", "RUB", "SEK"
        ));
        currencySelect.setValue("");
        pane.add(currencySelect, 1, 3);
        int rowIndex = 4;
        List<CheckBox> allergies = new ArrayList<>();
        for (Allergie allergie: Allergie.values()) {
            Label cbLbl = new Label(allergie.name()); // создаем поле ввода текста
            pane.add(cbLbl, 0, rowIndex); // добавляем его к области
            CheckBox cb = new CheckBox();
            cb.setAccessibleHelp(allergie.name());
            allergies.add(cb);
            pane.add(cb, 1, rowIndex++);
        }

        Button button = new Button("SEND");// Кнопка подтверждения
        button.setPrefHeight(30);
        // высокая кнопка
        Label messageLbl = new Label(""); // надпись для поля ввода текста

        button.setOnAction(e -> {
                List<String> allergiesList = new ArrayList<>();
                for (CheckBox cb: allergies) {
                    if (cb.isSelected()) {
                        allergiesList.add(cb.getAccessibleHelp());
                    }
                }
                String message = PetShop.createCustomer(nameInput.getText(),
                        ageInput.getText(),
                        budgetInput.getText(),
                        currencySelect.getValue().toString(),
                        allergiesList);
                messageLbl.setText(message);

        });
        pane.add(button, 0, rowIndex++, 2, 1);     // позиция: столбец 2, строк
        pane.add(messageLbl, 0, rowIndex, 4, 1); // добавляем надпись к области

        Scene scene = new Scene(pane, 800, 600); // создаем эпизод с нашей областью
        stage.setScene(scene);              // добавляем его к сцене
        stage.setTitle("JavaFX Test");
        stage.show();                       // показываем сцену


    } // end start();

    public static void main(String[] args) {
        launch(args);  // Run this Application.
    }

}
