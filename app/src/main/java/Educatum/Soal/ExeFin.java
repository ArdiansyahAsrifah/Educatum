package Educatum.Soal;

import Educatum.Scene.FeatureScene;
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

public class ExeFin {
    //Deklarasikan stage dengan menerapkan encapsulation
    private Stage stage;

    //Bentuk contructor dari Stage
    public ExeFin(Stage stage) {
        this.stage = stage;
    }

    //Deklarasikan method show
    public void show() {
        //Mengatur Text Educatum dan settingan ukuran font, id agar lebih mudah css, dan posisi
        Text educatumText = new Text("Anda Telah Selesai");
        educatumText.setFont(Font.font(18));
        educatumText.setId("educatum-text");
        educatumText.setTextAlignment(TextAlignment.CENTER);

        

        //Menambahkan button Start dan apabila di melanjutkan ke feature scene, menentukan backroundnya agar transparan dan set Id
        Button startButton = new Button("  Kembali");
        startButton.setId("tombol-kembali");
        startButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(stage);
            featureScene.show();
        });
        
        //Menerapkan padding di button start
        startButton.setPadding(new Insets(20, 35, 20, 20));

        //Insert image sebagai backround
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/RationalDesign.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);

        //Mengatur tata lokasi dalam scene home
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));
        gridPane.setBackground(background);

        //Mengatur text dan button (column, row, colspan, rowspan)
        gridPane.add(educatumText, 0, 0, 2, 1);  
        gridPane.add(startButton, 0, 2, 2, 1); 

        //Deklarasikan scene
        Scene scene = new Scene(gridPane, 640, 480);
       
        //Import css yang sudah di buat di class styles.css
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
