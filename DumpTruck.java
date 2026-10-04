package model;

public class DumpTruck extends KendaraanTambang {

    private double kapasitasTon;

    public DumpTruck(String id, String namaKendaraan, double hargaSewaPerHari, double kapasitasTon) {
        super(id, namaKendaraan, hargaSewaPerHari);
        setKapasitasTon(kapasitasTon);
    }

    public double getKapasitasTon() {
        return kapasitasTon;
    }

    public void setKapasitasTon(double kapasitasTon) {
        if (kapasitasTon <= 0) {
            throw new IllegalArgumentException("Kapasitas (ton) harus lebih dari 0.");
        }
        this.kapasitasTon = kapasitasTon;
    }

    @Override
    public String getJenis() {
        return "Dump Truck";
    }

    @Override
    public String getDetail() {
        return String.format("Kapasitas %.1f ton", kapasitasTon);
    }

    @Override
    public double hitungBiayaSewa(int hari) {
        double sewa = getHargaSewaPerHari() * hari;
        double biayaBBM = sewa * 0.10;
        return sewa + biayaBBM;
    }
}
