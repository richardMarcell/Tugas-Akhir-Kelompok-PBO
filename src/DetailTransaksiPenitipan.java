/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ACER
 */
import java.time.Duration; // Mengimpor kelas Duration yang merupakan bagian dari paket java.time agar dapat menghitung selisih waktu
import java.time.LocalDateTime; // Mengimpor kelas LocalDateTime yang merupakan bagian dari paket java.time agar dapat nilai waktu terkini saat code dijalankan

class DetailTransaksiPenitipan {
    // Atribut kelas DetailTransaksiPenitipan
    int durasi_penitipan;
    double tagihan;

    // Metode hitungTagihan, untuk menghitung tagihan yang harus dibayarkan oleh customer
    void hitungTagihan(LocalDateTime waktu_masuk, LocalDateTime waktu_keluar) {
        Duration selisih = Duration.between(waktu_masuk, waktu_keluar); // Menghitung selisih waktu masuk dan waktu keluar customer
        long selisihJam = selisih.toHours(); // Karena LocalDateTime adalah data waktu yang lengkap dengan menit dan detik, maka di convert ke jam agar memudahkan perhitungan
        selisihJam = Math.max(1, selisihJam); // Ada kemungkinan selisih waktu kurang dari 1 jam, maka dari itu disetting minimal nilainya adalah 1 jam

        tagihan = selisihJam * 2000; // Harga penitipan adalah Rp2,000 per jam

        System.out.println("Total Tagihan : Rp" + tagihan);
    }
}
