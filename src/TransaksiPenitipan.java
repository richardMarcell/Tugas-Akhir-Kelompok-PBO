import java.time.LocalDateTime;

class TransaksiPenitipan {
    String no_transaksi;
    LocalDateTime waktu_masuk;
    LocalDateTime waktu_keluar;
    boolean is_done;

    void laporMasuk(String no_transaksi, String nama) {
        this.no_transaksi = no_transaksi;
        this.waktu_masuk = LocalDateTime.now();
        System.out.println("Customer " + nama + " memasukkan helm dengan nomor transaksi " + no_transaksi);
    }

    void laporKeluar() {
        this.waktu_keluar = LocalDateTime.now();
        this.is_done = true;
        System.out.println("Helm dengan nomor transaksi " + no_transaksi + " telah dikeluarkan");
    }
}