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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class No02 {
    private Stage stage;

    public No02(Stage stage) {
        this.stage = stage;
    }

    public void start(){
        // Membuat VBox utama sebagai root
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        // Membuat HBox untuk konten
        HBox contentBox = new HBox(100);
        contentBox.setAlignment(Pos.BOTTOM_CENTER);

        // Membuat VBox untuk pertanyaan
        VBox questionBox = new VBox(10);
        questionBox.setAlignment(Pos.BOTTOM_CENTER);

        // Membuat label pertanyaan
        Label questionLabel = new Label("Paragraf yang bertujuan membujuk adalah ...");
        questionLabel.setFont(Font.font("Helvetica Bold", 16));

        // Membuat opsi jawaban dalam bentuk radio button
        RadioButton option1 = new RadioButton("Narasi");
        RadioButton option2 = new RadioButton("Eksposisi");
        RadioButton option3 = new RadioButton("Argumentasi");
        RadioButton option4 = new RadioButton("Persuasi");

        // Membuat grup untuk radio button
        ToggleGroup toggleGroup = new ToggleGroup();
        option1.setToggleGroup(toggleGroup);
        option2.setToggleGroup(toggleGroup);
        option3.setToggleGroup(toggleGroup);
        option4.setToggleGroup(toggleGroup);

        // Membuat VBox untuk opsi jawaban
        VBox optionsBox = new VBox(10, option1, option2, option3, option4);
        optionsBox.setAlignment(Pos.BOTTOM_LEFT);

        // Menambahkan label pertanyaan dan opsi jawaban ke dalam VBox pertanyaan
        questionBox.getChildren().addAll(questionLabel, optionsBox);

        // Membuat VBox untuk tombol submit dan back
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        // Membuat tombol submit
        Button submitButton = new Button("Submit");
        submitButton.setId("submit-exe");
        Button backButton = new Button("Back");
        backButton.setId("back-exe");

        // Menambahkan aksi saat tombol submit ditekan
        submitButton.setOnAction(e -> {
            RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedOption != null && selectedOption.getText().equals("Persuasi")) {
                String explanation = "Paragraf yang mempunyai tujuan untuk meyakinkan atau mengajak si pembaca dengan maksud tertentu.";
                AnswerScene answerScene = new AnswerScene(stage, "Jawaban Anda Benar", explanation);
                answerScene.setNextAction(() -> {
                    No03 no03 = new No03(stage);
                    no03.start();
                    
                });
                answerScene.show();
            } else {
                String explanation = "Paragraf yang mempunyai tujuan untuk meyakinkan atau mengajak si pembaca dengan maksud tertentu.";
                AnswerScene answerScene = new AnswerScene(stage, "Jawaban Anda Salah", explanation);
                answerScene.setNextAction(() -> {
                    No03 no03 = new No03(stage);
                    no03.start();
                });
                answerScene.show();
            }
        });

        // Menambahkan aksi saat tombol back ditekan
        backButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(stage);
            featureScene.show();
        });

        // Menambahkan tombol submit dan back ke dalam VBox tombol
        buttonBox.getChildren().addAll(submitButton, backButton);

        // Menambahkan VBox pertanyaan dan VBox tombol ke dalam HBox konten
        contentBox.getChildren().addAll(questionBox, buttonBox);

        // Membuat HBox untuk tombol nomor soal di sebelah kiri
        HBox numberBox = new HBox(10);
        numberBox.setAlignment(Pos.TOP_LEFT);
        numberBox.setPadding(new Insets(0, 20, 0, 60));

        // Membuat tombol nomor soal 1 sampai 5
        Button number1Button = new Button("1");
        number1Button.setId("no1");
        number1Button.setStyle("-fx-text-fill: white");
        number1Button.setOnAction(e -> {
            Exercises exercises = new Exercises(stage);
            exercises.show();
        });
        Button number2Button = new Button("2");
        number2Button.setId("no2");
        number2Button.setStyle("-fx-text-fill: yellow");
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
        number4Button.setStyle("-fx-text-fill: white");
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

        Button number6Button = new Button("6");
        number6Button.setId("no6");
        number6Button.setStyle("-fx-text-fill: white");
        number6Button.setOnAction(e -> {
            No06 no06 = new No06(stage);
            no06.start();
        });

        // Menambahkan tombol nomor soal ke dalam HBox
        numberBox.getChildren().addAll(number1Button, number2Button, number3Button, number4Button, number5Button, number6Button);

        // Menambahkan HBox nomor soal dan HBox konten ke dalam VBox utama
        root.getChildren().addAll(numberBox, contentBox);

        // Menambahkan gambar latar belakang ke dalam root VBox
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/04.png"));
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background background = new Background(backgroundImg);
        root.setBackground(background);

        // Mengatur margin untuk VBox pertanyaan
        VBox.setMargin(questionBox, new Insets(0, 0, 50, 0));

        // Membuat scene dan mengatur tampilan stage
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
