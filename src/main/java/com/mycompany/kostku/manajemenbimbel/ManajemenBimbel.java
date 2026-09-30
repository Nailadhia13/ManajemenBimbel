package com.mycompany.kostku.manajemenbimbel;

import java.util.Scanner;

public class ManajemenBimbel {
    private static final int KAPASITAS = 50;

    private Siswa[] daftarSiswa = new Siswa[KAPASITAS];
    private int jumlahSiswa = 0;
    private Mentor[] daftarMentor = new Mentor[KAPASITAS];
    private int jumlahMentor = 0;

    public int getJumlahSiswa() {
        return this.jumlahSiswa;
    }

    public int getJumlahMentor() {
        return this.jumlahMentor;
    }

    public boolean tambahSiswa(Siswa siswa) {
        if (this.jumlahSiswa >= KAPASITAS) {
            System.out.println("[!] Kapasitas data siswa penuh (" + KAPASITAS + ").");
            return false;
        }
        this.daftarSiswa[this.jumlahSiswa] = siswa;
        this.jumlahSiswa++;
        return true;
    }

    public boolean tambahMentor(Mentor mentor) {
        if (this.jumlahMentor >= KAPASITAS) {
            System.out.println("[!] Kapasitas data mentor penuh (" + KAPASITAS + ").");
            return false;
        }
        this.daftarMentor[this.jumlahMentor] = mentor;
        this.jumlahMentor++;
        return true;
    }

    public Siswa temukanSiswa(int id) {
        for (int i = 0; i < this.jumlahSiswa; i++) {
            if (this.daftarSiswa[i].getId() == id) {
                return this.daftarSiswa[i];
            }
        }
        return null;
    }

    public Mentor temukanMentor(int id) {
        for (int i = 0; i < this.jumlahMentor; i++) {
            if (this.daftarMentor[i].getId() == id) {
                return this.daftarMentor[i];
            }
        }
        return null;
    }

    public void tampilkanSemuaSiswa() {
        if (this.jumlahSiswa == 0) {
            System.out.println("Belum ada data siswa.");
            return;
        }
        for (int i = 0; i < this.jumlahSiswa; i++) {
            this.daftarSiswa[i].tampilkanInfo();
        }
        cetakGaris();
        System.out.println(" Total siswa terdaftar : " + Siswa.getTotalSiswa());
    }

    public void tampilkanSemuaMentor() {
        if (this.jumlahMentor == 0) {
            System.out.println("Belum ada data mentor.");
            return;
        }
        Mentor.cetakHeaderTabel();
        for (int i = 0; i < this.jumlahMentor; i++) {
            this.daftarMentor[i].cetakBaris();
        }
        Mentor.cetakGarisTabel();
        System.out.println(" Total mentor terdaftar : " + Mentor.getTotalMentor());
    }

    public void tampilkanDaftarMataPelajaran() {
        if (this.jumlahMentor == 0) {
            System.out.println("Belum ada data mata pelajaran.");
            return;
        }
        cetakGaris();
        System.out.println("                 DAFTAR MATA PELAJARAN BIMBEL             ");
        cetakGaris();
        for (int i = 0; i < this.jumlahMentor; i++) {
            System.out.printf(" %d. %s (Mentor: %s)%n", 
                (i + 1), 
                this.daftarMentor[i].getBidang(), 
                this.daftarMentor[i].getNama());
        }
        cetakGaris();
    }

    public int tampilkanMentorByBidang(String bidang) {
        int ditemukan = 0;
        for (int i = 0; i < this.jumlahMentor; i++) {
            if (this.daftarMentor[i].getBidang().equalsIgnoreCase(bidang)) {
                if (ditemukan == 0) {
                    Mentor.cetakHeaderTabel();
                }
                this.daftarMentor[i].cetakBaris();
                ditemukan++;
            }
        }
        if (ditemukan > 0) {
            Mentor.cetakGarisTabel();
        }
        return ditemukan;
    }

