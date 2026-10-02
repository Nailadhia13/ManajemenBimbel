package com.mycompany.kostku.manajemenbimbel;

public class SiswaOnline extends Siswa {
    private static final double POTONGAN_ONLINE = 0.20;

    private String platform;
    private String linkKelas;

    // Ubah int jamMulai menjadi double jamMulai di sini
    public SiswaOnline(String nama, int umur, String mataPelajaran, Mentor mentor,
                       String hari, double jamMulai, String platform, String linkKelas) {
        super(nama, umur, mataPelajaran, mentor, hari, jamMulai);
        this.setPlatform(platform);
        this.setLinkKelas(linkKelas);
    }

    public static boolean isLinkValid(String link) {
        return link != null && (link.startsWith("http://") || link.startsWith("https://"));
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        if (isTeksValid(platform)) {
            this.platform = platform.trim();
        } else {
            System.out.println("[!] Platform tidak boleh kosong. Nilai tidak diubah.");
        }
    }

    public String getLinkKelas() {
        return this.linkKelas;
    }

    public void setLinkKelas(String linkKelas) {
        if (isLinkValid(linkKelas)) {
            this.linkKelas = linkKelas.trim();
        } else {
            System.out.println("[!] Link harus diawali http:// atau https://. Nilai tidak diubah.");
        }
    }

    @Override
    public String getTipe() {
        return "Online";
    }

    @Override
    public double hitungBiaya() {
        return super.hitungBiaya() * (1 - POTONGAN_ONLINE);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" %-15s: %s%n", "Platform", this.platform);
        System.out.printf(" %-15s: %s%n", "Link Kelas", this.linkKelas);
    }
}