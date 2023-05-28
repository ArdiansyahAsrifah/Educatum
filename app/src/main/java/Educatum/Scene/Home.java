package Educatum.Scene;

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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Home {
    private Stage stage;

    public Home(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Text educatumText = new Text("EDUCATUM");
        educatumText.setFont(Font.font(18));
        educatumText.setId("educatum-text");
        educatumText.setTextAlignment(TextAlignment.CENTER);

        Text welcomeText = new Text("Welcome User");
        welcomeText.setFont(Font.font(24));
        welcomeText.setId("welcome-text");
        welcomeText.setTextAlignment(TextAlignment.CENTER);

        Button startButton = new Button("START");
        startButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(stage);
            featureScene.show();
        });
        startButton.setStyle("-fx-background-color: transparent;");
        startButton.setId("start-button");
        
        startButton.setPadding(new Insets(20, 20, 20, 20));

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/Home.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));
        gridPane.setBackground(background);

        gridPane.add(educatumText, 0, 0, 2, 1); // educatumText di kolom 0 dan 1, baris 0
        gridPane.add(welcomeText, 0, 1, 2, 1); // welcomeText di kolom 0 dan 1, baris 1
        gridPane.add(startButton, 0, 2, 2, 1); // startButton di kolom 0 dan 1, baris 2

    

        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
