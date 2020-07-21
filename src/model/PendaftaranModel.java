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
 * @author HENDRA
 */
public class PendaftaranModel {
    //1. Menentukan kebutuhan variabel
    private Database koneksi;
    private ResultSet rsPendaftaran, rsNoPendaftaran;
    private String query;
    private boolean status;
    private List<PendaftaranModel> listPendaftaran;

    //2. Membuat objek
    public PendaftaranModel() {
        koneksi = new Database();
        koneksi.getConn();
    }
    
    //3. Mendeklarasikan variabel sesuai tabel dan menerapkan enkapsulasi
    private String noPendaftaran;
    private String tanggalPendaftaran;
    private String tahunAjaran;
    private String nisn;
    private String namaSiswa;
    private String jenisKelamin;
    private String tempatLahir;
    private String tanggalLahir;
    private String alamatSiswa;
    private String pilihSekolah;
    private String namaAyah;
    private String pekerjaanAyah;
    private String namaIbu;
    private String pekerjaanIbu;
    private String alamatOrtu;

    public String getNoPendaftaran() {
        return noPendaftaran;
    }

    public void setNoPendaftaran(String noPendaftaran) {
        this.noPendaftaran = noPendaftaran;
    }

    public String getTanggalPendaftaran() {
        return tanggalPendaftaran;
    }

    public void setTanggalPendaftaran(String tanggalPendaftaran) {
        this.tanggalPendaftaran = tanggalPendaftaran;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamatSiswa() {
        return alamatSiswa;
    }

    public void setAlamatSiswa(String alamatSiswa) {
        this.alamatSiswa = alamatSiswa;
    }

    public String getPilihSekolah() {
        return pilihSekolah;
    }

    public void setPilihSekolah(String pilihSekolah) {
        this.pilihSekolah = pilihSekolah;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public String getAlamatOrtu() {
        return alamatOrtu;
    }

    public void setAlamatOrtu(String alamatOrtu) {
        this.alamatOrtu = alamatOrtu;
    }

    //4. Metode untuk input data
    public boolean insertPendaftaran(){
        query = "INSERT INTO pendaftaran VALUES ('"+noPendaftaran+"','"
                +tanggalPendaftaran+"','"+tahunAjaran+"','"
                +nisn+"','"+namaSiswa+"','"+jenisKelamin+"','"
                +tempatLahir+"','"+tanggalLahir+"','"
                +alamatSiswa+"','"+pilihSekolah+"','"
                +namaAyah+"','"+pekerjaanAyah+"','"
                +namaIbu+"','"+pekerjaanIbu+"','"+alamatOrtu+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }
    
    //5. Metode untuk pendaftaran
    public String buatNoPendaftaran(String tanggal){
        int temp = 0;
        String no = "";
        query = "SELECT MAX(RIGHT(no_pendaftaran,3) FROM pendaftaran) "
                + "WHERE tanggal_pendaftaran = '"+tanggal+"'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsNoPendaftaran = koneksi.getRs();
            try {
                rsNoPendaftaran.next();
                no = rsNoPendaftaran.getString(1);
                if(no == null){
                    temp = 0;
                }else{
                    temp = Integer.parseInt(rsNoPendaftaran.getString(1))+1;
                }
                rsNoPendaftaran.close();
            } catch (SQLException se) {
                return null;
            }
        }
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
    
    public static void main(String[] args) {
        System.out.println(new PendaftaranModel().insertPendaftaran());
    }
}
