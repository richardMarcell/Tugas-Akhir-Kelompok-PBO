/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ACER
 */
class Loker {
    // Atribut kelas Loker
    String[] loker = {"Tersedia", "Tersedia", "Tersedia", "Tersedia", "Tersedia"}; // Array ini digunakan untuk melambangkan loker dengan 5 slot atau penyimpanan yang dapat menampung maksimal 5 helm

    // Metode cekLoker, untuk mengecek ketersediaan loker, sistem akan mengeluarkan ouput nomor loker dan status ketersediaan loker (Tersedia atau Terisi)
    public void cekLoker()
    {
        System.out.println("\n");
        System.out.println("Daftar Loker");
        System.out.println("===============================");
        for (int i = 0; i < 5; i++) { // Loop yang digunakan untuk melakukan pengulangan sebanyak 5 kali sesuai dengan jumlah maksimal slot loker
            String status;

            if("Tersedia".equals(loker[i])) { // Mengecek apakah loker urutan i bernilai "Tersedia" atau tidak, jika iya maka status yang ditampilkan "Tersedia", jika tidak maka "Terisi"
                status = "Tersedia";
        } else {
            status = "Terisi";
        }

        System.out.println("Loker " + (i + 1) + ": " + status); // Menghasilkan output nomor loker beserta status
    }
        System.out.println("\n");
    }

    // Metode simpanHelm, digunakan ketika menambah transaksiPenitipan, nilai array pada i yang awalnya "Tersedia" akan diganti menjadi nomor transaksi yang diinput oleh admin
    void simpanHelm(String no_transaksi){
        for (int i = 0; i < 5; i++) {
            if("Tersedia".equals(loker[i])) { // Mencari nomor loker yang memiliki status "Tersedia"
                loker[i] = no_transaksi;
                int no_loker = i+1;
                System.out.println("Transaksi " + no_transaksi + " berhasil ditambah pada loker nomor " + no_loker); // Pesan sukses 
                break;
            } else {
                System.out.println("Loker tidak tersedia"); // Pesan jika loker nomor 1 sampai 5 penuh
            }
        }
    }

    // Metode ambilHelm, digunakan ketika customer ingin mengambil helm yang telah dititipkan
    void ambilHelm(String no_transaksi){
        for (int i = 0; i < 5; i++) {
            if(no_transaksi.equals(loker[i])) { // Mencari loker yang memiliki nilai sesuai dengan nomor transaksi yang dipilih
                loker[i] = "Tersedia"; // Nilai pada Array urutan ke i akan diubah menjadi "Tersedia" karena helm sudah diambil
                int no_loker = i+1;
                System.out.println("Helm dengan nomor transaksi " + no_transaksi + " berhasil diambil pada loker nomor - " + no_loker); // Pesan sukses
                break;
            } else {
                System.out.println("Terjadi kesalahan ketika ingin mengambil helm dengan nomor transaksi " + no_transaksi); // Pesan jika ada kesalahan dalam pengambilan helm
            }
        }
    }

}

