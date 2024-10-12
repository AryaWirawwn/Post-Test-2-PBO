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
