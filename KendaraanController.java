package controller;

import model.DumpTruck;
import model.Excavator;
import model.KendaraanTambang;
import model.PengelolaKendaraan;
import view.KendaraanView;

public class KendaraanController {

    private final PengelolaKendaraan model;
    private final KendaraanView view;

    public KendaraanController(PengelolaKendaraan model, KendaraanView view) {
        this.model = model;
        this.view = view;
    }

    public void jalankan() {
        int pilihan;
        do {
            view.tampilkanMenu();
            pilihan = view.bacaIntRentang("Pilih menu (1-6): ", 1, 6);

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    view.tampilkanDaftar(model.getDaftarKendaraan());
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    hitungBiaya();
                    break;
                case 6:
                    view.tampilkanPesan("Terima kasih, program selesai.");
                    break;
            }
        } while (pilihan != 6);
    }

    private void tambahData() {
        view.tampilkanJudul("Tambah Data Kendaraan");
        view.tampilkanJenisKendaraan();
        int jenis = view.bacaIntRentang("Pilih jenis (1-2): ", 1, 2);

        String id = view.bacaStringTidakKosong("ID Kendaraan       : ");
        if (model.cariIndexById(id) != -1) {
            view.tampilkanPesan("Gagal: ID sudah dipakai.");
            return;
        }
        String nama = view.bacaStringTidakKosong("Nama Kendaraan    : ");
        double harga = view.bacaDoublePositif("Harga Sewa / Hari : ");

        KendaraanTambang kendaraan; // tipe parent, objek bisa DumpTruck/Excavator
        if (jenis == 1) {
            double kapasitas = view.bacaDoublePositif("Kapasitas (ton)   : ");
            kendaraan = new DumpTruck(id, nama, harga, kapasitas);
        } else {
            double kapasitas = view.bacaDoublePositif("Kapasitas bucket (m3): ");
            kendaraan = new Excavator(id, nama, harga, kapasitas);
        }

        if (model.tambahKendaraan(kendaraan)) {
            view.tampilkanPesan("Data berhasil ditambahkan.");
        } else {
            view.tampilkanPesan("Gagal: ID sudah dipakai.");
        }
    }

    private void updateData() {
        view.tampilkanJudul("Update Data Kendaraan");
        if (model.getJumlahData() == 0) {
            view.tampilkanPesan("Belum ada data kendaraan.");
            return;
        }
        view.tampilkanDaftar(model.getDaftarKendaraan());
        String id = view.bacaStringTidakKosong("Masukkan ID yang akan diupdate: ");
        if (model.cariIndexById(id) == -1) {
            view.tampilkanPesan("Data dengan ID tersebut tidak ditemukan.");
            return;
        }
        String namaBaru = view.bacaStringTidakKosong("Nama baru          : ");
        double hargaBaru = view.bacaDoublePositif("Harga sewa/hari baru: ");

        if (model.updateKendaraan(id, namaBaru, hargaBaru)) {
            view.tampilkanPesan("Data berhasil diupdate.");
        } else {
            view.tampilkanPesan("Gagal mengupdate data.");
        }
    }

    private void hapusData() {
        view.tampilkanJudul("Hapus Data Kendaraan");
        if (model.getJumlahData() == 0) {
            view.tampilkanPesan("Belum ada data kendaraan.");
            return;
        }
        view.tampilkanDaftar(model.getDaftarKendaraan());
        String id = view.bacaStringTidakKosong("Masukkan ID yang akan dihapus: ");
        if (model.hapusKendaraan(id)) {
            view.tampilkanPesan("Data berhasil dihapus.");
        } else {
            view.tampilkanPesan("Data dengan ID tersebut tidak ditemukan.");
        }
    }

    private void hitungBiaya() {
        view.tampilkanJudul("Hitung Biaya Sewa");
        if (model.getJumlahData() == 0) {
            view.tampilkanPesan("Belum ada data kendaraan.");
            return;
        }
        view.tampilkanDaftar(model.getDaftarKendaraan());
        String id = view.bacaStringTidakKosong("Masukkan ID kendaraan: ");
        KendaraanTambang k = model.cariById(id);
        if (k == null) {
            view.tampilkanPesan("Data dengan ID tersebut tidak ditemukan.");
            return;
        }

        int hari = view.bacaIntRentang("Lama sewa (hari, 1-365): ", 1, 365);

        if (view.bacaYaTidak("Pakai diskon? (y/n): ")) {
            int diskon = view.bacaIntRentang("Diskon (1-100 %): ", 1, 100);
            double total = k.hitungBiayaSewa(hari, diskon);   
            view.tampilkanHasilBiaya(k, hari, diskon, total);
        } else {
            double total = k.hitungBiayaSewa(hari);           
            view.tampilkanHasilBiaya(k, hari, total);
        }
    }
}
