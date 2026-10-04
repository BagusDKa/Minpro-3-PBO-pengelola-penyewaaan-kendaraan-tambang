# Minpro-3-PBO-pengelola-penyewaaan-kendaraan-tambang
Abstraction KendaraanTambang kini punya 3 abstract method: getJenis(), getDetail(), dan hitungBiayaSewa(int hari).
Overriding DumpTruck dan Excavator menimpa hitungBiayaSewa(int) dengan rumus berbeda.
Overloading hitungBiayaSewa(int hari) dan hitungBiayaSewa(int hari, double diskonPersen) memiliki nama sama dengan parameter berbeda.
Polymorphism controller memanggil kendaraan.hitungBiayaSewa(...) lewat tipe KendaraanTambang, dan Java memilih rumus sesuai objek aslinya.
MVC semua Scanner dan println dipindah ke View, PengelolaKendaraan di Model hanya mengurus data, dan Controller mengatur alurnya.
