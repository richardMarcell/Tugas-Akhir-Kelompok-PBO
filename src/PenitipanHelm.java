/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author ACER
 */
import java.util.List; // Mengimpor kelas List dari paket java.util agar dapat menggunakan list dalam kelas ini
import java.util.Scanner; // Mengimpor kelas Scanner dari paket java.util agar dapat mengambil input dari user melalui console
import java.util.stream.Collectors;
import java.io.Console; // Mengimpor kelas Console dari java.io agar console dapat berinteraksi dengan terminal atau konsol ketika kode sedang dijalankan
import java.util.ArrayList; // Mengimpor kelas ArrayList dari java.util sebagai bentuk impementasi dari List, dapat menyimpan berbagai elemen didalamnya, memudahkan proses pencarian, penambahan, dan penghapusan data-data didalamnya
public class PenitipanHelm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek scanner dari kelas Scanner agar dapat mengambil input dari user
        List<Customer> customers = new ArrayList<>(); // Membuat sebuah list yang berisi objek-objek Customer
        List<TransaksiPenitipan> listTransaksiPenitipan = new ArrayList<>(); // Membuat sebuah list yang berisi objek-objek TransaksiPenitipan
        Admin admin = new Admin(); // Membuat objek admin dari kelas Admin

        Loker loker = new Loker(); // Membuat objek loker dari kelas Loker
        Console console = System.console(); // Untuk mendapatkan objek dari kelas Console

        if (console == null) {
            System.out.println("Console tidak tersedia!"); // Pesan jika Console tidak bekerja atau tidak tersedia
            System.exit(1); // Mengakhiri program dengan status 1 yaitu berakhir karena kesalahan atau kondisi tidak normal
        }

        boolean isAuthenticated = false; // Autentifikasi di set false dari awal agar program dapat dijalankan setelah login berhasil

        // Fungsi loop untuk mekakukan login, menggunakan loop agar ketika user salah menginputkan kredential maka bisa kembali menginputkan kredential
        while (!isAuthenticated) {
            System.out.println("=============================");
            System.out.println("-----------=Login=-----------");
            System.out.println("=============================");
            System.out.print("Username: ");
            String usernameInput = scanner.nextLine(); //Input username
            String passwordInput = new String(console.readPassword("Password: ")); //Input password


            isAuthenticated = admin.login(usernameInput, passwordInput); //memanggil method login di kelas admin yang mana akan mengembalikan nilai true dan false

            //Mengecek apakah user sudah terutentikasi, jika true maka user akan langsung masuk ke aplikasi, jika false maka user akan kembali menginputkan kredential
            if (!isAuthenticated) {
                System.out.println("Kredential Yang Anda Masukkan Tidak Valid");
                System.out.println();
                System.out.println();
                System.out.println();
            }
        }
        System.out.println("Anda Berhasil Melakukan Autentikasi");
        System.out.println();
        System.out.println();
        System.out.println();

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
            int choice = scanner.nextInt(); // Mengambil input customer dan menjadi nilai dari variabel choice
            System.out.println();
            System.out.println();
            System.out.println();

            switch (choice) {
                case 1: // Jika choice bernilai 1, maka akan menjalankan metode tambah customer
                    Customer customer = new Customer(); // membuat objek customer baru
                    scanner.nextLine(); // Consume newline

                    // Meminta data dari admin melalui input di terminal atau console terkait ID Customer, Nama Customer, dan Nomor HP Customer
                    System.out.print("ID Customer: ");
                    String idCustomer = scanner.nextLine();
                    System.out.print("Nama customer: ");
                    String namaCustomer = scanner.nextLine();
                    System.out.print("Nomor HP customer: ");
                    String nomorHP = scanner.nextLine();
                    customer.register(idCustomer, namaCustomer, nomorHP);
                    customers.add(customer);
                    System.out.println("Berhasil Menambah Customer dengan nama " + namaCustomer); // Pesan berhasil menambah customer baru
                    System.out.println();
                    System.out.println();
                    break;
                case 2: // Jika choice bernilai 2, maka akan menjalankan metode cek ketersediaan loker
                loker.cekLoker(); // Menjalankan metode cekLoker dari objek loker yang telah dibuat di awal
                System.out.println();
                System.out.println();
                break;
                case 3: // // Jika choice bernilai 3, maka akan menjalankan metode tambah transaksi penitipan
                    TransaksiPenitipan transaksi = new TransaksiPenitipan(); // Membuat objek transaksi penitipan baru
                    if (customers.isEmpty()) { // Mengecek apakah dalam sistem ada objek customer yang telah dibuat atau belum
                        System.out.println("Belum ada customer terdaftar.");
                    } else {
                        // Memasukkan nomor Transaksi dari input admin
                        System.out.print("Nomor transaksi: ");
                        scanner.nextLine(); // Consume newline
                        String nomorTransaksi = scanner.nextLine();

                        // Sistem akan menampilkan semua objek customer, admin diminta untuk memilih customer yang ingin melakukan penitipan helm
                        System.out.println("Pilih customer:");
                        for (int i = 0; i < customers.size(); i++) { // Loop untuk menampilkan seluruh data customer yang terdata di sistem
                            System.out.println((i + 1) + ". " + customers.get(i).nama); // customers.get(i).nama adalah mengambil nilai nama dari objek customer yang didapat
                        }

                        System.out.print("Pilihan Anda: "); // Memilih customer yang ingin melakukan penitipan helm dengan input angka
                        int customerChoice = scanner.nextInt();
                        if (customerChoice > 0 && customerChoice <= customers.size()) {
                            Customer selectedCustomer = customers.get(customerChoice - 1);
                            listTransaksiPenitipan.add(transaksi); // Menambahkan objek transaksi baru ke dalam list
                            transaksi.laporMasuk(nomorTransaksi, selectedCustomer.nama); // Menjalankan metode laporMasuk dari objek transaksi
                            loker.simpanHelm(nomorTransaksi); // Menjalankan metode simpanHelm dari objek loker
                        } else {
                            System.out.println("Pilihan tidak valid."); // Pesan kesalahan ketika admin memasukkan input yang tidak valid
                        }
                    }
                    System.out.println();
                    System.out.println();
                    break;
                case 4: // Jika choice bernilai 4, maka akan menjalankan metode cetak tagihan
                    boolean pilihanTersedia = false;

                    // melakuan filter terhadap list transaksi yang mana hanya mengambil data transaksi yang memilki status belum selesai atau status_selesai == false dengan function stream() dari Java List
                    List<TransaksiPenitipan> listTransaksiPenitipanBelumSelesai = listTransaksiPenitipan.stream().filter(transaksiPenitipan -> transaksiPenitipan.status_selesai == false).collect(Collectors.toList()); // Membuat sebuah list yang berisi objek-objek TransaksiPenitipan
                    if (!listTransaksiPenitipan.isEmpty()) { // Mengecek isi dari list transaksi penitipan
                        // Meminta admin untuk memilih transaksi penitipan aktif yang ingin di akhiri dan dilakukan pencetakan tagihan
                        System.out.println("Pilih Transaksi:");
                        for (int i = 0; i < listTransaksiPenitipan.size(); i++) { // Loop untuk menampilkan seluruh objek transaksi
                            pilihanTersedia = true;
                            if(listTransaksiPenitipan.get(i).status_selesai == false){ // Memilih agar objek transaksi yang ditampilkan hanya yang belum selesai
                                System.out.println((i + 1) + ". " + listTransaksiPenitipan.get(i).no_transaksi + " - " + listTransaksiPenitipan.get(i).nama );
                            }
                        }

                        if(listTransaksiPenitipanBelumSelesai.size() < 1) {
                            System.out.println("Tidak ada transaksi yang aktif");
                            System.out.println();
                            System.out.println();
                        }
                    } else {
                        System.out.println("Transaksi Kosong."); // Pesan jika tidak ada transaksi sama sekali dalam list
                        System.out.println();
                        System.out.println();
                        break;
                    }

                    if(pilihanTersedia == true) {
                        System.out.print("Pilihan Anda: ");
                        int transaksiPenitipanChoice = scanner.nextInt();
                        if (transaksiPenitipanChoice > 0 && transaksiPenitipanChoice <= listTransaksiPenitipan.size()) {
                            TransaksiPenitipan selectedTransaksiPenitipan = listTransaksiPenitipan.get(transaksiPenitipanChoice - 1); // Membuat objek selectedTransaksiPenitipan dari kelas TransaksiPenitipan dengan nilai dari objek yang dipilih oleh admin
                            loker.ambilHelm(selectedTransaksiPenitipan.no_transaksi); // Menjalankan metode ambilHelm dari objek loker

                            // Mengeluarkan output tagihan
                            System.out.println("Tagihan");
                            System.out.println("=============================");
                            System.out.println("Nama : " + selectedTransaksiPenitipan.nama);
                            System.out.println("Nomor Transaksi : " + selectedTransaksiPenitipan.no_transaksi);
                            selectedTransaksiPenitipan.laporKeluar(); // Menjalankan metode laporKeluar dari objek selectedTransaksiPenitipan
//                            listTransaksiPenitipan.remove(selectedTransaksiPenitipan);

                        } else {
                            System.out.println("Pilihan tidak valid."); // Pesan jika input admin tidak valid
                        }
                    }
                    System.out.println();
                    System.out.println();
                    break;
                case 5: // Jika choice bernilai 5, maka akan menjalankan metode tampilkan data customer
                    if (customers.isEmpty()) {
                        System.out.println("Belum ada customer terdaftar."); // Pesan jika di dalam list tidak ada objek customer
                    } else {
                        System.out.println("Daftar Customer:");
                        for (Customer c : customers) { // Mengeluarkan semua objek dari list ke terminal atau console menggunakan for
                            System.out.println(c);
                        }
                    }
                    System.out.println();
                    System.out.println();
                    break;
                case 6: // Jika choice bernilai 6, maka akan menjalankan metode Exit atau mengakhiri sistem penitipan helm
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid."); // Pesan kesalahan
            }
        }
    }
}
