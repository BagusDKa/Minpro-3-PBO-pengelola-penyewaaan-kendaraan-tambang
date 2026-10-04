package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.KendaraanTambang;

public class KendaraanView {

    private final Scanner scanner = new Scanner(System.in);

    public void tampilkanMenu() {
        System.out.println();
        System.out.println("=== SISTEM PENYEWAAN KENDARAAN TAMBANG ===");
        System.out.println("1. Tambah Data Kendaraan");
        System.out.println("2. Tampilkan Semua Kendaraan");
        System.out.println("3. Update Data Kendaraan");
        System.out.println("4. Hapus Data Kendaraan");
        System.out.println("5. Hitung Biaya Sewa");
        System.out.println("6. Keluar");
    }

    public void tampilkanJudul(String judul) {
        System.out.println("\n--- " + judul + " ---");
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanDaftar(ArrayList<KendaraanTambang> daftar) {
        if (daftar.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }
        String garis = "=".repeat(100);
        System.out.println(garis);
        System.out.printf("%-8s | %-12s | %-20s | %-24s | %s%n",
                "ID", "Jenis", "Nama Kendaraan", "Harga Sewa/Hari", "Detail");
        System.out.println("-".repeat(100));
        for (KendaraanTambang k : daftar) {
            System.out.println(k);
        }
        System.out.println(garis);
    }

    public void tampilkanJenisKendaraan() {
        System.out.println("Jenis kendaraan:");
        System.out.println("1. Dump Truck");
        System.out.println("2. Excavator");
    }

    public void tampilkanHasilBiaya(KendaraanTambang k, int hari, double total) {
        System.out.println("Kendaraan   : " + k.getNamaKendaraan() + " (" + k.getJenis() + ")");
        System.out.println("Lama sewa   : " + hari + " hari");
        System.out.println(String.format("Total biaya : Rp %,.2f", total));
    }

    public void tampilkanHasilBiaya(KendaraanTambang k, int hari, double diskon, double total) {
        System.out.println("Kendaraan   : " + k.getNamaKendaraan() + " (" + k.getJenis() + ")");
        System.out.println("Lama sewa   : " + hari + " hari");
        System.out.println("Diskon      : " + diskon + "%");
        System.out.println(String.format("Total biaya : Rp %,.2f", total));
    }

    public String bacaStringTidakKosong(String pesan) {
        String input;
        while (true) {
            System.out.print(pesan);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("Input tidak boleh kosong. Silakan ulangi.");
        }
        return input;
    }

    public double bacaDoublePositif(String pesan) {
        double nilai = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            try {
                nilai = Double.parseDouble(input);
                if (nilai > 0) {
                    valid = true;
                } else {
                    System.out.println("Nilai harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
        return nilai;
    }

    public int bacaIntRentang(String pesan, int min, int max) {
        int nilai = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            try {
                nilai = Integer.parseInt(input);
                if (nilai >= min && nilai <= max) {
                    valid = true;
                } else {
                    System.out.println("Pilihan harus antara " + min + " sampai " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka bulat.");
            }
        }
        return nilai;
    }

    public boolean bacaYaTidak(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            }
            if (input.equals("n")) {
                return false;
            }
            System.out.println("Ketik y atau n.");
        }
    }
}
