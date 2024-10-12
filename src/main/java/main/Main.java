package main;

import pesawat.ManajemenPesawat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;
        int pilihan;
        ManajemenPesawat manajemen = new ManajemenPesawat();
        do {
            manajemen.MenuAwal();
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    manajemen.buatPesawat();
                    break;
                case 2:
                    System.out.println("Daftar Pesawat:");
                    manajemen.tampilkanPesawat();
                    break;
                case 3:
                    System.out.println("Daftar Pesawat:");
                    manajemen.tampilkanPesawat();
                    scanner.nextLine();
                    manajemen.perbaruiPesawat();
                    break;
                case 4:
                    System.out.println("Daftar Pesawat:");
                    manajemen.tampilkanPesawat();
                    scanner.nextLine();
                    manajemen.hapusPesawat();
                    break;
                case 5:
                    selesai = true;
                    System.out.println("+============================================+");
                    System.out.println("| Terima Kasih Telah Menggunakan Program Ini |");
                    System.out.println("+============================================+");
                    break;
                default:
                    System.out.println("+=========================+");
                    System.out.println("| Pilihan tidak tersedia! |");
                    System.out.println("+=========================+");
            }
        }
        while (selesai == false);
    }
}
