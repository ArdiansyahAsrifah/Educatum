package Educatum.Scene;

import Educatum.Utils.AnswerScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercises extends Application {
    private Stage stage;

    public Exercises(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        HBox contentBox = new HBox(100);
        contentBox.setAlignment(Pos.BOTTOM_CENTER);

        VBox questionBox = new VBox(10);
        questionBox.setAlignment(Pos.BOTTOM_CENTER);

        Label questionLabel = new Label("Jika, seandainya, apabila merupakan bagian dari ...");
        questionLabel.setFont(Font.font("Helvetica Bold", 16));
        RadioButton option1 = new RadioButton("Konjungsi Temporal");
        RadioButton option2 = new RadioButton("Verba Tingkah Laku");
        RadioButton option3 = new RadioButton("Verba Material");
        RadioButton option4 = new RadioButton("Konjungsi Syarat");

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
        Button backButton = new Button("Back");

        submitButton.setOnAction(e -> {
            RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedOption != null && selectedOption.getText().equals("Konjungsi Syarat")) {
                String explanation = "Konjungsi adalah kata hubung, konjungsi syarat menggunakan kata jika, seandainya, apabila.";
                AnswerScene answerScene = new AnswerScene(stage, "Jawaban Anda Benar", explanation);
                answerScene.setNextAction(() -> {
                    // Lanjut ke soal selanjutnya
                    
                });
                answerScene.show();
            } else {
                String explanation = "Konjungsi adalah kata hubung, konjungsi syarat menggunakan kata jika, seandainya, apabila.";
                AnswerScene answerScene = new AnswerScene(stage, "Jawaban Anda Salah", explanation);
                answerScene.setNextAction(() -> {
                    // Lanjut ke soal selanjutnya
                    
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
        Button number2Button = new Button("2");
        Button number3Button = new Button("3");
        Button number4Button = new Button("4");
        Button number5Button = new Button("5");

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
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show() {
        start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
