package Educatum.AboutUNI.UNHAS;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JurusanUnhas {
    private Stage stage;

    public JurusanUnhas(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(50));

        Button jurusanButton = createButton("Back");
        jurusanButton.setStyle("-fx-text-fill: black;");
        jurusanButton.setId("unhasbuttonjur");
        jurusanButton.setOnAction(e -> {
            Unhas unhas = new Unhas(stage);
            unhas.show();
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/images/UnhasBackDesign.png"));

            BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        Background background = new Background(backgroundImg);
        gridPane.setBackground(background);

        TableView<JurusanData> jurusanTable = createJurusanTable();

        gridPane.add(jurusanButton, 0, 0);
        gridPane.add(jurusanTable, 0, 1);

        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setStyle("-fx-background-color: transparent;");
        button.setTextFill(Color.BLACK);
        return button;
    }

    private TableView<JurusanData> createJurusanTable() {
        TableView<JurusanData> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<JurusanData, String> jurusanColumn = new TableColumn<>("Jurusan");
        jurusanColumn.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        jurusanColumn.setPrefWidth(300);

        TableColumn<JurusanData, String> fakultasColumn = new TableColumn<>("Fakultas");
        fakultasColumn.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        fakultasColumn.setPrefWidth(400);

        table.getColumns().addAll(jurusanColumn, fakultasColumn);

        
        List<JurusanData> jurusanDataList = new ArrayList<>();
        jurusanDataList.add(new JurusanData("Jurusan Kesehatan Masyarakat", "Fakultas Kesehatan Masyarakat"));
        jurusanDataList.add(new JurusanData("Jurusan Gizi", "Fakultas Kesehatan Masyarakat"));
        jurusanDataList.add(new JurusanData("Jurusan Pendidikan Dokter", "Fakultas Kedokteran"));
        jurusanDataList.add(new JurusanData("Jurusan Kedokteran Hewan", "Fakultas Kedokteran"));
        jurusanDataList.add(new JurusanData("Jurusan Kebidanan", "Fakultas Kedokteran"));
        jurusanDataList.add(new JurusanData("Jurusan Psikologi", "Fakultas Kedokteran"));
        jurusanDataList.add(new JurusanData("Jurusan Pendidikan Dokter Gigi", "Fakultas Kedokteran Gigi"));
        jurusanDataList.add(new JurusanData("Jurusan Hukum Administrasi Negara", "Fakultas Hukum"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Hukum", "Fakultas Hukum"));      
        jurusanDataList.add(new JurusanData("Jurusan Perencanaan Wilayah Kota", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Kelautan", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Teknik", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Sipil", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Lingkungan", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Mesin", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Elekto", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Pertambangan", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Arsitektur", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Industri", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Teknik Perkapalan", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Teknik Metalurgi", "Fakultas Teknik"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Hubungan Internasional", "Fakultas Ilmu Sosial Dan Politik"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Komunikasi", "Fakultas Ilmu Sosial Dan Politik"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Politik", "Fakultas Ilmu Sosial Dan Politik"));
        jurusanDataList.add(new JurusanData("Jurusan Sosiologi", "Fakultas Ilmu Sosial Dan Politik"));
        jurusanDataList.add(new JurusanData("Jurusan Antropologi", "Fakultas Ilmu Sosial Dan Politik"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Administrasi", "Fakultas Ilmu Sosial Dan Politik"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Pemerintahan", "Fakultas Ilmu Sosial Dan Politik"));
        jurusanDataList.add(new JurusanData("Jurusan Sistem Informasi", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Biologi", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Geofisika", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Fisika", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Kimia", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Matematika", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Statistika", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Farmasi", "Fakultas Farmasi"));
        jurusanDataList.add(new JurusanData("Jurusan Aktuaria", "Fakultas Matematika dan Ilmu Pengetahuan ALam"));
        jurusanDataList.add(new JurusanData("Jurusan Sejarah", "Fakultas Ilmu Pengetahuan Budaya"));
        jurusanDataList.add(new JurusanData("Jurusan Arkeologi", "Fakultas Ilmu Pengetahuan Budaya"));
        jurusanDataList.add(new JurusanData("Jurusan Sastra Asing", "Fakultas Ilmu Pengetahuan Budaya"));
        jurusanDataList.add(new JurusanData("Jurusan Sastra Daerah", "Fakultas Ilmu Pengetahuan Budaya"));
        jurusanDataList.add(new JurusanData("Jurusan Sastra Inggris", "Fakultas Ilmu Pengetahuan Budaya"));
        jurusanDataList.add(new JurusanData("Jurusan Kehutanan", "Fakultas Kehutanan"));
        jurusanDataList.add(new JurusanData("Jurusan Peternakan", "Fakultas Peternakan"));
        jurusanDataList.add(new JurusanData("Jurusan Perikanan", "Fakultas Ilmu Kelautan dan Perikanan"));
        jurusanDataList.add(new JurusanData("Jurusan Kelautan", "Fakultas Ilmu Kelautan dan Perikanan"));
        jurusanDataList.add(new JurusanData("Jurusan Budidaya Perairan", "Fakultas Ilmu Kelautan dan Perikanan"));
        jurusanDataList.add(new JurusanData("Jurusan Manajemen Sumber Daya Perairan", "Fakultas Ilmu Kelautan dan Perikanan"));
        jurusanDataList.add(new JurusanData("Jurusan Ilmu Keperawatan", "Fakultas Keperawatan"));
        jurusanDataList.add(new JurusanData("Jurusan Fisioterapi", "Fakultas Keperatwatan"));
        table.getItems().addAll(jurusanDataList);

        return table;
    }

    public static class JurusanData {
        private String jurusan;
        private String fakultas;

        public JurusanData(String jurusan, String fakultas) {
            this.jurusan = jurusan;
            this.fakultas = fakultas;
        }

        public String getJurusan() {
            return jurusan;
        }

        public String getFakultas() {
            return fakultas;
        }
    }
}
