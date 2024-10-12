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
