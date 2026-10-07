# Minpro-3-PBO-pengelola-penyewaaan-kendaraan-tambang
kodenya dibagi 4 package model, view, controller, dan main. Class dan abstract method tetap sama hanya ditambah beberapa hal
Abstraction: KendaraanTambang mendapat abstract method baru hitungBiayaSewa(int hari).
Overriding: DumpTruck dan Excavator menghitung biaya sewa dengan cara berbeda, selain override getJenis(), getDetail(), dan toString().
Overloading: hitungBiayaSewa(int) dan hitungBiayaSewa(int, double) di KendaraanTambang, cari(String) dan cari(double, double) di PengelolaKendaraan, serta tampilkanPesan(String) dan tampilkanPesan(String, double) di KendaraanView.
MVC: semua System.out dan Scanner pindah ke View, alur menu ada di Controller, dan Model hanya berisi data
