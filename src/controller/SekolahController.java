/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.SekolahModel;
//import view.SekolahForm;

/**
 *
 * @author HENDRA
 */
public class SekolahController {
    //1. Mendeklarasikan objek
//    private SekolahForm view;
    private SekolahModel model;

    public SekolahController() {
        model = new SekolahModel();
    }

//    public SekolahController(SekolahForm view) {
//        this.view = view;
//        model = new SekolahModel();
//    }

    //2. Metode untuk input data
    public void inputSekolah(String npsn, String nama, String alamat, String kecamatan, String kabupaten, String provinsi, String telp){
        model.setNpsn(npsn);
        model.setNama(nama);
        model.setAlamat(alamat);
        model.setKecamatan(kecamatan);
        model.setKabupaten(kabupaten);
        model.setProvinsi(provinsi);
        model.setTelp(telp);
    }

    //3. Metode untuk input data sekolah
    public boolean insertSekolah(){
        return model.insertSekolah();
    }

    //4. Metode untuk update data sekolah
    public boolean updateSekolah(){
        return model.updateSekolah();
    }

    //5. Metode untuk menghapus data sekolah
    public boolean deleteSekolah(String npsn){
        return model.deleteSekolah(npsn);
    }

    //6. Metode untuk seleksi data staff
    public List selectSekolah(String npsn, String nama){
        return model.selectSekolah(npsn, nama);
    }
}
