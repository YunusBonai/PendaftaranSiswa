/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.StaffModel;
import view.LoginForm;
//import view.PenggunaForm;
import view.StaffForm;

/**
 *
 * @author HENDRA
 */
public class StaffController {
    //1. Mendeklarasikan objek
    private LoginForm view1;
    private StaffModel model;
//    private PenggunaForm view2;
    private StaffForm view3;
    
    public StaffController(LoginForm view) {
        this.view1 = view;
        model = new StaffModel();
    }

//    public StaffController(PenggunaForm view2) {
//        this.view2 = view2;
//        model = new StaffModel();
//    }

    public StaffController(StaffForm view3) {
        this.view3 = view3;
        model = new StaffModel();
    }
    
    //2. Metode untuk input data
    public void inputStaff(String nik, String nama, String password, String telp, String alamat,
            String email, String jabatan){
        model.setNik(nik);
        model.setNama(nama);
//        model.setJenisKel(jk);
        model.setPassword(password);
        model.setTelp(telp);
        model.setAlamat(alamat);
        model.setEmail(email);
        model.setJabatan(jabatan);    
    }
    
    //3. Metode untuk login
    public boolean login(String nik, String password){
        model.setNik(nik);
        model.setPassword(password);
        return model.login();
    }
    
    //4. Output
    public static String getNik(){
        return StaffModel.getNikLogin();
    }

    public static String getNama(){
        return StaffModel.getNamaLogin();
    }
    
    
    public static String getTelp(){
        return StaffModel.getTelpLogin();
    }

    public static String getPassword(){
        return StaffModel.getPasswordLogin();
    }
    
    //5. Metode untuk input variabel static
    public void inputUser(String nama, String telp, String password){
        StaffModel.setNamaLogin(nama);
        StaffModel.setTelpLogin(telp);
        StaffModel.setPasswordLogin(password);
    }
    
    //6. Metode untuk update data staff
    public boolean updateStaff(){
        return model.updateStaff();
    }
    
    //7. Metode untuk seleksi data staff
    public List selectStaff(String nik, String nama){
        return model.selectStaff(nik, nama);
    }
    
    //8. Metode untuk input data staff
    public boolean  insertStaff(){
        return model.insertStaff();
    }
}
