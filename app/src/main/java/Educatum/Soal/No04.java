package Educatum.Soal;

import javafx.stage.Stage;
import Educatum.Scene.Exercises;
import Educatum.Scene.FeatureScene;
import Educatum.Utils.AnswerScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class No04 {
    private Stage stage;

    public No04(Stage stage) {
        this.stage = stage;
    }

    public void start(){
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        HBox contentBox = new HBox(100);
        contentBox.setAlignment(Pos.BOTTOM_CENTER);

        VBox questionBox = new VBox(10);
        questionBox.setAlignment(Pos.BOTTOM_CENTER);

        Label questionLabel = new Label("Ilmu yang mempelajari virus disebut ...");
        questionLabel.setFont(Font.font("Helvetica Bold", 16));
        RadioButton option1 = new RadioButton("Sitologi");
        RadioButton option2 = new RadioButton("Mikologi");
        RadioButton option3 = new RadioButton("Virologi");
        RadioButton option4 = new RadioButton("Bakteriologi");

        ToggleGroup toggleGroup = new ToggleGroup();
        option1.setToggleGroup(toggleGroup);
        option2.setToggleGroup(toggleGroup);
        option3.setToggleGroup(toggleGroup);
        option4.setToggleGroup(toggleGroup);

        VBox optionsBox = new VBox(10, option1, option2, option3, option4);
        optionsBox.setAlignment(Pos.BOTTOM_LEFT);

        questionBox.getChildren().addAll(questionLabel, optionsBox);

        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        submitButton.setId("submit-exe");
        Button backButton = new Button("Back");
        backButton.setId("back-exe");


        submitButton.setOnAction(e -> {
            RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedOption != null && selectedOption.getText().equals("Virologi")) {
                String explanation = "Virologi ialah cabang biologi yang mempelajari makhluk suborganisme, terutama virus";
                AnswerScene answerScene = new AnswerScene(stage, "Jawaban Anda Benar", explanation);
                answerScene.setNextAction(() -> {
                    No05 no05 = new No05(stage);
                    no05.start();
                    
                });
                answerScene.show();
            } else {
                String explanation = "Virologi ialah cabang biologi yang mempelajari makhluk suborganisme, terutama virus";
                AnswerScene answerScene = new AnswerScene(stage, "Jawaban Anda Salah", explanation);
                answerScene.setNextAction(() -> {
                    No05 no05 = new No05(stage);
                    no05.start();
                });
                answerScene.show();
            }
        });

        backButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(stage);
            featureScene.show();
        });

        buttonBox.getChildren().addAll(submitButton, backButton);

        contentBox.getChildren().addAll(questionBox, buttonBox);

        // Tombol nomor soal di sebelah kiri
        HBox numberBox = new HBox(10);
        numberBox.setAlignment(Pos.TOP_LEFT);
        numberBox.setPadding(new Insets(0, 20, 0, 60));

        Button number1Button = new Button("1");
        number1Button.setId("no1");
        number1Button.setStyle("-fx-text-fill: white");
        number1Button.setOnAction(e -> {
            Exercises exercises = new Exercises(stage);
            exercises.show();
        });
        Button number2Button = new Button("2");
        number2Button.setId("no2");
        number2Button.setStyle("-fx-text-fill: white");
        number2Button.setOnAction(e -> {
            No02 no02 = new No02(stage);
            no02.start();
        });
        Button number3Button = new Button("3");
        number3Button.setId("no3");
        number3Button.setStyle("-fx-text-fill: white");
        number3Button.setOnAction(e -> {
            No03 no03 = new No03(stage);
            no03.start();
        });
        Button number4Button = new Button("4");
        number4Button.setId("no4");
        number4Button.setStyle("-fx-text-fill: yellow");
        number4Button.setOnAction(e -> {
            No04 no04 = new No04(stage);
            no04.start();
        });
        Button number5Button = new Button("5");
        number5Button.setId("no5");
        number5Button.setStyle("-fx-text-fill: white");
        number5Button.setOnAction(e -> {
            No05 no05 = new No05(stage);
            no05.start();
        });


        numberBox.getChildren().addAll(number1Button, number2Button, number3Button, number4Button, number5Button);

        root.getChildren().addAll(numberBox, contentBox);

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/04.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        root.setBackground(background);

        
        VBox.setMargin(questionBox, new Insets(0, 0, 50, 0));

        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

    private static void launch(String[] args) {
    }
}

    