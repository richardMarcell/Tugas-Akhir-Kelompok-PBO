/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ACER
 */
class Loker {

    String[] loker = {"Tersedia", "Tersedia", "Tersedia", "Tersedia", "Tersedia"};

    public void cekLoker()
    {
        System.out.println("\n");
        System.out.println("Daftar Loker");
        System.out.println("===============================");
        for (int i = 0; i < 5; i++) {
            String status;

            if("Tersedia".equals(loker[i])) {
                status = "Tersedia";
        } else {
            status = "Terisi";
        }

        System.out.println("Loker " + (i + 1) + ": " + status);
    }
        System.out.println("\n");
    }

    void simpanHelm(String no_transaksi){
        for (int i = 0; i < 5; i++) {
            if("Tersedia".equals(loker[i])) {
                loker[i] = no_transaksi;
                int no_loker = i+1;
                System.out.println("Transaksi " + no_transaksi + " berhasil ditambah pada loker nomor " + no_loker);
                break;
            } else {
                System.out.println("Loker tidak tersedia");
            }
        }
    }

    void ambilHelm(String no_transaksi){
        for (int i = 0; i < 5; i++) {
            if(no_transaksi.equals(loker[i])) {
                loker[i] = "Tersedia";
                int no_loker = i+1;
                System.out.println("Helm dengan nomor transaksi " + no_transaksi + " berhasil diambil pada loker nomor - " + no_loker);
                break;
            }
        }
    }

}

