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