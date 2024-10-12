package pesawat;

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenPesawat implements CRUDPesawat {
    ArrayList<Pesawat> daftarPesawat = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String idPesawat;
    String namaPesawat;
    int kecepatanPesawat;

    public ManajemenPesawat(){
        daftarPesawat.add(new PesawatTempur("1113", "McDonnell Douglas F-4 Phantom II", "Tempur" ,2716, 200, 500));
        daftarPesawat.add(new PesawatKargo("1122", "Boeing 747 Dreamlifter", "Kargo", 988, 500));
    }

    @Override
    public void MenuAwal(){
        System.out.println("+=================================+");
        System.out.println("| Sistem Manajemen Armada Pesawat |");
        System.out.println("+=================================+");
        System.out.println("| [1]. Create                     |");
        System.out.println("| [2]. Read                       |");
        System.out.println("| [3]. Update                     |");
        System.out.println("| [4]. Delete                     |");
        System.out.println("| [5]. Exit                       |");
        System.out.println("+=================================+");
        System.out.print("| Masukkan pilihan anda: ");
    }

    @Override
    public void buatPesawat(){
        boolean ketemu = false;

        System.out.print("Masukkan ID pesawat: ");
        idPesawat = scanner.nextLine();

        for (Pesawat pesawat:daftarPesawat){
            if (pesawat.getIdPesawat().equalsIgnoreCase(idPesawat)){
                ketemu = true;
                System.out.println("+=======================+");
                System.out.println("| ID Tersebut Sudah Ada |");
                System.out.println("+=======================+");
                System.out.println("Tekan enter untuk melanjutkan...");
                scanner.nextLine();
            }
        }

        if (ketemu == false){
            System.out.print("Masukkan nama pesawat: ");
            namaPesawat = scanner.nextLine();
            System.out.print("Masukkan kecepatan pesawat: ");
            kecepatanPesawat = scanner.nextInt();
            System.out.println("[1]. Pesawat Kargo [2]. Pesawat Tempur");
            System.out.print("Masukkan tipe pesawat: ");
            int pilihanTipe = scanner.nextInt();
            switch (pilihanTipe) {
                case 1:
                    System.out.print("Masukkan kapasitas kargo: ");
                    int kapasitasKargo = scanner.nextInt();
                    scanner.nextLine();
                    daftarPesawat.add(new PesawatKargo(idPesawat, namaPesawat, "Kargo", kecepatanPesawat, kapasitasKargo));
                    System.out.println("Pesawat " + namaPesawat + " berhasil ditambahkan");
                    break;
                case 2:
                    System.out.print("Masukkan jumlah peluru: ");
                    int jumlahPeluru = scanner.nextInt();
                    System.out.print("Masukkan jumlah rudal: ");
                    int jumlahRudal = scanner.nextInt();
                    scanner.nextLine();
                    daftarPesawat.add(new PesawatTempur(idPesawat, namaPesawat, "Tempur", kecepatanPesawat, jumlahPeluru, jumlahRudal));
                    System.out.println("Pesawat " + namaPesawat + " berhasil ditambahkan");
                    break;
                default:
                    System.out.println("+=========================+");
                    System.out.println("| Pilihan tidak tersedia! |");
                    System.out.println("+=========================+");
            }
        }

    }

    @Override
    public void tampilkanPesawat(){
        for (Pesawat pesawat : daftarPesawat){
            System.out.println("ID Pesawat: "+ pesawat.getIdPesawat() + "\nTipe Pesawat: " + pesawat.getTipePesawat() + "\nNama Pesawat: " + pesawat.getNamaPesawat() + "\nKecepatan Pesawat: " + pesawat.getKecepatanPesawat() + " km/h");
            pesawat.detailTambahan();
            System.out.println();
        }
    }

    @Override
    public void perbaruiPesawat(){
        System.out.print("Masukkan ID pesawat: ");
        idPesawat = scanner.nextLine();

        boolean ketemu = false;

        for (Pesawat pesawat: daftarPesawat){
            if(pesawat.getIdPesawat().equalsIgnoreCase(idPesawat)) {
                ketemu = true;
                System.out.print("Masukkan nama baru: ");
                namaPesawat = scanner.nextLine();
                System.out.print("Masukkan kecepatan baru: ");
                kecepatanPesawat = scanner.nextInt();
                if (pesawat instanceof PesawatTempur){
                    PesawatTempur pesawatTempur = (PesawatTempur) pesawat;
                    System.out.print("Masukkan jumlah peluru: ");
                    int jumlahPeluru = scanner.nextInt();
                    System.out.print("Masukkan jumlah rudal: ");
                    int jumlahRudal = scanner.nextInt();
                    scanner.nextLine();
                    pesawat.setNamaPesawat(namaPesawat);
                    pesawat.setKecepatanPesawat(kecepatanPesawat);
                    pesawatTempur.setJumlahPeluru(jumlahPeluru);
                    pesawatTempur.setJumlahRudal(jumlahRudal);
                    System.out.println("Data pesawat dengan ID " + pesawat.getIdPesawat() + " berhasil diubah");
                } else {
                    PesawatKargo pesawatKargo = (PesawatKargo) pesawat;
                    System.out.print("Masukkan kapasitas kargo: ");
                    int kapasitasKargo = scanner.nextInt();
                    scanner.nextLine();
                    pesawat.setNamaPesawat(namaPesawat);
                    pesawat.setKecepatanPesawat(kecepatanPesawat);
                    pesawatKargo.setKapasitasKargo(kapasitasKargo);
                    System.out.println("Data pesawat dengan ID " + pesawat.getIdPesawat() + " berhasil diubah");

                }
            }
        }
        if (ketemu == false){
            System.out.println("+=========================+");
            System.out.println("| Pesawat Tidak Ditemukan |");
            System.out.println("+=========================+");
        }
    }

    @Override
    public void hapusPesawat(){
        System.out.print("Masukkan ID pesawat: ");
        idPesawat = scanner.nextLine();
        Pesawat pesawatditemukan = null;
        boolean ketemu = false;

        for (Pesawat pesawat: daftarPesawat){
            if(pesawat.getIdPesawat().equalsIgnoreCase(idPesawat)) {
                ketemu = true;
                pesawatditemukan = pesawat;
                break;
            }
        }

        if (ketemu == true){
            daftarPesawat.remove(pesawatditemukan);
            System.out.println("+==========================+");
            System.out.println("| Pesawat berhasil dihapus |");
            System.out.println("+==========================+");
        } else {
            System.out.println("+=========================+");
            System.out.println("| Pesawat Tidak Ditemukan |");
            System.out.println("+=========================+");
        }
    }
}