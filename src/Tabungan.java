import java.util.Scanner;

public abstract class Tabungan {
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

    public void setNama(String nama)
    {
        this.nama=nama;
    }

    public void setNoRekening(long noRekening)
    {
        this.noRekening=noRekening;
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
        Scanner setor = new Scanner(System.in);
        try {
            System.out.println("AKUN ATAS NAMA : " + this.nama);
            System.out.println("DENGAN NOMOR REKENING " + this.noRekening);
            System.out.println("SALDO SAAT INI : Rp." + saldo);
            System.out.print("MEMASUKKAN SETORAN SEBESAR : Rp.");
            uang = setor.nextDouble();
            if (uang >= 50.000) {
                System.out.println("SETORAN SEBESAR Rp." + uang + " DISIMPAN");
                saldo += uang;
                System.out.println("SALDO SAAT INI : Rp." + saldo);
            } else {
                System.out.println("TIDAK BISA MENYETOR. TIDAK MENCUKUPI MINIMUM SETOR");
            }
        } catch (Exception e){
            System.out.println("EROR!");
        } finally {

        }
    }

    public void tarikUang (double jumlahPenarikan)
    {
        Scanner tarik = new Scanner(System.in);
        try {
            System.out.println("AKUN ATAS NAMA : " + this.nama);
            System.out.println("DENGAN NOMOR REKENING " + this.noRekening);
            System.out.println("SALDO SAAT INI : Rp." + saldo);
            System.out.print("MENARIK SALDO SEBESAR : Rp.");
            jumlahPenarikan = tarik.nextDouble();
            while (jumlahPenarikan > 0) {
                if (jumlahPenarikan < saldo && saldo - jumlahPenarikan >= saldo_minimum) {
                    saldo -= jumlahPenarikan;
                    System.out.println("SALDO SAAT INI : Rp." + saldo);
                    System.out.println("PENARIKAN SEBESAR Rp." + jumlahPenarikan);
                    System.out.println("SALDO SAAI INI : Rp." + saldo);
                } else {
                    System.out.println("PERIKSA KEMBALI JUMLAH PENARIKAN DAN SALDO ANDA");
                }break;
            }
        } catch (Exception e){
            System.out.println("EROR!");
        } finally {
        }
    }
}

class Simpanan extends Tabungan{
    private double SALDO_AWAL_MINIMUM = 500000;
    private double SALDO_MINIMUM = 10000;
    private double SETORAN_MINIMUM = 50000;
    private String nama;
    private long noRekening;

    public Simpanan()
    {

    }

    public void Simpanan (String nama, long noRek, double saldoAwal)
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
    private double SALDO_AWAL_MINIMUM = 50000;
    private double SALDO_MINIMUM = 10000;
    private double SETORAN_MINIMUM = 50000;
    private double MAKS_TARIKAN_PER_HARI = 1000000;

    public Junior()
    {

    }

    public void Junior(double saldoAwal)
    {
        super.setSaldoMinimum(SALDO_MINIMUM);
        System.out.println("SALDO MINIMUM : " +SALDO_MINIMUM);
        super.setSetoran_minimum(SETORAN_MINIMUM);
        System.out.println("SETORAN MINIMUM : " +SETORAN_MINIMUM);
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
        //Scanner tarik = new Scanner(System.in);
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
    private String pernyataan;

    public TestTabungan()
    {

    }

    public boolean getMulai()
    {
        if(this.pernyataan.equalsIgnoreCase("y"))
        {
            this.mulai = true;
        }
        return this.mulai;
    }

    public void setMulai(String pernyataan)
    {
        this.pernyataan = pernyataan;
    }

    public static void main(String[] args)
    {
        String nama;
        long noRekening;
        double saldo;
        double saldoAwal = 0.0;
        double uang = 0.0;
        double jumlahPenarikan = 0.0;
        String pernyataan;
        Scanner ulang = new Scanner(System.in);
        Scanner noRek = new Scanner(System.in);
        Scanner snama = new Scanner(System.in);
        Scanner sSaldo = new Scanner(System.in);
        Scanner menu = new Scanner(System.in);
        Scanner menuTabungan = new Scanner(System.in);
        Scanner menuJunior = new Scanner(System.in);
        boolean condition = true;
        
        Simpanan classSimpanan = new Simpanan();
        Junior classJunior = new Junior();
        TestTabungan classTest = new TestTabungan();

        while (condition)
        {
            System.out.println("..............SELAMAT DATANG DI APLIKASI TABUNGAN SEDERHANA..............");

            System.out.print("MASUKKAN NAMA ANDA : ");
            nama = snama.nextLine();
            classTabungan.setNama(nama);

            System.out.print("MASUKKAN NOMOR REKENING ANDA :");
            noRekening = noRek.nextLong();
            classTabungan.setNoRekening(noRekening);
//
            System.out.println("\t================MENU================");
            System.out.println("PILIH STATUS");
            System.out.println("1. TABUNGAN");
            System.out.println("2. SIMPANAN");
            System.out.println("3. JUNIOR");
            System.out.print("PILIHAN : ");
            String pilihan = menu.nextLine();
            System.out.println("------------------------------------");
            switch (pilihan){
                case "1" -> {
                    System.out.println("STATUS          : TABUNGAN");
                    System.out.println("PILIH TINDAKAN  : ");
                    System.out.println("1. SIMPAN UANG");
                    System.out.println("2. TARIK UANG");
                    System.out.print("PILIHAN : ");
                    String pilihan1 = menuTabungan.nextLine();
                    System.out.println("------------------------------------");
                    switch (pilihan1){
                        case "1" -> {
                            System.out.println("SIMPAN UANG");
                            classTabungan.simpanUang(uang);
                        }case "2" -> {
                            System.out.println("TARIK UANG");
                            classTabungan.tarikUang(jumlahPenarikan);
                        }default-> System.out.println("INPUT SALAH, SILAHKAN ULANGI");
                    }
                }case "2" -> {
                    System.out.println("STATUS          : SIMPANAN");
                    System.out.println("PEMERIKSAAN AKUN");
                    classSimpanan.simpanUang(uang);
                }case "3" -> {
                    System.out.println("STATUS          : JUNIOR");
                    System.out.println("PILIH TINDAKAN  : ");
                    System.out.println("1. PEMERIKSAAN AKUN");
                    System.out.println("2. TARIK UANG");
                    System.out.print("PILIHAN : ");
                    String pilihan2 = menuJunior.nextLine();
                    System.out.println("------------------------------------");
                    switch (pilihan2){
                        case "1" -> {
                            System.out.println("PEMERIKSAAN AKUN");
                            classJunior.Junior(saldoAwal);
                        }case "2" -> {
                            System.out.println("PEMERIKSAAN AKUN");
                            classJunior.tarikUang(jumlahPenarikan);
                        }default-> System.out.println("INPUT SALAH, SILAHKAN ULANGI");
                    }
                }
            }
            System.out.println("\t================KEMBALI KE MENU UTAMA?================");
            System.out.println("KETIK 'y' UNTUK KEMBALI KE MENU AWAL");
            System.out.println("KETIK 'q' UNTUK KELUAR");
            pernyataan = ulang.nextLine();
            System.out.println("\t======================================================");
            if (pernyataan.equalsIgnoreCase("y"))
            {
                classTest.setMulai("y");
            }else{
                classTest.setMulai("q");
            }

            if (classTest.getMulai()==true)
            {
                condition = true;
            }else {
                condition = false;
            }
        }
    }
}
