/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PembayaranModel;
import java.util.List;
import view.PembayaranSPP;
/**
 *
 * @author ACER
 */
public class PembayaranController {
    private PembayaranSPP view;
    private PembayaranModel model;
    
    public PembayaranController(PembayaranSPP view){
        this.view =view;
        model = new PembayaranModel();
    }
    public boolean insertPembayaran(){
        return model.insertPembayaran();
    }
    
    public void inputPembayaran(String noPembayaran, String keteranganPembayaran,String noIndukSiswa ,String NamaSiswa, double totalPembayaran ,String Tanggalpembayaran){
        model.setNoPembayaran(noPembayaran);
        model.setKeteranganPembayaran(keteranganPembayaran);
        model.setNoIndukSiswa(noIndukSiswa);
        model.setNamaSiswa(NamaSiswa);
        model.setTotalPembayaran(totalPembayaran);
        model.setTanggalPembayaran(Tanggalpembayaran);
        
    }
    
}
