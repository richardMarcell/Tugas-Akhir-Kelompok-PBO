/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ACER
 */
class Customer {
    // Atribut kelas Customer
    String id_customer;
    String nama;
    String no_hp;

    // Metode Register, untuk penambahan data customer baru
    void register(String id_customer, String nama, String no_hp) {
        // Nilai yang berasal dari parameter yaitu id_customer, nama, dan no_hp menjadi nilai dari atribut kelas
        this.id_customer = id_customer;
        this.nama = nama;
        this.no_hp = no_hp;
    }

    // Menggunakan toString agar dapat merepresentasikan string dari objek Customer yaitu atribut kelas Customer
    @Override
    public String toString() {
        return "ID Customer: " + id_customer  + "\nNama: " + nama + "\nNo HP: " + no_hp + "\n";
    }
}
