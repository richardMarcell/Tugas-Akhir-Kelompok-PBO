/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ACER
 */
import java.time.Duration;
import java.time.LocalDateTime;

class DetailTransaksiPenitipan {
    int durasi_penitipan;
    double tagihan;

    void hitungTagihan(LocalDateTime waktu_masuk, LocalDateTime waktu_keluar) {
        Duration selisih = Duration.between(waktu_masuk, waktu_keluar);
        long selisihJam = selisih.toHours();
        selisihJam = Math.max(1, selisihJam);

        tagihan = selisihJam * 2000;

        System.out.println("Total Tagihan : Rp" + tagihan);
    }
}
