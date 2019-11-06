package org.btarikool.javacourse;

<<<<<<< Updated upstream
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WebShop extends Application {
    public void start(Stage stage) {
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
        TextField nameInput = new TextField(""); // создаем поле ввода текста
        pane.add(nameInput, 1, 0); // добавляем его к области
        TextField ageInput = new TextField(""); // создаем поле ввода текста
        pane.add(ageInput, 1, 1); // добавляем его к области
        TextField budgetInput = new TextField(""); // создаем поле ввода текста
        pane.add(budgetInput, 1, 2); // добавляем его к области

        Button button = new Button("Отправить");// Кнопка подтверждения
        button.setPrefHeight(30);                    // высокая кнопка
        button.setOnAction(e -> {
/*
            String myText = titleInput.getCharacters().toString();
            System.out.println(myText);
*/
        });
        pane.add(button, 0, 3, 2, 1);     // позиция: столбец 2, строк

        Scene scene = new Scene(pane, 800, 600); // создаем эпизод с нашей областью
        stage.setScene(scene);              // добавляем его к сцене
        stage.setTitle("JavaFX Test");
        stage.show();                       // показываем сцену


    } // end start();

    public static void main(String[] args) {
        launch(args);  // Run this Application.
    }

=======
public class WebShop {
>>>>>>> Stashed changes
}
