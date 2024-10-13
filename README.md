# Profil
Nama: Muhammad Aryaputra Wirawan\
NIM: 2309116027\
Tema: Sistem Manajemen Armada Pesawat

# Deskripsi
Program ini adalah sebuah program CRUD dengan tema sistem manajemen armada pesawat. Di program ini user dapat membuat data pesawat seperti ID, nama, tipe, dan kecepatan pesawat. Program ini juga dapat membaca apa saja data pesawat yang ada. Selain itu program ini dapat mengedit data pesawat yang telah dibuat sebelumnya. Terakhir program ini dapat menghapus data pesawat.

# Struktur Package
![{CFC734B6-3B69-42F4-B490-C358146B8060}](https://github.com/user-attachments/assets/7494055e-321e-4a2a-9c40-c0f73cfbbc4d)

# Source Code
## Package main
### Class Main.java
```java
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
```
## Package pesawat
### Interface CRUDPesawat.java
```java
package pesawat;

public interface CRUDPesawat {
    public void MenuAwal();
    public void buatPesawat();
    public void tampilkanPesawat();
    public void perbaruiPesawat();
    public void hapusPesawat();
}
```
### Class ManajemenPesawat.java
```java
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
```
### Class Pesawat.java
```java
package pesawat;

abstract public class Pesawat {
    private final String idPesawat;
    private String namaPesawat;
    private final String tipePesawat;
    private int kecepatanPesawat;

    public Pesawat(String id, String nama, String tipePesawat, int kecepatan){
        this.idPesawat = id;
        this.namaPesawat = nama;
        this.tipePesawat = tipePesawat;
        this.kecepatanPesawat = kecepatan;
    }

    abstract public void detailTambahan();

    public String getIdPesawat() {
        return idPesawat;
    }

    public String getNamaPesawat() {
        return namaPesawat;
    }

    public void setNamaPesawat(String namaPesawat) {
        this.namaPesawat = namaPesawat;
    }

    public String getTipePesawat(){
        return tipePesawat;
    }

    public int getKecepatanPesawat() {
        return kecepatanPesawat;
    }

    public void setKecepatanPesawat(int kecepatanPesawat) {
        this.kecepatanPesawat = kecepatanPesawat;
    }
}
```
### Class PesawatKargo.java
```java
package pesawat;

final public class PesawatKargo extends Pesawat{
    private int kapasitasKargo;

    public PesawatKargo(String id, String nama, String tipePesawat, int kecepatan, int kapasitasKargo) {
        super(id, nama, tipePesawat, kecepatan);
        this.kapasitasKargo = kapasitasKargo;
    }

    @Override
    public void detailTambahan(){
        System.out.println("Kapasitas Kargo: " + this.kapasitasKargo);
    }

    public int getKapasitasKargo() {
        return kapasitasKargo;
    }

    public void setKapasitasKargo(int kapasitasKargo) {
        this.kapasitasKargo = kapasitasKargo;
    }

    public void memasukkanBarang(int jumlahBarang){
        if (jumlahBarang <= this.kapasitasKargo){
            System.out.println("Barang dimasukkan sebanyak: " + jumlahBarang);
            this.kapasitasKargo = this.kapasitasKargo - jumlahBarang;
        } else {
            System.out.println("+==============+");
            System.out.println("| Kargo Penuh! |");
            System.out.println("+==============+");
        }
    }
}
```
### Class PesawatTempur.java
```java
package pesawat;

final public class PesawatTempur extends Pesawat{
    private int jumlahPeluru;
    private int jumlahRudal;

    public PesawatTempur(String id, String nama, String tipePesawat, int kecepatan, int jumlahPeluru, int jumlahRudal) {
        super(id, nama, tipePesawat, kecepatan);
        this.jumlahPeluru = jumlahPeluru;
        this.jumlahRudal = jumlahRudal;
    }

    @Override
    public void detailTambahan(){
        System.out.println("Jumlah Peluru: " + this.jumlahPeluru + "\nJumlah Rudal: " + this.jumlahRudal);
    }

    public int getJumlahPeluru() {
        return jumlahPeluru;
    }

    public void setJumlahPeluru(int jumlahPeluru) {
        this.jumlahPeluru = jumlahPeluru;
    }

    public int getJumlahRudal() {
        return jumlahRudal;
    }

    public void setJumlahRudal(int jumlahRudal) {
        this.jumlahRudal = jumlahRudal;
    }

    public void tembakPeluru(int jumlahPeluru){
        if (jumlahPeluru <= this.jumlahPeluru){
            System.out.println("Peluru ditembakkan sebanyak: " +jumlahPeluru);
            this.jumlahPeluru = this.jumlahPeluru - jumlahPeluru;
            System.out.println("Brrrrrtttttttttttt");
        } else {
            System.out.println("+=====================+");
            System.out.println("| Peluru Tidak Cukup! |");
            System.out.println("+=====================+");
        }
    }

    public void tembakRudal(int jumlahRudal){
        if (jumlahRudal <= this.jumlahRudal){
            System.out.println("Rudal ditembakkan sebanyak: " + jumlahRudal);
            this.jumlahRudal  = this.jumlahRudal - jumlahRudal;
            System.out.println("Whoooosh... BOOM!");
        } else {
            System.out.println("+====================+");
            System.out.println("| Rudal Tidak Cukup! |");
            System.out.println("+====================+");
        }
    }
}
```

## Output Program
### Menu Utama
![{8806B86F-1647-4807-8918-506A53F01C67}](https://github.com/user-attachments/assets/6b831e7e-3991-444f-9193-c03e0887f1c0)

Ketika pertama kali menjalankan kode maka akan muncul menu utama yang berisi Create, Read, Update, Delete, dan Exit.

### Menu Create
![{CFA24213-8D1B-4A8E-BF8E-9A94ACA55298}](https://github.com/user-attachments/assets/8a3783b6-5846-4255-93a4-6ce1595cfffa)

Ketika memasukkan angka 1 di menu utama akan muncul menu membuat data pesawat. Jika ID pesawat tidak ada di ArrayList maka akan muncul pesan untuk memasukkan nama pesawat dan kecepatan pesawat.

![{DAA7C803-2922-45DF-A7A6-FD7FB585FA8A}](https://github.com/user-attachments/assets/780d2d6b-4167-4109-a802-66441e3308bc)

Jika ID pesawat sudah di data sebelumnya maka akan muncul pesan ID tersebut sudah ada. User harus memasukkan ID yang tidak ada di data.

### Menu Read
![{AE0E7512-DC97-45D1-918D-E1198DEC417E}](https://github.com/user-attachments/assets/4ac589d1-e38e-4e33-b2e5-56d9e8111731)

Ketika memasukkan angka 2 di menu utama maka akan muncul daftar data pesawat.

### Menu Update
![{3AA6B3B8-B8CC-4FBC-B30D-FFA62FD3CAD0}](https://github.com/user-attachments/assets/f1571082-aaec-4a00-91f8-eca27734c83d)

![{824CC740-B6D6-4168-909A-6C68F254A5BC}](https://github.com/user-attachments/assets/151eaf8f-e1de-4f20-b999-393b5859cc52)

Ketika memasukkan angka 3 di menu utama maka akan muncul daftar data pesawat dan menu untuk memasukkan ID pesawat yang ingin diubah. Jika berhasil diubah maka akan muncul pesan data pesawat berhasil diubah.

![{68C17899-49A3-4703-BFD6-2C65807263E7}](https://github.com/user-attachments/assets/566dffa9-cea5-412b-b104-57a5c0417cf6)

Jika ID pesawat tidak ada, maka akan muncul pesan pesawat tidak ditemukan.

### Menu Delete
![{51A84AF9-5414-40C3-84FD-6B1ADCE6949C}](https://github.com/user-attachments/assets/9bdf60c3-e9c3-4868-ac8c-ab331698eb5e)

![{C58300FB-EE3B-4D0D-B8BE-9F194775D710}](https://github.com/user-attachments/assets/75e41e34-e77d-4cf5-ad11-07feab1f02bd)

Ketika memasukkan angka 4 di menu utama maka akan muncul daftar pesawat dan menu untuk memasukkan ID pesawat yang ingin dihapus. Jika berhasil dihapus maka akan muncul pesan data pesawat berhasil dihapus.

![{71F82621-24C3-4F78-8705-0F42BF5260EA}](https://github.com/user-attachments/assets/3b020b8a-233a-49f4-9068-82b0322ba28c)

Jika ID pesawat tidak ada, maka akan muncul pesan pesawat tidak ditemukan.

### Exit
![{1CC8FEEB-8541-4405-94FA-CABFB177035E}](https://github.com/user-attachments/assets/7e062d94-a076-4710-90e9-b5c790ca7ae9)

Masukkan angka 5 pada menu utama untuk keluar dari program.

