/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HENDRA
 */
public class SekolahModel {
    //1. Menentukan kebutuhan variabel
    private Database koneksi;
    private ResultSet rsSekolah;
    private String query;
    private boolean status;
    private List<SekolahModel> listSekolah;

    //2. Membuat objek
    public SekolahModel() {
        koneksi = new Database();
        koneksi.getConn();
    }

    //3. Mendeklarasikan variabel sesuai tabel dan menerapkan enkapsulasi
    private String npsn;
    private String nama;
    private String alamat;
    private String kecamatan;
    private String kabupaten;
    private String provinsi;
    private String telp;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpsn() {
        return npsn;
    }

    public void setNpsn(String npsn) {
        this.npsn = npsn;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    //4. Membuat metode untuk input data sekolah
    public boolean insertSekolah(){
        query = "INSERT INTO sekolah VALUES ('"+npsn+"','"+nama+"','"+alamat+"','"+kecamatan+"','"+kabupaten+"','"+provinsi+"','"+telp+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    //5. Membuat metode untuk update data sekolah
    public boolean updateSekolah(){
        query = "UPDATE sekolah SET nama_sekolah = '"+nama+"', alamat = '"+alamat+"', kecamatan = '"+kecamatan+"', kabupaten = '"+kabupaten+"', provinsi = '"+provinsi+"', telp = '"+telp+"' WHERE npsn = '"+npsn+"'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    //6. Membuat metode untuk hapus data sekolah
    public boolean deleteSekolah(String npsn){
        query = "DELETE FROM sekolah WHERE npsn = '"+npsn+"'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    //7. Membuat metode untuk menampilkan data sekolah
    public List selectSekolah(String npsn, String nama){
        query = "SELECT * FROM sekolah WHERE npsn LIKE '%"+npsn+"%' OR nama_sekolah LIKE '%"+nama+"%'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsSekolah = koneksi.getRs();
            listSekolah = new ArrayList<SekolahModel>();
            try {
                while(rsSekolah.next()){
                    SekolahModel model = new SekolahModel();
                    model.setNpsn(rsSekolah.getString(1));
                    model.setNama(rsSekolah.getString(2));
                    model.setAlamat(rsSekolah.getString(3));
                    model.setKecamatan(rsSekolah.getString(4));
                    model.setKabupaten(rsSekolah.getString(5));
                    model.setProvinsi(rsSekolah.getString(6));
                    model.setTelp(rsSekolah.getString(7));
                    listSekolah.add(model);
                }
                rsSekolah.close();
                return listSekolah;
            } catch (SQLException se) {
                return null;
            }
        }
        return null;
    }
}
