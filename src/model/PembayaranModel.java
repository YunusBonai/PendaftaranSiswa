/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import connection.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 *
 * @author ACER
 */
public class PembayaranModel {
    private Database koneksi;
    private ResultSet rsPembayaran, rsNoPembayaran;
    private String query;
    private boolean status;
    private List<PembayaranModel> listPembayaran;
    
    
    public PembayaranModel() {
        koneksi = new Database();
        koneksi.getConn();
    }
    private String noPembayaran;
    private String TanggalPembayaran;
    private String namaSiswa;
    private String noIndukSiswa;
    private double totalPembayaran;
    private String keteranganPembayaran;

    public String getNoPembayaran() {
        return noPembayaran;
    }

    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }

    public String getTanggalPembayaran() {
        return TanggalPembayaran;
    }

    public void setTanggalPembayaran(String TanggalPembayaran) {
        this.TanggalPembayaran = TanggalPembayaran;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getNoIndukSiswa() {
        return noIndukSiswa;
    }

    public void setNoIndukSiswa(String noIndukSiswa) {
        this.noIndukSiswa = noIndukSiswa;
    }

    public String getKeteranganPembayaran() {
        return keteranganPembayaran;
    }

    public void setKeteranganPembayaran(String keteranganPembayaran) {
        this.keteranganPembayaran = keteranganPembayaran;
    }
    public boolean insertPembayaran(){
        query = "INSERT INTO pembayaran VALUES ('"+noPembayaran+"','"
                +keteranganPembayaran+"','"+noIndukSiswa+"','"
                +namaSiswa+"','"+totalPembayaran+"','"+TanggalPembayaran+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }
    public String buatNoPembayaran(String tanggal){
        int temp = 0;
        String no = "";
        query = "SELECT MAX(RIGHT(no_pembayaran,3) FROM pembayaran) "
                + "WHERE tanggal = '"+tanggal+"'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsNoPembayaran = koneksi.getRs();
            try {
                rsNoPembayaran.next();
                no = rsNoPembayaran.getString(1);
                if(no == null){
                    temp = 0;
                }else{
                    temp = Integer.parseInt(rsNoPembayaran.getString(1))+1;
                }
                rsNoPembayaran.close();
            } catch (SQLException se) {
                return null;
            }
        }
        String nopem = ""+temp;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        if(temp == 0){
            no = sdf.format(d) +"-" + "001";
        }else if(temp < 10){
            no = sdf.format(d) +"-00" + temp;
        }else if(temp < 100){
            no = sdf.format(d) +"-0" + temp;
        }else{
            no = sdf.format(d) +"-" + temp;
        }
        return no;
    }
    public boolean tampilPembayaran(){
        query = "Select * From pembayaran";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    public double getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }
    
    public static void main(String[] args) {
        System.out.println(new PembayaranModel().tampilPembayaran());
    }
}
