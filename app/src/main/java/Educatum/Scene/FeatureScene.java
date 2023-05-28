package Educatum.Scene;

// import Educatum.Scene.AboutUniScene;
// import Educatum.Scene.LearningScene;
// import Educatum.Scene.ExercisesScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FeatureScene {
    private Stage stage;

    public FeatureScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        Button aboutUniButton = createTransparentButton("About Uni");
        aboutUniButton.setOnAction(e -> {
            // AboutUniScene aboutUniScene = new AboutUniScene(stage);
            // aboutUniScene.show();
        });

        Button learningButton = createTransparentButton("Learning");
        learningButton.setOnAction(e -> {
            // LearningScene learningScene = new LearningScene(stage);
            // learningScene.show();
        });

        Button exercisesButton = createTransparentButton("Exercises");
        exercisesButton.setOnAction(e -> {
            // ExercisesScene exercisesScene = new ExercisesScene(stage);
            // exercisesScene.show();
        });

        Button backButton = createTransparentButton("Back");
        backButton.setOnAction(e -> {
            Home home = new Home(stage);
            home.show();
        });

        Button startButton = createTransparentButton("Start");
        startButton.setOnAction(e -> {
            // Logika untuk kembali ke scene Home saat tombol Start ditekan
            Home home = new Home(stage);
            home.show();
        });

        gridPane.add(aboutUniButton, 0, 0);
        gridPane.add(learningButton, 1, 0);
        gridPane.add(exercisesButton, 2, 0);
        gridPane.add(backButton, 0, 1);
        gridPane.add(startButton, 2, 1);

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

