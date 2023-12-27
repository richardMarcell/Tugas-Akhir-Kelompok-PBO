import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        TransaksiPenitipan transaksi = new TransaksiPenitipan();
        DetailTagihanPenitipan detailTagihan = new DetailTagihanPenitipan();
        Loker loker = new Loker();

        while (true) {
            System.out.println("=============================");
            System.out.println("Aplikasi Penitipan Helm");
            System.out.println("=============================");
            System.out.println("Pilih menu berikut: ");
            System.out.println("1. Tambah Customer"); //Done
            System.out.println("2. Cek Ketersediaan Loker"); //Done
            System.out.println("3. Tambah Transaksi");
            System.out.println("4. Cetak Tagihan");
            System.out.println("5. Pengambilan Helm");
            System.out.println("6. Tampilkan Daftar Customer"); //Done
            System.out.println("7. Keluar"); //Done
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
                            transaksi.laporMasuk(nomorTransaksi, selectedCustomer.nama);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;
                case 4:
                    detailTagihan.hitungTagihan(transaksi.waktu_masuk, transaksi.waktu_keluar);
                    System.out.println("Durasi penitipan: " + detailTagihan.durasi_penitipan + " Detik");
                    System.out.println("Tagihan: Rp" + detailTagihan.tagihan);
                    break;
                case 5:
                    transaksi.laporKeluar();
                    break;
                case 6:
                    if (customers.isEmpty()) {
                        System.out.println("Belum ada customer terdaftar.");
                    } else {
                        System.out.println("Daftar Customer:");
                        for (Customer c : customers) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}