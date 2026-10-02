package com.mycompany.kostku.manajemenbimbel;

public class SiswaPrivate extends Siswa {
    private static final double TARIF_PER_SESI = 75000;
    private static final int MINGGU_PER_BULAN = 4;

    private String alamatBelajar;
    private int sesiPerMinggu;

    public SiswaPrivate(String nama, int umur, String mataPelajaran, Mentor mentor,
                        String hari, double jamMulai, String alamatBelajar, int sesiPerMinggu) {
        super(nama, umur, mataPelajaran, mentor, hari, jamMulai);
        this.setAlamatBelajar(alamatBelajar);
        this.setSesiPerMinggu(sesiPerMinggu);
    }

    public static boolean isSesiValid(int sesi) {
        return sesi >= 1 && sesi <= 5;
    }

    public String getAlamatBelajar() {
        return this.alamatBelajar;
    }

    public void setAlamatBelajar(String alamatBelajar) {
        if (isTeksValid(alamatBelajar)) {
            this.alamatBelajar = alamatBelajar.trim();
        } else {
            System.out.println("[!] Alamat belajar tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public int getSesiPerMinggu() {
        return this.sesiPerMinggu;
    }

    public void setSesiPerMinggu(int sesiPerMinggu) {
        if (isSesiValid(sesiPerMinggu)) {
            this.sesiPerMinggu = sesiPerMinggu;
        } else {
            System.out.println("[!] Sesi per minggu harus 1 - 5. Nilai tidak diubah.");
        }
    }

    @Override
    public String getTipe() {
        return "Private";
    }

    @Override
    public double hitungBiaya() {
        return super.hitungBiaya() + (this.sesiPerMinggu * MINGGU_PER_BULAN * TARIF_PER_SESI);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" %-15s: %s%n", "Alamat Belajar", this.alamatBelajar);
        System.out.printf(" %-15s: %d sesi%n", "Sesi / Minggu", this.sesiPerMinggu);
    }
}