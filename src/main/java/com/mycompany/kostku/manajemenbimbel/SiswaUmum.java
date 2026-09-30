package com.mycompany.kostku.manajemenbimbel;

public class SiswaUmum extends Siswa {
    private static final double BIAYA_LAB = 50000;

    private String ruangLab;
    private String level;

    public SiswaUmum(String nama, int umur, String mataPelajaran, Mentor mentor,
                     String hari, int jamMulai, String ruangLab, String level) {
        super(nama, umur, mataPelajaran, mentor, hari, jamMulai);
        this.setRuangLab(ruangLab);
        this.setLevel(level);
    }

    public static boolean isLevelValid(String level) {
        return "Pemula".equals(level) || "Menengah".equals(level) || "Mahir".equals(level);
    }

    public String getRuangLab() {
        return this.ruangLab;
    }

    public void setRuangLab(String ruangLab) {
        if (isTeksValid(ruangLab)) {
            this.ruangLab = ruangLab.trim();
        } else {
            System.out.println("[!] Ruang lab tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        if (isLevelValid(level)) {
            this.level = level;
        } else {
            System.out.println("[!] Level harus Pemula / Menengah / Mahir. Nilai tidak diubah.");
        }
    }

    @Override
    public String getTipe() {
        return "Umum";
    }

    @Override
    public double hitungBiaya() {
        return super.hitungBiaya() + BIAYA_LAB;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" %-15s: %s%n", "Ruang Lab", this.ruangLab);
        System.out.printf(" %-15s: %s%n", "Level Kelas", this.level);
    }
}