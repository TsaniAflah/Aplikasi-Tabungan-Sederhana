import java.util.Scanner;

public class Tabungan {
    private String nama;
    private long noRekening;
    private double saldo ;
    private double saldo_minimum;
    private double setoran_minimum;
    private double simpanUang;
    private double tarikUang;

    public Tabungan()
    {

    }

    public Tabungan(String nama, long noRekening, double saldo, double saldo_minimum, double setoran_minimum)
    {
        this.nama = nama;
        this.noRekening = noRekening;
        this.saldo = 0;
        this.saldo_minimum = 0;
        this.setoran_minimum = 0;
    }

    protected void setSaldoMinimum (double saldo_minimum)
    {
        this.saldo_minimum = saldo_minimum;
    }

    protected void setSetoran_minimum (double setoran_minimum)
    {
        this.setoran_minimum = setoran_minimum;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public void simpanUang (double uang)
    {
        try (Scanner setor = new Scanner(System.in)) {
            System.out.println("AKUN ATAS NAMA : " + this.nama);
            Scanner noRek = new Scanner(System.in);
            System.out.print("MASUKKAN NOMOR REKENING ANDA :");
            noRekening = noRek.nextLong();
            System.out.println("SALDO SAAT INI : Rp." +saldo);
            if (uang >= 50.000){
                System.out.print("MEMASUKKAN SETORAN SEBESAR : Rp.");
                uang = setor.nextDouble();
                saldo += uang;
                System.out.println("SETORAN SEBESAR Rp." +uang+" DISIMPAN");
                System.out.println("SALDO SAAT INI : Rp." +saldo);
            }else {
                System.out.println("TIDAK BISA MENYETOR. TIDAK MENCUKUPI MINIMUM SETOR");
            }
        }
    }

    public void tarikUang (double jumlahPenarikan)
    {
        try (Scanner tarik = new Scanner(System.in)) {
            System.out.println("AKUN ATAS NAMA : " +this.nama);
            Scanner noRek = new Scanner(System.in);
            System.out.print("MASUKKAN NOMOR REKENING ANDA :");
            noRekening = noRek.nextLong();
            while(jumlahPenarikan > 0){
                if (jumlahPenarikan < saldo && saldo-jumlahPenarikan >= saldo_minimum){
                    System.out.println("SALDO SAAT INI : Rp." +saldo);
                    System.out.println("MENARIK SALDO SEBESAR : Rp.");
                    jumlahPenarikan = tarik.nextDouble();
                    saldo -= jumlahPenarikan;
                    System.out.println("PENARIKAN SEBESAR Rp." +jumlahPenarikan);
                    System.out.println("SALDO SAAI INI : Rp." +saldo);
                }else{
                    System.out.println("PERIKSA KEMBALI JUMLAH PENARIKAN DAN SALDO ANDA");
                }
            }
        }
    }

}

class Simpanan extends Tabungan{
    private double SALDO_AWAL_MINIMUM = 500.000;
    private double SALDO_MINIMUM = 10.000;
    private double SETORAN_MINIMUM = 50.000;

    public Simpanan (String nama, long noRek, double saldoAwal)
    {
        super.setSaldoMinimum(SALDO_MINIMUM);
        super.setSetoran_minimum(SETORAN_MINIMUM);
        if (saldoAwal>=SALDO_AWAL_MINIMUM) {
            super.setSaldo(SALDO_AWAL_MINIMUM);
            System.out.println("SALDO AWAL ANDA Rp." + super.getSaldo());
        }else {
            System.out.println("SALDO AWAL ANDA TIDAK MEMENUHI SALDO AWAL MINIMUM");
        }
    }
}


class Junior extends Tabungan{
    private double SALDO_AWAL_MINIMUM = 50.000;
    private double SALDO_MINIMUM = 10.000;
    private double SETORAN_MINIMUM = 50.000;
    private double MAKS_TARIKAN_PER_HARI = 1000.000;

    public Junior(String nama, long noRek, double saldoAwal)
    {
        super.setSaldoMinimum(SALDO_MINIMUM);
        super.setSetoran_minimum(SETORAN_MINIMUM);
        if (saldoAwal>=SALDO_AWAL_MINIMUM) {
            super.setSaldo(SALDO_AWAL_MINIMUM);
            System.out.println("SALDO AWAL ANDA Rp." + super.getSaldo());
        }else {
            System.out.println("SALDO AWAL ANDA TIDAK MEMENUHI SALDO AWAL MINIMUM");
        }
    }

    @Override
    public void tarikUang(double jumlahPenarikan)
    {
        Scanner tarik = new Scanner(System.in);
        System.out.print("MASUKKAN NOMIMAL PENARIKAN : ");
        jumlahPenarikan = tarik.nextDouble();
        if (jumlahPenarikan <= MAKS_TARIKAN_PER_HARI){
            super.tarikUang(jumlahPenarikan);
        } else {
            System.out.println("TIDAK DAPAT MENARIK UANG. JUMLAH PENARIKAN MELEBIHI MAKSIMAL JUMLAH PENARIKAN PER-HARI!");
        }
    }
}

class TestTabungan
{
    private boolean mulai;
    private String jawaban;

    public TestTabungan()
    {

    }

    public boolean getMulai()
    {
        if(this.jawaban.equalsIgnoreCase("y"))
        {
            this.mulai = true;
        }
        return this.mulai;
    }

    public void setMulai(boolean mulai)
    {
        this.mulai = mulai;
    }

    public static void main(String[] args)
    {
        String nama;
        long noRek;
        double saldoAwal;
        boolean condition = true;

        while (condition)
        {
            Tabungan classTabungan = new Tabungan();
            //Simpanan classSimpanan = new Simpanan();
            //Junior classJunior = new Junior();

            System.out.println("\n ");

        }
    }

}
