/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.PekerjaanModel;
//import view.PekerjaanForm;

/**
 *
 * @author HENDRA
 */
public class PekerjaanController {
    //1. Mendeklarasikan objek
//    private PekerjaanForm view;
    private PekerjaanModel model;

    public PekerjaanController() {
        model = new PekerjaanModel();
    }

//    public PekerjaanController(PekerjaanForm view) {
//        this.view = view;
//        model = new PekerjaanModel();
//    }

    //2. Metode untuk input data
    public void inputPekerjaan(String kodePekerjaan, String namaPekerjaan){
        model.setKodePekerjaan(kodePekerjaan);
        model.setNamaPekerjaan(namaPekerjaan);
    }

    //3. Metode untuk input data pekerjaan
    public boolean insertPekerjaan(){
        return model.insertPekerjaan();
    }

    //4. Metode untuk update data pekerjaan
    public boolean updatePekerjaan(){
        return model.updatePekerjaan();
    }

    //5. Metode untuk hapus data pekerjaan
    public boolean deletePekerjaan(){
        return model.deletePekerjaan();
    }

    //6. Metode untuk menampilkan data pekerjaan
    public List selectPekerjaan(){
        return model.selectPekerjaan();
    }

    //7. Metode untuk kode pekerjaan
    public String kodeBaru(){
        return model.kodeBaru();
    }
}
