/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
import java.time.LocalDateTime;
class TransaksiPenitipan {
    String nama;
    String no_transaksi;
    LocalDateTime waktu_masuk;
    LocalDateTime waktu_keluar;
    boolean is_done = false;
    DetailTransaksiPenitipan detailTransaksiPenitipan = new DetailTransaksiPenitipan();

    void laporMasuk(String no_transaksi, String nama) {
        this.nama = nama;
        this.no_transaksi = no_transaksi;
        this.waktu_masuk = LocalDateTime.now();
        System.out.println("Customer " + nama + " memasukkan helm dengan nomor transaksi " + no_transaksi);
    }

    void laporKeluar() {
        this.waktu_keluar = LocalDateTime.now();
        this.is_done = true;

        System.out.println("Waktu masuk : " + waktu_masuk);
        System.out.println("Waktu keluar : " + waktu_keluar);

        detailTransaksiPenitipan.hitungTagihan(waktu_masuk, waktu_keluar);



    }
}