    public int cariSiswa(int id) {
        System.out.println("\nHasil pencarian ID siswa = " + id);
        Siswa hasil = this.temukanSiswa(id);
        if (hasil == null) {
            System.out.println(" Data tidak ditemukan.");
            return 0;
        }
        hasil.tampilkanInfo();
        cetakGaris();
        return 1;
    }

    public int cariSiswa(String nama) {
        System.out.println("\nHasil pencarian nama mengandung \"" + nama + "\"");
        int ditemukan = 0;
        for (int i = 0; i < this.jumlahSiswa; i++) {
            if (this.daftarSiswa[i].getNama().toLowerCase().contains(nama.trim().toLowerCase())) {
                this.daftarSiswa[i].tampilkanInfo();
                ditemukan++;
            }
        }
        if (ditemukan == 0) {
            System.out.println(" Data tidak ditemukan.");
        } else {
            cetakGaris();
            System.out.println(" Ditemukan " + ditemukan + " siswa.");
        }
        return ditemukan;
    }

    private static void cetakGaris() {
        System.out.println("==========================================================");
    }

    public void isiDataAwal() {
        Mentor mJava   = new Mentor("M.Faris Adithya",     "Pemrograman Java",          6);
        Mentor mPython = new Mentor("Maulana Ramadhan",   "Pemrograman Python",        4);
        Mentor mRPL    = new Mentor("Herdi Irawan",   "Rekayasa Perangkat Lunak", 5);
        Mentor mJar    = new Mentor("Wisnu Wira Winata", "Jaringan Komputer",         7);
        Mentor mOperasi = new Mentor("Achira Desya Luci",      "Sistem Operasi",             3);
        Mentor mKompal = new Mentor("Zahra Ayu Azizah",   "Kompleksitas Algoritma",          8);

        this.tambahMentor(mJava);
        this.tambahMentor(mPython);
        this.tambahMentor(mRPL);
        this.tambahMentor(mJar);
        this.tambahMentor(mOperasi);
        this.tambahMentor(mKompal);

        this.tambahSiswa(new SiswaOnline("Nailadhia Martafani", 19, "Pemrograman Java", mJava,
                "Senin", 16, "Zoom", "https://zoom.us/j/1234567890"));
        this.tambahSiswa(new SiswaOnline("Annisa Partiwi", 20, "Pemrograman Python", mPython,
                "Rabu", 19, "Google Meet", "https://meet.google.com/abc-defg-hij"));

        this.tambahSiswa(new SiswaPrivate("Putri Faradilah", 15, "Rekayasa Perangkat Lunak", mRPL,
                "Selasa", 15, "Jl. Kenanga No. 12", 2));
        this.tambahSiswa(new SiswaPrivate("Suci Meisyila", 22, "Jaringan Komputer", mJar,
                "Kamis", 18, "Jl. Melati No. 5", 1));

        this.tambahSiswa(new SiswaUmum("Muhammad Revan Wirawan", 16, "Kompleksitas Algoritma", mKompal,
                "Sabtu", 9, "Lab 1", "Pemula"));
        this.tambahSiswa(new SiswaUmum("Ratu Salsabila Humaira", 19, "Sistem Operasi", mOperasi,
                "Jumat", 14, "Lab 2", "Menengah"));
    }

