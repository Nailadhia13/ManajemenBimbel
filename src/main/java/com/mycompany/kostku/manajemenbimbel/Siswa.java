package com.mycompany.kostku.manajemenbimbel;

import java.util.Locale;

public class Siswa {
    private static int totalSiswa = 0;

    private static final double BIAYA_DASAR = 200000;
    private static final int DURASI_DEFAULT = 90;
    private static final String[] DAFTAR_HARI =
            {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    private int id;
    private String nama;
    private int umur;
    private String mataPelajaran;
    private Mentor mentor;
    private String hari;
    private int jamMulai;
    private int durasiMenit;

    public Siswa(String nama, int umur, String mataPelajaran, Mentor mentor,
                 String hari, int jamMulai) {
        this(nama, umur, mataPelajaran, mentor, hari, jamMulai, DURASI_DEFAULT);
    }

    public Siswa(String nama, int umur, String mataPelajaran, Mentor mentor,
                 String hari, int jamMulai, int durasiMenit) {
        this.setNama(nama);
        this.setUmur(umur);
        this.setMataPelajaran(mataPelajaran);
        this.setMentor(mentor);
        this.aturJadwal(hari, jamMulai, durasiMenit);
        totalSiswa++;
        this.id = totalSiswa;
    }

    public static boolean isTeksValid(String teks) {
        return teks != null && !teks.trim().isEmpty();
    }

    public static boolean isUmurValid(int umur) {
        return umur >= 5 && umur <= 60;
    }

    public static boolean isHariValid(String hari) {
        for (int i = 0; i < DAFTAR_HARI.length; i++) {
            if (DAFTAR_HARI[i].equals(hari)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isJamValid(int jam) {
        return jam >= 8 && jam <= 20;
    }

    public static boolean isDurasiValid(int menit) {
        return menit >= 30 && menit <= 180;
    }

    public int getId() {
        return this.id;
    }

    public String getKode() {
        return String.format("S%03d", this.id);
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        if (isTeksValid(nama)) {
            this.nama = nama.trim();
        } else {
            System.out.println("[!] Nama siswa tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public int getUmur() {
        return this.umur;
    }

    public void setUmur(int umur) {
        if (isUmurValid(umur)) {
            this.umur = umur;
        } else {
            System.out.println("[!] Umur harus 5 - 60 tahun. Nilai tidak diubah.");
        }
    }

    public String getMataPelajaran() {
        return this.mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        if (isTeksValid(mataPelajaran)) {
            this.mataPelajaran = mataPelajaran.trim();
        } else {
            System.out.println("[!] Mata pelajaran tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public Mentor getMentor() {
        return this.mentor;
    }

    public void setMentor(Mentor mentor) {
        if (mentor != null) {
            this.mentor = mentor;
        } else {
            System.out.println("[!] Mentor tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public String getHari() {
        return this.hari;
    }

    public void setHari(String hari) {
        if (isHariValid(hari)) {
            this.hari = hari;
        } else {
            System.out.println("[!] Hari harus Senin - Sabtu. Nilai tidak diubah.");
        }
    }

    public int getJamMulai() {
        return this.jamMulai;
    }

    public void setJamMulai(int jamMulai) {
        if (isJamValid(jamMulai)) {
            this.jamMulai = jamMulai;
        } else {
            System.out.println("[!] Jam mulai harus 8 - 20. Nilai tidak diubah.");
        }
    }

    public int getDurasiMenit() {
        return this.durasiMenit;
    }

    public void setDurasiMenit(int durasiMenit) {
        if (isDurasiValid(durasiMenit)) {
            this.durasiMenit = durasiMenit;
        } else {
            System.out.println("[!] Durasi harus 30 - 180 menit. Nilai tidak diubah.");
        }
    }

    public static int getTotalSiswa() {
        return totalSiswa;
    }

    public void aturJadwal(String hari, int jamMulai) {
        this.setHari(hari);
        this.setJamMulai(jamMulai);
    }

    public void aturJadwal(String hari, int jamMulai, int durasiMenit) {
        this.aturJadwal(hari, jamMulai);
        this.setDurasiMenit(durasiMenit);
    }

    public double hitungBiaya() {
        return BIAYA_DASAR;
    }

    public double hitungBiaya(double diskonPersen) {
        if (diskonPersen < 0 || diskonPersen > 100) {
            System.out.println("[!] Diskon harus 0 - 100 persen. Diskon diabaikan.");
            return this.hitungBiaya();
        }
        return this.hitungBiaya() * (1 - diskonPersen / 100);
    }

    public String getTipe() {
        return "Siswa";
    }

    public String getJadwal() {
        int selesaiMenit = this.jamMulai * 60 + this.durasiMenit;
        return String.format("%s, %02d:00 - %02d:%02d (%d menit)",
                this.hari, this.jamMulai, selesaiMenit / 60, selesaiMenit % 60, this.durasiMenit);
    }

    public void tampilkanInfo() {
        String namaMentor = (this.mentor != null)
                ? this.mentor.getNama() + " (" + this.mentor.getKode() + ")"
                : "-";

        System.out.println("==========================================================");
        System.out.printf(" [%s] %s - %s%n", this.getTipe().toUpperCase(), this.getKode(), this.nama);
        System.out.println("----------------------------------------------------------");
        System.out.printf(" %-15s: %d tahun%n", "Umur", this.umur);
        System.out.printf(" %-15s: %s%n", "Mata Pelajaran", this.mataPelajaran);
        System.out.printf(" %-15s: %s%n", "Mentor", namaMentor);
        System.out.printf(" %-15s: %s%n", "Jadwal", this.getJadwal());
        System.out.printf(" %-15s: %s%n", "Biaya / bulan", formatRupiah(this.hitungBiaya()));
    }

    public static String formatRupiah(double nominal) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,.0f", nominal);
    }
}