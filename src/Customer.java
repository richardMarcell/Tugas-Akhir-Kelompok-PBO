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