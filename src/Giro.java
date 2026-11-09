public class Giro extends Rekening {

    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo + batasOverdraft) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15000;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("      Giro, batas overdraft " + formatRupiah(batasOverdraft));
    }
}