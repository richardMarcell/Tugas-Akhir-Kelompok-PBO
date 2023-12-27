import java.time.Duration;
import java.time.LocalDateTime;

class DetailTagihanPenitipan {
    int durasi_penitipan;
    double tagihan;

    void hitungTagihan(LocalDateTime waktu_masuk, LocalDateTime waktu_keluar) {
        Duration durasi = Duration.between(waktu_masuk, waktu_keluar);
        durasi_penitipan = (int) durasi.toSecondsPart();
        tagihan = durasi_penitipan * 2000;
    }
}