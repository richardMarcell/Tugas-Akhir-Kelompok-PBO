/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
import java.time.LocalDateTime; // Mengimpor kelas LocalDateTime dari paket java.time agar dapat mengakses waktu aktual ketika code dijalankan
class TransaksiPenitipan {
    // Atribut kelas TransaksiPenitipan
    String nama;
    String no_transaksi;
    LocalDateTime waktu_masuk;
    LocalDateTime waktu_keluar;
    boolean status_selesai = false;
    DetailTransaksiPenitipan detailTransaksiPenitipan = new DetailTransaksiPenitipan(); // Membuat objek baru dari kelas DetailTransaksiPenitipan dan menetapkannya ke variabel detailTransaksiPenitipan

    // Metode laporMasuk, digunakan ketika ingin menambah transaksi penitipan
    void laporMasuk(String no_transaksi, String nama) {
        // Nilai dari atribut no_transaksi dan nama akan di set sesuai dengan input yang diberikan pada parameter
        this.nama = nama;
        this.no_transaksi = no_transaksi;
        this.waktu_masuk = LocalDateTime.now();
        System.out.println("Customer " + nama + " memasukkan helm dengan nomor transaksi " + no_transaksi); // Pesan berhasil memasukkan helm
    }

    // Metode laporKeluar, digunakan ketika ingin menyelesaikan transaksi penitipan
    void laporKeluar() {
        // Nilai dari waktu_keluar berasal dari waktu aktual ketika metode dijalankan dengan bantuan kelas LocalDateTime
        this.waktu_keluar = LocalDateTime.now();
        this.status_selesai = true; // Status transaksi penitipan menjadi true atau selesai

        System.out.println("Waktu masuk : " + waktu_masuk);
        System.out.println("Waktu keluar : " + waktu_keluar);

        detailTransaksiPenitipan.hitungTagihan(waktu_masuk, waktu_keluar); // Menjalankan metode hitungTagihan dari kelas detailTransaksiPenitipan



    }
}
