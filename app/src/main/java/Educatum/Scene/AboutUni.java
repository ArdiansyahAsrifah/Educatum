package Educatum.Scene;

import Educatum.AboutUNI.UI.Ui;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        
        uiButton.setStyle("-fx-font-weight: bold");
        uiButton.setOnAction(e -> {
            // uiButton.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null))); // Ubah latar belakang tombol saat diklik
            Ui ui = new Ui(stage);
            ui.show();
        });

        Button unhasButton = createButton("Universitas Hasanuddin");
    
        unhasButton.setStyle("-fx-font-weight: bold");
        unhasButton.setOnAction(e -> {
            // unhasButton.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null))); // Ubah latar belakang tombol saat diklik
        });

        Button backButton = createButton("Back");
        backButton.setFont(Font.font(14));
        backButton.setStyle("-fx-text-fill: green");
        backButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(stage);
            featureScene.show();
        });

        Button homeButton = createButton("Home");
        homeButton.setFont(Font.font(14));
        homeButton.setStyle("-fx-text-fill: green");
        homeButton.setOnAction(e -> {
            Home home = new Home(stage);
            home.show();
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/AboutUniDesign.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        gridPane.add(uiButton, 0, 1);
        gridPane.add(unhasButton, 2, 1);
        gridPane.add(backButton, 0, 4);
        gridPane.add(homeButton, 0, 5);

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
