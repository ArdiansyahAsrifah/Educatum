package Educatum.Utils;

import java.util.Map;

public class SelectorEval {
    private int utbkScore;
    private String university;
    private String major;
    private Map<String, Integer> jurusanPendaftar;
    private Map<String, Integer> jurusanKuota;

    public SelectorEval(int utbkScore, String university, String major) {
        this.utbkScore = utbkScore;
        this.university = university;
        this.major = major;

    }

    public String evaluate() {
    

        if (utbkScore >= 600) {
            return "Anda berpeluang lolos!";
        } else {
            return "Anda perlu meningkatkan nilai UTBK atau pilih jurusan lain.";
        }
    }

}
