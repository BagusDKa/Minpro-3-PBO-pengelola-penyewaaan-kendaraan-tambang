package model;

import java.util.ArrayList;

public class PengelolaKendaraan {

    private ArrayList<KendaraanTambang> daftarKendaraan;

    public PengelolaKendaraan() {
        this.daftarKendaraan = new ArrayList<>();
        isiDataAwal();
    }

    private void isiDataAwal() {
        daftarKendaraan.add(new DumpTruck("DT-001", "Komatsu HD785", 3500000, 91.0));
        daftarKendaraan.add(new DumpTruck("DT-002", "Caterpillar 777", 3200000, 100.0));
        daftarKendaraan.add(new Excavator("EX-001", "Komatsu PC200", 2500000, 1.2));
    }

    public boolean tambahKendaraan(KendaraanTambang kendaraan) {
        if (cariIndexById(kendaraan.getId()) != -1) {
            return false;
        }
        daftarKendaraan.add(kendaraan);
        return true;
    }

    public ArrayList<KendaraanTambang> getSemuaKendaraan() {
        return new ArrayList<>(daftarKendaraan);
    }

    public int cariIndexById(String id) {
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            if (daftarKendaraan.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }


    public KendaraanTambang cari(String id) {
        int index = cariIndexById(id);
        return (index == -1) ? null : daftarKendaraan.get(index);
    }

    public ArrayList<KendaraanTambang> cari(double hargaMin, double hargaMax) {
        ArrayList<KendaraanTambang> hasil = new ArrayList<>();
        for (KendaraanTambang k : daftarKendaraan) {
            if (k.getHargaSewaPerHari() >= hargaMin && k.getHargaSewaPerHari() <= hargaMax) {
                hasil.add(k);
            }
        }
        return hasil;
    }

    public boolean updateKendaraan(String id, String namaBaru, double hargaBaru) {
        KendaraanTambang k = cari(id);
        if (k == null) {
            return false;
        }
        k.setNamaKendaraan(namaBaru);
        k.setHargaSewaPerHari(hargaBaru);
        return true;
    }

    public boolean hapusKendaraan(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        daftarKendaraan.remove(index);
        return true;
    }

    public int getJumlahData() {
        return daftarKendaraan.size();
    }
}
