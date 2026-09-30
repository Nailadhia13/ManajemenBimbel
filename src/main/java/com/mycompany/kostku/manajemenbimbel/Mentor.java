package com.mycompany.kostku.manajemenbimbel;

public class Mentor {
    private static int totalMentor = 0;

    private int id;
    private String nama;
    private String bidang;
    private int pengalamanTahun;

    public Mentor(String nama, String bidang, int pengalamanTahun) {
        this.setNama(nama);
        this.setBidang(bidang);
        this.setPengalamanTahun(pengalamanTahun);
        totalMentor++;
        this.id = totalMentor;
    }

    public static boolean isTeksValid(String teks) {
        return teks != null && !teks.trim().isEmpty();
    }

    public static boolean isPengalamanValid(int tahun) {
        return tahun >= 0 && tahun <= 50;
    }

    public int getId() {
        return this.id;
    }

    public String getKode() {
        return String.format("M%02d", this.id);
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        if (isTeksValid(nama)) {
            this.nama = nama.trim();
        } else {
            System.out.println("[!] Nama mentor tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public String getBidang() {
        return this.bidang;
    }

    public void setBidang(String bidang) {
        if (isTeksValid(bidang)) {
            this.bidang = bidang.trim();
        } else {
            System.out.println("[!] Bidang mentor tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public int getPengalamanTahun() {
        return this.pengalamanTahun;
    }

    public void setPengalamanTahun(int pengalamanTahun) {
        if (isPengalamanValid(pengalamanTahun)) {
            this.pengalamanTahun = pengalamanTahun;
        } else {
            System.out.println("[!] Pengalaman harus 0 - 50 tahun. Nilai tidak diubah.");
        }
    }

    public static int getTotalMentor() {
        return totalMentor;
    }

    public static void cetakGarisTabel() {
        System.out.println("+-------+----------------------+----------------------------+------------+");
    }

    public static void cetakHeaderTabel() {
        cetakGarisTabel();
        System.out.printf("| %-5s | %-20s | %-26s | %-10s |%n",
                "ID", "Nama Mentor", "Bidang", "Pengalaman");
        cetakGarisTabel();
    }

    public void cetakBaris() {
        System.out.printf("| %-5s | %-20.20s | %-26.26s | %-10s |%n",
                this.getKode(), this.nama, this.bidang, this.pengalamanTahun + " tahun");
    }
}