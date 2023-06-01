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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FeatureScene {

    //Encapsulation stage
    private Stage stage;

    //Buat construction
    public FeatureScene(Stage stage) {
        this.stage = stage;
    }

    //Deklarasikan method show()
    public void show() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT); // Mengubah posisi grid ke kiri
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        //Membuat button about uni dan men set warna textnya, id, dan apabila di klik akan berpindah scene ke aboutUniscene
        Button aboutUniButton = createTransparentButton("About Uni");
        aboutUniButton.setStyle("-fx-text-fill: white;");
        aboutUniButton.setId("aboutUni-button");
        aboutUniButton.setOnAction(e -> {
            // Logika untuk tombol "About Uni"
            AboutUni aboutUni = new AboutUni(stage);
            aboutUni.show();
        });

        //Membuat button rational dan men set warna textnya, id, dan apabila di klik akan berpindah scene ke aboutUniscene
        Button learningButton = createTransparentButton("Rasionalisasi");
        learningButton.setStyle("-fx-text-fill: white;");
        learningButton.setId("learning-button");
        learningButton.setOnAction(e -> {
            // Logika untuk tombol "rational"
            Rational rational = new Rational(stage);
            rational.start(stage);
        });

        //Membuat button exercises dan men set warna textnya, id, dan apabila di klik akan berpindah scene ke aboutUniscene
        Button exercisesButton = createTransparentButton("Exercises");
        exercisesButton.setStyle("-fx-text-fill: white;");
        exercisesButton.setId("exercises-button");
        exercisesButton.setOnAction(e -> {
            // Logika untuk tombol "Exercises"
            Exercises exercises = new Exercises(stage);
            exercises.start(stage);
        });

        //Membuat button back dan men set warna textnya, id, dan apabila di klik akan berpindah scene ke aboutUniscene
        Button backButton = createTransparentButton("Back");
        backButton.setStyle("-fx-text-fill: black;");
        backButton.setId("back-button");
        backButton.setOnAction(e -> {
            Home home = new Home(stage);
            home.show();
        });

        //Menambahkan image sebagai backround
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/MenuDesign.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        //Mengatur tata letak buttonnya
        gridPane.add(aboutUniButton, 0, 0);
        gridPane.add(learningButton, 0, 1);
        gridPane.add(exercisesButton, 0, 2);
        gridPane.add(backButton, 0, 3);

        //Deklarasikan scene dan import css
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
