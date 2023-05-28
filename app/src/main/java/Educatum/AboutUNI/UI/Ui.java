package Educatum.AboutUNI.UI;

import Educatum.Scene.AboutUni;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Ui {
    private Stage stage;

    public Ui(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_RIGHT); // Mengubah posisi grid ke kanan
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        Button aboutUniButton = createTransparentButton("Jurusan");
        aboutUniButton.setStyle("-fx-text-fill: purple;");
        aboutUniButton.setOnAction(e -> {
            // Logika untuk tombol "About Uni"
            
        });

        Button learningButton = createTransparentButton("Alamat");
        learningButton.setStyle("-fx-text-fill: purple;");
        learningButton.setOnAction(e -> {
            // Logika untuk tombol "Learning"
        });

        Button exercisesButton = createTransparentButton("Seleksi Masuk");
        exercisesButton.setStyle("-fx-text-fill: purple;");
        exercisesButton.setOnAction(e -> {
            // Logika untuk tombol "Exercises"
        });

        Button backButton = createTransparentButton("Back");
        backButton.setStyle("-fx-text-fill: purple");
        backButton.setOnAction(e -> {
            AboutUni aboutuni = new AboutUni(stage);
            aboutuni.show();
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/Feature.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        gridPane.add(aboutUniButton, 0, 0);
        gridPane.add(learningButton, 0, 1);
        gridPane.add(exercisesButton, 0, 2);
        gridPane.add(backButton, 0, 3);

        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private Button createTransparentButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setStyle("-fx-background-color: transparent;");
        button.setTextAlignment(TextAlignment.CENTER);
        button.setFont(Font.font(18));
        return button;
    }
} 
