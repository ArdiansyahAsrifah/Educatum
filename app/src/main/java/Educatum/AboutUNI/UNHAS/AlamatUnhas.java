package Educatum.AboutUNI.UNHAS;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AlamatUnhas {
    private Stage stage;

    public AlamatUnhas(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        Label alamatLabel = new Label("Alamat Universitas Hasanuddin:");
        alamatLabel.setStyle("-fx-font-size: 16pt; -fx-font-weight: bold;");

        Label alamatText = new Label("Perintis Kemerdekaan, Kota Makassar, Indonesia");

        gridPane.add(alamatLabel, 0, 0);
        gridPane.add(alamatText, 0, 1);

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/UnhasHome.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Unhas unhas = new Unhas(stage);
            unhas.show();
        });
        gridPane.add(backButton, 3, 0);

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        Scene scene = new Scene(gridPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
