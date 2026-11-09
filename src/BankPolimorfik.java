public class BankPolimorfik {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        // Rekening r = new Rekening("999", "Eko", 0);
        // Pesan error: error: Rekening is abstract; cannot be instantiated
        // Sebabnya Rekening abstract dan punya method biayaAdminBulanan() yang belum
        // ada isinya, jadi tidak boleh dibuat object langsung. Harus lewat subclass
        // yang sudah melengkapi method itu (Tabungan atau Giro).

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) {
            r.cetakInfo();
        }

        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        for (Rekening r : semua) {
            System.out.println(r.getNomor() + " biaya admin  : " + Rekening.formatRupiah(r.potongBiayaAdmin()));
        }
        for (BerBunga b : berbunga) {
            System.out.println(b.getNomor() + " bunga        : " + Rekening.formatRupiah(b.tambahBunga()));
        }

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");
        for (Rekening r : semua) {
            r.cetakInfo();
        }
        System.out.println("-----------------------------------");

        int total = 0;
        for (Rekening r : semua) {
            total += r.getSaldo();
        }
        System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}