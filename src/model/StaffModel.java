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
public class StaffModel {
    //1. Menentukan kebutuhan variabel
    private Database koneksi;
    private ResultSet rsLogin, rsStaff;
    private String query;
    private boolean status;
    private List<StaffModel> listStaff;
    
    //2. Membuat objek
    public StaffModel() {
        koneksi = new Database();
        koneksi.getConn();
    }
    
   
    //3. Mendeklarasikan variabel sesuai tabel dan menerapkan enkapsulasi
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    private String nik;
    private String nama;
    private String telp;
    private String password;
    private String jenisKel;
    private String alamat;
    private String email;
    private String jabatan;
    
    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJenisKel() {
        return jenisKel;
    }

    public void setJenisKel(String jenisKel) {
        this.jenisKel = jenisKel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJabatan() {
        return jabatan;
    }
    
    //4. Mendeklarasikan variabel untuk login dan menerapkan enkapsulasi
    private static String nikLogin;
    private static String namaLogin;
    private static String telpLogin;
    private static String passwordLogin;

    public static String getNikLogin() {
        return nikLogin;
    }

    public static void setNikLogin(String nikLogin) {
        StaffModel.nikLogin = nikLogin;
    }

    public static String getNamaLogin() {
        return namaLogin;
    }

    public static void setNamaLogin(String namaLogin) {
        StaffModel.namaLogin = namaLogin;
    }

    public static String getTelpLogin() {
        return telpLogin;
    }

    public static void setTelpLogin(String telpLogin) {
        StaffModel.telpLogin = telpLogin;
    }

    public static String getPasswordLogin() {
        return passwordLogin;
    }

    public static void setPasswordLogin(String passwordLogin) {
        StaffModel.passwordLogin = passwordLogin;
    }

    //5. Metode untuk login
    public boolean login(){
        query = "SELECT * "
                + "FROM staff "
                + "WHERE nik = '"+ nik +"' AND password = '"+password+"'";
        status = koneksi.eksekusiQuery(query, true);

        if(status){
            rsLogin = koneksi.getRs();
            try {
                rsLogin.next();
                nikLogin = rsLogin.getString(1);
                namaLogin = rsLogin.getString(2);
                telpLogin = rsLogin.getString(3);
                passwordLogin = rsLogin.getString(4);
                if(namaLogin == null){
                    status = false;
                }else{
                    status = true;
                }
            } catch (SQLException se) {
                status = false;
            }
        }
        return status;
    }
    
    //6. Metode untuk update data staff
    public boolean updateStaff(){
        query = "UPDATE staff SET nama_staff = '"+nama+"',"
                + " no_telp_staff = '"+telp+"', password = '"+password+"'"
                + " WHERE nik = '"+nik+"'" + "Jenis Kelamin = '"+jenisKel+"', "
                + "alamat = '"+alamat+"'"+"email = '"+email+"', "+jabatan;
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }
    
    //7. Metode untuk menampilkan dan pencarian data staff
     public List selectStaff(String nik, String nama){
        query = "SELECT nik, nama_staff, no_telp_staff, MD5(password)"
                + " FROM staff"
                + " WHERE nik LIKE '%"+nik+"%' OR nama_staff LIKE '%"+nama+"%'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsStaff = koneksi.getRs();
            listStaff = new ArrayList<StaffModel>();
            try {
                while(rsStaff.next()){
                    StaffModel model = new StaffModel();
                    model.setNik(rsStaff.getString(1));
                    model.setNama(rsStaff.getString(2));
                    model.setTelp(rsStaff.getString(3));
                    model.setPassword(rsStaff.getString(4));
                    listStaff.add(model);
                }
                rsStaff.close();
                return listStaff;
            } catch (SQLException se) {
                return null;
            }
        }
        return null;
    }
    
    //8. Metode untuk input data staff
    public boolean insertStaff(){
        query = "INSERT INTO staff"
                + " VALUES ('"+nik+"','"+nama+"','"+telp+"','"+
                password+"','"+jenisKel+"','"+alamat+"',"+email+"','"+jabatan+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    public static void main(String[] args) {
        System.out.println(new StaffModel().selectStaff("", ""));
    }
   
}
