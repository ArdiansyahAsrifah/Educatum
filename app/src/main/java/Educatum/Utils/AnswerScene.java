package Educatum.Utils;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AnswerScene extends Application {
    private Stage stage;
    private String answerText;
    private String explanation;
    private Button nextButton;

    public AnswerScene(Stage stage, String answerText, String explanation) {
        this.stage = stage;
        this.answerText = answerText;
        this.explanation = explanation;
        this.nextButton = new Button("Lanjutkan");
        nextButton.setId("lanjutkanbutt");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Answer");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));

        Label answerLabel = new Label(answerText);
        answerLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label explanationLabel = new Label(explanation);

        vbox.getChildren().addAll(answerLabel, explanationLabel, nextButton);
        vbox.setMargin(nextButton, new Insets(20, 0, 0, 0));

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/03.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        vbox.setBackground(background);

        Scene scene = new Scene(vbox, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void show() {
        start(stage);
    }

    public void setNextAction(Runnable action) {
        nextButton.setOnAction(e -> action.run());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
