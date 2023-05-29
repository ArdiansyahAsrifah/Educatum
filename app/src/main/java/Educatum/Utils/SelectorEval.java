package Educatum.Utils;

import java.util.Map;

public class SelectorEval {
    private int utbkScore;
    private String university;
    private String major;
    private Map<String, Integer> jurusanPendaftar;

    public SelectorEval(int utbkScore, String university, String major, Map<String, Integer> jurusanPendaftar) {
        this.utbkScore = utbkScore;
        this.university = university;
        this.major = major;
        this.jurusanPendaftar = jurusanPendaftar;
    }

    public String evaluate() {
        int kuota = jurusanPendaftar.getOrDefault(university + " - " + major, 0);
        if (utbkScore >= 600 && kuota > 0) {
            return "Anda berpeluang lolos!";
        } else {
            return "Anda perlu meningkatkan nilai UTBK \natau pilih jurusan lain.";
        }
    }
}
