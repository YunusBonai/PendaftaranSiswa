/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PendaftaranModel;
import view.PendaftaranForm;

/**
 *
 * @author HENDRA
 */
public class PendaftaranController {
    //1. Mendeklarasikan objek
    private PendaftaranForm view;
    private PendaftaranModel model;
   
    public PendaftaranController(PendaftaranForm view){
       this.view = view;
       model = new PendaftaranModel();
    }
    
    //2. Metode untuk input data
    public boolean insertPendaftaran(){
       return model.insertPendaftaran();
    }
    
    //3. Metode untuk pendaftaran
    public String buatNoPendaftaran(String tanggal){
       return model.buatNoPendaftaran(tanggal);
    }
   
    //4. Metode untuk input data pendaftaran
    public void inputPendaftaran(String noPendaftaran, String tanggalPendaftaran,
        String tahunAjaran, String nisn, String namaSiswa, String jenisKelamin,
        String tempatLahir, String tanggalLahir, String alamatSiswa,
        String sekolah, String namaAyah, String pekerjaanAyah,
        String namaIbu, String pekerjaanIbu, String alamatOrtu)
   {
        model.setNoPendaftaran(noPendaftaran);
        model.setTanggalPendaftaran(tanggalPendaftaran);
        model.setTahunAjaran(tahunAjaran);
        model.setNisn(nisn);
        model.setNamaSiswa(namaSiswa);
        model.setJenisKelamin(jenisKelamin);
        model.setTempatLahir(tempatLahir);
        model.setTanggalLahir(tanggalLahir);
        model.setAlamatSiswa(alamatSiswa);
        model.setPilihSekolah(sekolah);
        model.setNamaAyah(namaAyah);
        model.setPekerjaanAyah(pekerjaanAyah);
        model.setNamaIbu(namaIbu);
        model.setPekerjaanIbu(pekerjaanIbu);
        model.setAlamatOrtu(alamatOrtu);
   }
}
