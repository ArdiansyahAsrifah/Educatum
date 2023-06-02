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
    //Mendeklarasikan variabel sebagai objek map dimana juga ditentukan key nya sebagai value
    private Map<String, Integer> jurusanPendaftar;
    private Map<String, Integer> jurusanKuota;
    //mendeklarasikan stage
    private Stage stage;
    //membuat contruktor
    public Rational(Stage stage) {
        this.stage = stage;
    }
    //membuat method start yang berisi content
    @Override
    public void start(Stage primaryStage) {
        // Data pendaftar jurusan
        jurusanPendaftar = new HashMap<>();
        jurusanKuota = new HashMap<>();

        // UNIVERSITAS INDONESIA
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

        jurusanKuota.put("Universitas Indonesia - Sistem Informasi", 100);
        jurusanKuota.put("Universitas Indonesia - Teknik Elektro", 50);
        jurusanKuota.put("Universitas Indonesia - Pendidikan Dokter", 200);
        jurusanKuota.put("Universitas Indonesia - Pendidikan Dokter Gigi", 70);
        jurusanKuota.put("Universitas Indonesia - Ilmu Kesehatan Masyarakat", 80);
        jurusanKuota.put("Universitas Indonesia - Teknik Bioproses", 30);
        jurusanKuota.put("Universitas Indonesia - Ilmu Hukum", 150);
        jurusanKuota.put("Universitas Indonesia - Ilmu Komunikasi", 100);
        jurusanKuota.put("Universitas Indonesia - Akuntansi", 120);
        jurusanKuota.put("Universitas Indonesia - Ilmu Hubungan Internasional", 80);
        jurusanKuota.put("Universitas Indonesia - Ilmu Psikologi", 200);

        // UNIVERSITAS HASANUDDIN
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

        jurusanKuota.put("Universitas Hasanuddin - Teknik Sipil", 200);
        jurusanKuota.put("Universitas Hasanuddin - Ilmu Komputer", 150);
        jurusanKuota.put("Universitas Hasanuddin - Psikologi", 180);
        jurusanKuota.put("Universitas Hasanuddin - Kedokteran", 250);
        jurusanKuota.put("Universitas Hasanuddin - Pendidikan Dokter Gigi", 100);
        jurusanKuota.put("Universitas Hasanuddin - Kedokteran Hewan", 80);
        jurusanKuota.put("Universitas Hasanuddin - Gizi", 120);
        jurusanKuota.put("Universitas Hasanuddin - Teknik Pertambangan", 180);
        jurusanKuota.put("Universitas Hasanuddin - Arsitektur", 100);
        jurusanKuota.put("Universitas Hasanuddin - Manajemen", 180);
        jurusanKuota.put("Universitas Hasanuddin - Akuntansi", 120);
        jurusanKuota.put("Universitas Hasanuddin - Ilmu Pemerintahan", 100);
        jurusanKuota.put("Universitas Hasanuddin - Sastra Jepang", 50);

        //Membuat gridpane untuk tata letak
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        //Membuat textfield yang berupa skor utbk
        Label utbkLabel = new Label("Skor UTBK:");
        TextField utbkField = new TextField();

        //Membat choicebox yang berisi universitas yang tersedia
        Label universityLabel = new Label("Universitas:");
        ChoiceBox<String> universityChoiceBox = new ChoiceBox<>();
        universityChoiceBox.setItems(FXCollections.observableArrayList("Universitas Indonesia", "Universitas Hasanuddin"));

        //Membuat choicebox yang berisi program studi yang berdasarkan universitas yang dipilih
        Label majorLabel = new Label("Program Studi:");
        ChoiceBox<String> majorChoiceBox = new ChoiceBox<>();

        universityChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            majorChoiceBox.setItems(FXCollections.observableArrayList(getMajors(newValue)));
        });

        //Membuat tombol submit
        Button submitButton = new Button("Submit");
        submitButton.setId("submit-rat");
        //Set submit untuk melakukan beberapa action sekaligus
        submitButton.setOnAction(e -> {
            String selectedUniversity = universityChoiceBox.getValue();
            String selectedMajor = majorChoiceBox.getValue();
            int utbkScore = Integer.parseInt(utbkField.getText());
            //Pengkondisian apabila tidak mengisi textfield dan langsung menekan submit maka akan keluar output error
            if (selectedUniversity == null || selectedMajor == null || utbkField.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Harap lengkapi semua input");
                alert.showAndWait();
            //tampilkan hasil
            } else {
                SelectorEval selectorEval = new SelectorEval(utbkScore, selectedUniversity, selectedMajor);
                String result = selectorEval.evaluate();
            //hasilnya berupa jurusan dan apakah berpeluang atau tidak didukung oleh utils
            String message = "Hasil Evaluasi\n\n" +
            "Jurusan : " + selectedMajor + "\n\n" +
            result;

            //Menampilkan pop up message
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Hasil Evaluasi");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
            }
        });

        Button backbutton = new Button("Back");
        backbutton.setId("Back-rat");
        backbutton.setOnAction(e -> {
            FeatureScene featureScene = new FeatureScene(primaryStage);
            featureScene.show();
        });
        
        //Mengatur tata letak
        gridPane.add(utbkLabel, 0, 0);
        gridPane.add(utbkField, 1, 0);
        gridPane.add(universityLabel, 0, 1);
        gridPane.add(universityChoiceBox, 1, 1);
        gridPane.add(majorLabel, 0, 2);
        gridPane.add(majorChoiceBox, 1, 2);
        gridPane.add(submitButton, 0, 3);
        gridPane.add(backbutton, 0, 4);

        //Mengatur gambar jadi backround aplikasi
        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/RationalDesign.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        //Mendeklarasikan scene dan mengimport css
        Scene scene = new Scene(gridPane, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rational");
        primaryStage.show();
    }

    //menerapkan switchcase untuk jurusan setiap universitas
    private String[] getMajors(String university) {
        switch (university) {
            case "Universitas Indonesia":
                return jurusanPendaftar.keySet().stream().filter(jurusan -> jurusan.startsWith("Universitas Indonesia")).toArray(String[]::new);
            case "Universitas Hasanuddin":
                return jurusanPendaftar.keySet().stream().filter(jurusan -> jurusan.startsWith("Universitas Hasanuddin")).toArray(String[]::new);
            default:
                return new String[0];
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
