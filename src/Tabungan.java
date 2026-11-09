public class Tabungan extends Rekening implements BerBunga {

    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (saldo * bungaPersen / 100);
        saldo += bunga;
        return bunga;
    }

    @Override
    public int biayaAdminBulanan() {
        return saldo >= 1000000 ? 0 : 5000;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("      Tabungan, bunga " + bungaPersen + "% per bulan");
    }
}