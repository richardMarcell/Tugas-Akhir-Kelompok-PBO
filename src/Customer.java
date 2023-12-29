/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ACER
 */
class Customer {
    String id_customer;
    String nama;
    String no_hp;

    void register(String id_customer, String nama, String no_hp) {
        this.id_customer = id_customer;
        this.nama = nama;
        this.no_hp = no_hp;
    }

    @Override
    public String toString() {
        return "ID Customer: " + id_customer  + "\nNama: " + nama + "\nNo HP: " + no_hp + "\n";
    }
}