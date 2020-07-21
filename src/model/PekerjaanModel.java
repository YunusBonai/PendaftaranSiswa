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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HENDRA
 */
public class PekerjaanModel {
    //1. Menentukan kebutuhan variabel
    private Database koneksi;
    private ResultSet rsPekerjaan, rsKode;
    private String query;
    private boolean status;
    private List<PekerjaanModel> listPekerjaan;

    //2. Membuat objek
    public PekerjaanModel() {
        koneksi = new Database();
        koneksi.getConn();
    }
    
    //3. Mendeklarasikan variabel sesuai tabel dan menerapkan enkapsulasi
    private String kodePekerjaan;
    private String namaPekerjaan;

    public String getKodePekerjaan() {
        return kodePekerjaan;
    }

    public void setKodePekerjaan(String kodePekerjaan) {
        this.kodePekerjaan = kodePekerjaan;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    //4. Metode untuk input data pekerjaan
    public boolean insertPekerjaan() {
        query = "INSERT INTO pekerjaan VALUES ('" + kodePekerjaan + "','" + namaPekerjaan + "')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    //5. Metode untuk update data pekerjaan
    public boolean updatePekerjaan() {
        query = "UPDATE pekerjaan SET nama_pekerjaan = '" + namaPekerjaan + "' WHERE kode_pekerjaan = '" + kodePekerjaan + "'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    //6. Metode untuk hapus data pekerjaan
    public boolean deletePekerjaan() {
        query = "DELETE FROM pekerjaan WHERE kode_pekerjaan = '" + kodePekerjaan + "'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    //7. Metode untuk tampil data pekerjaan
    public List selectPekerjaan() {
        query = "SELECT * FROM pekerjaan";
        status = koneksi.eksekusiQuery(query, true);
        if (status) {
            rsPekerjaan = koneksi.getRs();
            listPekerjaan = new ArrayList<PekerjaanModel>();
            try {
                while (rsPekerjaan.next()) {
                    PekerjaanModel model = new PekerjaanModel();
                    model.setKodePekerjaan(rsPekerjaan.getString(1));
                    model.setNamaPekerjaan(rsPekerjaan.getString(2));
                    listPekerjaan.add(model);
                }
                rsPekerjaan.close();
                return listPekerjaan;
            } catch (SQLException se) {
                return null;
            }
        }
        return null;
    }

    //8. Metode untuk kode pekerjaan
    public String kodeBaru() {
        int temp = 0;
        String kode = "";
        query = "SELECT MAX(RIGHT(kode_pekerjaan,2)) FROM pekerjaan";
        status = koneksi.eksekusiQuery(query, true);
        if (status) {
            rsKode = koneksi.getRs();
            try {
                rsKode.next();
                temp = Integer.parseInt(rsKode.getString(1)) + 1;
                rsKode.close();
            } catch (SQLException ex) {
                Logger.getLogger(PekerjaanModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (temp == 0) {
            kode = "P001";
        } else if (temp < 10) {
            kode = "P00" + temp;
        } else {
            kode = "P0" + temp;
        }
        
        return kode;
    }
}
