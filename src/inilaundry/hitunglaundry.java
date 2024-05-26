package inilaundry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hitunglaundry {

    private double HARGA_PAKET, HARGA_CUCIAN;
    private double jumlahBayar, jumlahCucian, hargaTotal, sisaBayar;
    private String jenisPaket, jenisCucian, metodeBayar;
    String sql;

    Statement stat;
    ResultSet rs;

    public String getMetodebayar() {
        return metodeBayar;
    }

    public void setMetodebayar(String metodebayar) {
        this.metodeBayar = metodebayar;
    }

    public double getJumlahCucian() {
        return jumlahCucian;
    }

    public void setJumlahCucian(double jumlahCucian) {
        this.jumlahCucian = jumlahCucian;
    }

    public String getJenisCucian() {
        return jenisCucian;
    }

    public void setJenisCucian(String jenisCucian) {
        this.jenisCucian = jenisCucian;
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
    }

    public double getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(double jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public double getHargaTotal() {
        try {
            koneksi db = new koneksi();
            db.config();
            stat = db.stm;
            sql = "SELECT FEE FROM SERVICE_FEE WHERE SERVICE = '" + this.jenisPaket + "'";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                this.HARGA_PAKET = rs.getDouble("FEE");
            }
            
            sql = "SELECT FEE FROM SERVICE_FEE WHERE SERVICE = '" + this.jenisCucian + "'";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                this.HARGA_CUCIAN = rs.getDouble("FEE");
            }
            
            this.hargaTotal = this.HARGA_PAKET + (this.HARGA_CUCIAN * this.jumlahCucian);
            
            return hargaTotal;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public double getSisaBayar() {
        switch (metodeBayar) {
            case "Lunas":
                if (this.jumlahBayar >= this.hargaTotal) {
                    this.sisaBayar = this.jumlahBayar - this.hargaTotal;
                } else if (this.jumlahBayar < this.hargaTotal) {
                    this.sisaBayar = this.jumlahBayar - this.hargaTotal;
                }
                break;
            case "Bon":
                if (this.jumlahBayar >= this.hargaTotal) {
                    this.sisaBayar = this.jumlahBayar - this.hargaTotal;
                } else if (this.jumlahBayar >= this.hargaTotal * 30 / 100 && this.jumlahBayar <= this.hargaTotal) {
                    this.sisaBayar = this.hargaTotal - this.jumlahBayar;
                }
                break;
        }
        return sisaBayar;
    }
}
