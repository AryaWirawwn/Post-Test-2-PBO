# Profil
Nama: Muhammad Aryaputra Wirawan\
NIM: 2309116027\
Tema: Sistem Manajemen Armada Pesawat

# Deskripsi
<p align = "justify"> Program ini adalah sebuah program CRUD dengan tema Sistem Manajemen Armada Pesawat. Di program ini user dapat membuat data pesawat yang berisi ID, nama, kecepatan, dan tipe pesawat. Jika tipe pesawat kargo maka akan ada data tambahan yaitu kapasitas kargo, sedangkan jika tipe pesawat tempur maka akan ada data tambahan yaitu jumlah peluru dan jumlah rudal. Program ini juga dapat membaca data pesawat yang telah ditambahkan sebelumnya. Selain itu program ini juga dapat mengedit data pesawat yang telah ditambahkan sebelumnya. Terakhir program ini dapat menghapus data pesawat yang sebelumnya telah ditambahkan. </p>

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
#### Pesawat Kargo
![{64C2508A-8A07-482C-A49E-20D378825E14}](https://github.com/user-attachments/assets/8ec69011-ad28-4685-b668-81abc42e3904)

<p align = "justify">Ketika memasukkan angka 1 di menu utama akan muncul menu membuat data pesawat. Disini user diminta untuk memasukkan ID pesawat. Jika ID pesawat tidak ada di Arraylist maka akan muncul pesan untuk memasukkan nama pesawat dan kecepatan pesawat. Setelah memasukkan kecepatan pesawat akan muncul pilihan untuk memilih tipe pesawat. Jika tipe pesawat yang dipilih adalah kargo maka akan muncul pesan untuk memasukkan kapasitas kargo.</p>

#### Pesawat Tempur
![{D3441CD2-58C6-44FF-BBB2-B74162C74D26}](https://github.com/user-attachments/assets/8b1f1516-9a19-453e-a925-e617c1f249a7)

Jika tipe pesawat yang dipilih adalah tempur maka akan muncul pesan untuk memasukkan jumlah peluru dan rudal.

![{DAA7C803-2922-45DF-A7A6-FD7FB585FA8A}](https://github.com/user-attachments/assets/780d2d6b-4167-4109-a802-66441e3308bc)

Jika ID pesawat sudah di data sebelumnya maka akan muncul pesan ID tersebut sudah ada. User harus memasukkan ID yang tidak ada di data.

### Menu Read
![{B4742411-5969-4B3A-A1D4-D2D34C2D3A4C}](https://github.com/user-attachments/assets/c255c78b-4724-4019-a706-6efc4c6eb0f0)

Ketika memasukkan angka 2 di menu utama maka akan muncul daftar data pesawat.

### Menu Update
![{143B61DC-930A-4D46-ABD7-584E07E16E82}](https://github.com/user-attachments/assets/a8e29c62-33ba-4111-9f40-7db52b7f593e)

![{AEF66D90-6198-4479-86C2-406195F11607}](https://github.com/user-attachments/assets/8cae56f2-c361-4185-9045-c2c380ce8e96)

<p align = "justify"> Ketika memasukkan angka 3 di menu utama maka akan muncul daftar data pesawat dan menu untuk memasukkan ID pesawat yang ingin diubah. Setelah itu user akan memasukkan nama dan kecepatan baru. Jika pesawat bertipe kargo maka akan muncul menu untuk memasukkan kapasitas kargo, sedangkan jika bertipe pesawat tempur maka akan muncul menu untuk memasukkan jumlah peluru dan rudal. Jika berhasil diubah maka akan muncul pesan data pesawat berhasil diubah. </p>

![{68C17899-49A3-4703-BFD6-2C65807263E7}](https://github.com/user-attachments/assets/566dffa9-cea5-412b-b104-57a5c0417cf6)

Jika ID pesawat tidak ada, maka akan muncul pesan pesawat tidak ditemukan.

### Menu Delete
![{4B188BC0-327B-445B-A69F-AB93AB957891}](https://github.com/user-attachments/assets/93ea93ea-11e7-4458-b531-b41f36e023e1)

![{012DC3F5-11A3-4B04-A5DE-8002CBF85637}](https://github.com/user-attachments/assets/5878ce6d-1b27-408d-8a01-3ca4161f3acd)

Ketika memasukkan angka 4 di menu utama maka akan muncul daftar pesawat dan menu untuk memasukkan ID pesawat yang ingin dihapus. Jika berhasil dihapus maka akan muncul pesan data pesawat berhasil dihapus.

![{71F82621-24C3-4F78-8705-0F42BF5260EA}](https://github.com/user-attachments/assets/3b020b8a-233a-49f4-9068-82b0322ba28c)

Jika ID pesawat tidak ada, maka akan muncul pesan pesawat tidak ditemukan.

### Exit
![{1CC8FEEB-8541-4405-94FA-CABFB177035E}](https://github.com/user-attachments/assets/7e062d94-a076-4710-90e9-b5c790ca7ae9)

Masukkan angka 5 pada menu utama untuk keluar dari program.

