package Educatum.Scene;

import Educatum.AboutUNI.UI.Ui;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AboutUni {
    private Stage stage;

    public AboutUni(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        Button uiButton = createButton("Universitas Indonesia");
        uiButton.setOnAction(e -> {
            uiButton.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null))); // Ubah latar belakang tombol saat diklik
            Ui ui = new Ui(stage);
            ui.show();
        });

        Button ugmButton = createButton("Universitas Gadjah Mada");
        ugmButton.setOnAction(e -> {
            ugmButton.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null))); // Ubah latar belakang tombol saat diklik
        });

        Button unhasButton = createButton("Universitas Hasanuddin");
        unhasButton.setOnAction(e -> {
            unhasButton.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null))); // Ubah latar belakang tombol saat diklik
        });

        Button backButton = createButton("Back");
        backButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(stage);
            featureScene.show();
        });

        Button homeButton = createButton("Home");
        homeButton.setOnAction(e -> {
            Home home = new Home(stage);
            home.show();
        });

        gridPane.add(uiButton, 0, 0);
        gridPane.add(ugmButton, 1, 0);
        gridPane.add(unhasButton, 2, 0);
        gridPane.add(backButton, 0, 1);
        gridPane.add(homeButton, 1, 1);

        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setStyle("-fx-background-color: transparent;");
        button.setTextFill(Color.BLACK); // Ubah warna teks tombol
        button.setOnAction(e -> {
            // Aksi lain yang ingin lakukan saat tombol diklik
        });
        return button;
    }
}
