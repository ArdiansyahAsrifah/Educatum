package Educatum.Scene;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import Educatum.Utils.SelectorEval;

public class Rational extends Application {
    private Map<String, Integer> jurusanPendaftar;

    private Stage stage;
    

    public Rational(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void start(Stage primaryStage) {
        // Data pendaftar jurusan
        jurusanPendaftar = new HashMap<>();
        
        //UNIVERSITAS INDONESIA
        jurusanPendaftar.put("Universitas Indonesia - Sistem Informasi", 1544);
        jurusanPendaftar.put("Universitas Indonesia - Teknik Elektro", 417);
        jurusanPendaftar.put("Universitas Indonesia - Pendidikan Dokter", 2861);
        jurusanPendaftar.put("Universitas Indonesia - Pendidikan Dokter Gigi", 700);
        jurusanPendaftar.put("Universitas Indonesia - Ilmu Kesehatan Masyarakat", 846);
        jurusanPendaftar.put("Universitas Indonesia - Teknik Bioproses", 126);
        jurusanPendaftar.put("Universitas Indonesia - Ilmu Hukum", 2641);
        jurusanPendaftar.put("Universitas Indonesia - Ilmu Komunikasi", 1980);
        jurusanPendaftar.put("Universitas Indonesia - Akuntansi", 1570);
        jurusanPendaftar.put("Universitas Indonesia - Ilmu Hubungan Internasional", 1091);
        jurusanPendaftar.put("Universitas Indonesia - Ilmu Psikologi", 2651);


        //UNIVERSITAS HASANUDDIN
        jurusanPendaftar.put("Universitas Hasanuddin - Teknik Sipil", 1270);
        jurusanPendaftar.put("Universitas Hasanuddin - Ilmu Komputer", 961);
        jurusanPendaftar.put("Universitas Hasanuddin - Psikologi", 1412);
        jurusanPendaftar.put("Universitas Hasanuddin - Kedokteran", 3782);
        jurusanPendaftar.put("Universitas Hasanuddin - Pendidikan Dokter Gigi", 1709);
        jurusanPendaftar.put("Universitas Hasanuddin - Kedokteran Hewan", 474);
        jurusanPendaftar.put("Universitas Hasanuddin - Gizi", 990);
        jurusanPendaftar.put("Universitas Hasanuddin - Teknik Pertambangan", 1661);
        jurusanPendaftar.put("Universitas Hasanuddin - Arsitektur", 661);
        jurusanPendaftar.put("Universitas Hasanuddin - Manajemen", 1997);
        jurusanPendaftar.put("Universitas Hasanuddin - Akuntansi", 1070);
        jurusanPendaftar.put("Universitas Hasanuddin - Ilmu Pemerintahan", 489);
        jurusanPendaftar.put("Universitas Hasanuddin - Sastra Jepang", 163);


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        Label utbkLabel = new Label("Skor UTBK:");
        TextField utbkField = new TextField();

        Label universityLabel = new Label("Universitas:");
        ChoiceBox<String> universityChoiceBox = new ChoiceBox<>();
        universityChoiceBox.setItems(FXCollections.observableArrayList("Universitas Indonesia", "Universitas Hasanuddin"));

        Label majorLabel = new Label("Program Studi:");
        ChoiceBox<String> majorChoiceBox = new ChoiceBox<>();

        universityChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            majorChoiceBox.setItems(FXCollections.observableArrayList(getMajors(newValue)));
        });

        Button submitButton = new Button("Submit");
        Label resultLabel = new Label();

        submitButton.setOnAction(e -> {
            int utbkScore = Integer.parseInt(utbkField.getText());
            String university = universityChoiceBox.getValue();
            String major = majorChoiceBox.getValue();

            if (university != null && major != null) {
                SelectorEval evaluator = new SelectorEval(utbkScore, university, major, jurusanPendaftar);
                String result = evaluator.evaluate();
                resultLabel.setText(result);
        
                // Mendapatkan jumlah data pendaftar dan kuota yang diterima
                int pendaftar = jurusanPendaftar.getOrDefault(university + " - " + major, 0);
                int kuota = jurusanPendaftar.getOrDefault(university + " - " + major, 0);
        
                // Menampilkan informasi jumlah data pendaftar dan kuota yang diterima
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Informasi");
                alert.setHeaderText("Data Pendaftar dan Kuota");
                alert.setContentText("Jumlah Data Pendaftar: " + pendaftar + "\nKuota yang Diterima: " + kuota);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Pilihan Tidak Lengkap");
                alert.setContentText("Silakan pilih universitas dan jurusan terlebih dahulu.");
                alert.showAndWait();
            }
    
            
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/RationalDesign.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);


        Button raButton = new Button("Back");
        raButton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(primaryStage);
            featureScene.show();

            
        });

        gridPane.add(utbkLabel, 0, 0);
        gridPane.add(utbkField, 1, 0);
        gridPane.add(universityLabel, 0, 1);
        gridPane.add(universityChoiceBox, 1, 1);
        gridPane.add(majorLabel, 0, 2);
        gridPane.add(majorChoiceBox, 1, 2);
        gridPane.add(submitButton, 0, 3);
        gridPane.add(resultLabel, 1, 3);
        gridPane.add(raButton, 2, 3);

        Scene scene = new Scene(gridPane, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String[] getMajors(String university) {
        switch (university) {
            case "Universitas Indonesia":
                return new String[]{"Sistem Informasi", "Teknik Elektro", "Pendidikan Dokter", "Pendidikan Dokter Gigi", "Ilmu Kesehatan Masyarakat", "Teknik Bioproses", "Hukum", "Ilmu Komunikasi", "Akuntansi", "Ilmu Hubungan Internasional", "Ilmu Psikologi"};
            case "Universitas Hasanuddin":
                return new String[]{"Teknik Sipil", "Ilmu Komputer", "Psikologi", "Kedokteran", "Pendidikan Dokter Gigi", "Kedokteran Hewan", "Gizi", "Teknik Pertambangan", "Arsitektur", "Manajemen", "Akuntansi", "Ilmu Pemerintahan", "Sastra Jepang"};
            default:
                return new String[]{};
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
