/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author ACER
 */
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class PenitipanHelm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        List<TransaksiPenitipan> listTransaksiPenitipan = new ArrayList<>();

        Loker loker = new Loker();

        while (true) {
            System.out.println("=============================");
            System.out.println("Aplikasi Penitipan Helm");
            System.out.println("=============================");
            System.out.println("Pilih menu berikut: ");
            System.out.println("1. Tambah Customer");
            System.out.println("2. Cek Ketersediaan Loker");
            System.out.println("3. Tambah Transaksi");
            System.out.println("4. Cetak Tagihan");
            System.out.println("5. Tampilkan Daftar Customer");
            System.out.println("6. Keluar");
            System.out.println("=============================");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Customer customer = new Customer();
                    scanner.nextLine(); // Consume newline
                    System.out.print("ID Customer: ");
                    String idCustomer = scanner.nextLine();
                    System.out.print("Nama customer: ");
                    String namaCustomer = scanner.nextLine();
                    System.out.print("Nomor HP customer: ");
                    String nomorHP = scanner.nextLine();
                    customer.register(idCustomer, namaCustomer, nomorHP);
                    customers.add(customer);
                    System.out.println("Berhasil Menambah Customer dengan nama " + namaCustomer);
                    break;
                case 2:
                loker.checkLoker();
                    break;
                case 3:
                    TransaksiPenitipan transaksi = new TransaksiPenitipan();
                    if (customers.isEmpty()) {
                        System.out.println("Belum ada customer terdaftar.");
                    } else {
                        System.out.print("Nomor transaksi: ");
                        scanner.nextLine(); // Consume newline
                        String nomorTransaksi = scanner.nextLine();
                        System.out.println("Pilih customer:");
                        for (int i = 0; i < customers.size(); i++) {
                            System.out.println((i + 1) + ". " + customers.get(i).nama);
                        }

                        System.out.print("Pilihan Anda: ");
                        int customerChoice = scanner.nextInt();
                        if (customerChoice > 0 && customerChoice <= customers.size()) {
                            Customer selectedCustomer = customers.get(customerChoice - 1);
                            listTransaksiPenitipan.add(transaksi);
                            transaksi.laporMasuk(nomorTransaksi, selectedCustomer.nama);
                            loker.simpanHelm(nomorTransaksi);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;
                case 4:
                    boolean pilihanTersedia = false;
                    if (!listTransaksiPenitipan.isEmpty()) {

                        System.out.println("Pilih Transaksi:");
                        for (int i = 0; i < listTransaksiPenitipan.size(); i++) {
                            if(listTransaksiPenitipan.get(i).is_done == false){
                                pilihanTersedia = true;
                                System.out.println((i + 1) + ". " + listTransaksiPenitipan.get(i).no_transaksi + " - " + listTransaksiPenitipan.get(i).nama );
                            } else{
                                System.out.println("Belum ada Transaksi Aktif.");
                                break;
                            }

                    }} else {
                            System.out.println("Transaksi Kosong.");
                            break;
                        }
                        if(pilihanTersedia == true){
                        System.out.print("Pilihan Anda: ");
                        int transaksiPenitipanChoice = scanner.nextInt();
                        if (transaksiPenitipanChoice > 0 && transaksiPenitipanChoice <= listTransaksiPenitipan.size()) {
                            TransaksiPenitipan selectedTransaksiPenitipan = listTransaksiPenitipan.get(transaksiPenitipanChoice - 1);
                            loker.ambilHelm(selectedTransaksiPenitipan.no_transaksi);
                            System.out.println("Tagihan");
                            System.out.println("=============================");
                            System.out.println("Nama : " + selectedTransaksiPenitipan.nama);
                            System.out.println("Nomor Transaksi : " + selectedTransaksiPenitipan.no_transaksi);
                            selectedTransaksiPenitipan.laporKeluar();
//                            listTransaksiPenitipan.remove(selectedTransaksiPenitipan);

                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;
                case 5:
                    if (customers.isEmpty()) {
                        System.out.println("Belum ada customer terdaftar.");
                    } else {
                        System.out.println("Daftar Customer:");
                        for (Customer c : customers) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