    public static void main(String[] args) {
        ManajemenBimbel mb = new ManajemenBimbel();
        mb.isiDataAwal();
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n==========================================================");
            System.out.println("                          BIMBELin                          ");
            System.out.println("============================================================");
            System.out.println("1. Tampilkan Semua Mentor");
            System.out.println("2. Tampilkan Semua Siswa");
            System.out.println("3. Tampilkan Daftar Mata Pelajaran");
            System.out.println("4. Tambah Siswa Baru");
            System.out.println("5. Cari Siswa Berdasarkan ID");
            System.out.println("6. Cari Siswa Berdasarkan Nama");
            System.out.println("7. Tampilkan Mentor Berdasarkan Bidang");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu (1-8): ");
            
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("[!] Masukkan angka yang valid.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    mb.tampilkanSemuaMentor();
                    break;
                case 2:
                    mb.tampilkanSemuaSiswa();
                    break;
                case 3:
                    mb.tampilkanDaftarMataPelajaran();
                    break;
                case 4:
                    System.out.println("\n--- TAMBAH SISWA BARU ---");
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Umur: ");
                    int umur = scanner.nextInt();
                    scanner.nextLine();
                    
                    mb.tampilkanDaftarMataPelajaran();
                    System.out.print("Pilih nomor mata pelajaran atau ketik nama mapel: ");
                    String mapel = scanner.nextLine();
                    if (mapel.matches("\\d+")) {
                        int indexMapel = Integer.parseInt(mapel) - 1;
                        if (indexMapel >= 0 && indexMapel < mb.getJumlahMentor()) {
                            mapel = mb.daftarMentor[indexMapel].getBidang();
                        }
                    }
                    
                    System.out.println("Pilih Mentor berdasarkan ID:");
                    mb.tampilkanSemuaMentor();
                    System.out.print("Masukkan ID Mentor: ");
                    int idMentor = scanner.nextInt();
                    scanner.nextLine();
                    Mentor mentorPilihan = mb.temukanMentor(idMentor);
                    
                    if (mentorPilihan == null) {
                        System.out.println("[!] Mentor tidak ditemukan. Pembatalan penambahan siswa.");
                        break;
                    }
                    
                    System.out.print("Masukkan Hari (Senin-Sabtu): ");
                    String hari = scanner.nextLine();
                    System.out.print("Masukkan Jam Mulai (8-20): ");
                    int jam = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Pilih Tipe Bimbel:");
                    System.out.println("1. Online");
                    System.out.println("2. Private");
                    System.out.println("3. Umum");
                    System.out.print("Pilih tipe (1-3): ");
                    int tipeBimbel = scanner.nextInt();
                    scanner.nextLine();
                    
                    boolean statusTambah = false;
                    if (tipeBimbel == 1) {
                        System.out.print("Masukkan Platform (misal: Zoom): ");
                        String platform = scanner.nextLine();
                        System.out.print("Masukkan Link Kelas (https://...): ");
                        String link = scanner.nextLine();
                        statusTambah = mb.tambahSiswa(new SiswaOnline(nama, umur, mapel, mentorPilihan, hari, jam, platform, link));
                    } else if (tipeBimbel == 2) {
                        System.out.print("Masukkan Alamat Belajar: ");
                        String alamat = scanner.nextLine();
                        System.out.print("Masukkan Sesi per Minggu (1-5): ");
                        int sesi = scanner.nextInt();
                        scanner.nextLine();
                        statusTambah = mb.tambahSiswa(new SiswaPrivate(nama, umur, mapel, mentorPilihan, hari, jam, alamat, sesi));
                    } else if (tipeBimbel == 3) {
                        System.out.print("Masukkan Ruang Lab: ");
                        String lab = scanner.nextLine();
                        System.out.print("Masukkan Level (Pemula/Menengah/Mahir): ");
                        String level = scanner.nextLine();
                        statusTambah = mb.tambahSiswa(new SiswaUmum(nama, umur, mapel, mentorPilihan, hari, jam, lab, level));
                    } else {
                        System.out.println("[!] Tipe bimbel tidak valid.");
                        break;
                    }
                    
                    if (statusTambah) {
                        System.out.println("[Sukses] Siswa baru berhasil ditambahkan!");
                    }
                    break;
                case 5:
                    System.out.print("Masukkan ID Siswa: ");
                    int idSiswa = scanner.nextInt();
                    scanner.nextLine();
                    mb.cariSiswa(idSiswa);
                    break;
                case 6:
                    System.out.print("Masukkan Nama Siswa (atau potongan nama): ");
                    String namaSiswa = scanner.nextLine();
                    mb.cariSiswa(namaSiswa);
                    break;
                case 7:
                    System.out.print("Masukkan Bidang Mentor: ");
                    String bidang = scanner.nextLine();
                    int hasil = mb.tampilkanMentorByBidang(bidang);
                    if (hasil == 0) {
                        System.out.println(" Tidak ada mentor dalam bidang tersebut.");
                    }
                    break;
                case 8:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("[!] Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 8);

        scanner.close();
    }
}