class Loker {

    String[] loker = {"Tersedia", "Tersedia", "Tersedia", "Tersedia", "Tersedia"};

    public void checkLoker()
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

    

}