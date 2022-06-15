/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satu;

import satu.Koneksi.*;
import java.util.ArrayList;
import java.sql.*;

public class Pasien {
    int idpasien;
    String iddokter, nama_pasien, penyakit, jk, alamat, telp;
    
    public Pasien(){
        
    }
    
    public Pasien(String iddokter, String nama_pasien, String penyakit, String jk, String alamat, String telp){
        this.iddokter=iddokter;
        this.nama_pasien=nama_pasien;
        this.penyakit=penyakit;
        this.jk=jk;
        this.alamat=alamat;
        this.telp=telp;
    }
    
    public int getIdPasien(){
        return idpasien;
    }
    
    public void setIdPasien(int idpasien){
        this.idpasien=idpasien;
    }
    
    public String getIdDokter(){
        return iddokter;
    }
    
    public void setIdDokter(String iddokter){
        this.iddokter=iddokter;
    }
    
    public String getNama_pasien(){
        return nama_pasien;
    }
    
    public void setNama_pasien(String nama_pasien){
        this.nama_pasien=nama_pasien;
    }
    
    public String getPenyakit(){
        return penyakit;
    }
    
    public void setPenyakit(String penyakit){
        this.penyakit=penyakit;
    }
    
    public String getJk(){
        return jk;
    }
    
    public void setJk(String jk){
        this.jk=jk;
    }
    
    public String getTelp(){
        return telp;
    }
    
    public void setTelp(String telp){
        this.telp=telp;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }
    
    public Pasien getById(int id){
        Pasien pas = new Pasien();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pasien WHERE idpasien = '" + id + "'");
                
        try {
            while(rs.next()){
                pas = new Pasien();
                pas.setIdPasien(rs.getInt("idpasien"));
                pas.setIdDokter(rs.getString("iddokter"));
                pas.setNama_pasien(rs.getString("nama_pasien"));
                pas.setPenyakit(rs.getString("penyakit"));
                pas.setJk(rs.getString("jk"));
                pas.setAlamat(rs.getString("alamat"));
                pas.setTelp(rs.getString("telp"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pas;
    }
    
    public ArrayList<Pasien> getAll(){
        ArrayList<Pasien> ListPasien = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pasien");
        
        try {
            while (rs.next()) {                
                Pasien pas = new Pasien();
                pas = new Pasien();
                pas.setIdPasien(rs.getInt("idpasien"));
                pas.setIdDokter(rs.getString("iddokter"));
                pas.setNama_pasien(rs.getString("nama_pasien"));
                pas.setPenyakit(rs.getString("penyakit"));
                pas.setJk(rs.getString("jk"));
                pas.setAlamat(rs.getString("alamat"));
                pas.setTelp(rs.getString("telp"));
                
                ListPasien.add(pas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPasien;
    }
    
    public ArrayList<Pasien> search(String keyword){
        ArrayList<Pasien> ListPasien = new ArrayList();
        String sql = "SELECT * FROM pasien WHERE "
                + "nama_pasien LIKE '%" + keyword + "%'"
                + "OR alamat LIKE '%" + keyword + "%'";
        ResultSet rs = Koneksi.selectQuery(sql);
        
        try {
            while (rs.next()) {                
                Pasien pas = new Pasien();
                pas = new Pasien();
                pas.setIdPasien(rs.getInt("idpasien"));
                pas.setIdDokter(rs.getString("iddokter"));
                pas.setNama_pasien(rs.getString("nama_pasien"));
                pas.setPenyakit(rs.getString("penyakit"));
                pas.setJk(rs.getString("jk"));
                pas.setAlamat(rs.getString("alamat"));
pas.setTelp(rs.getString("telp"));
                
                ListPasien.add(pas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPasien;
    }
    
    public void save(){
        if(getById(idpasien).getIdPasien() == 0){
            String SQL = "INSERT INTO pasien (iddokter,nama_pasien, penyakit, jk, alamat, telp) VALUES("
                    + "'" + this.iddokter + "',"
                    + "'" + this.nama_pasien + "',"
                    + "'" + this.penyakit + "',"
                    + "'" + this.jk + "',"
                    + "'" + this.alamat + "',"
                    + "'" + this.telp + "'"
                    + ")";
            this.idpasien = Koneksi.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pasien set "
                    + "'" + this.iddokter + "',"
                    + "'" + this.nama_pasien + "',"
                    + "'" + this.penyakit + "',"
                    + "'" + this.jk + "',"
                    + "'" + this.alamat + "',"
                    + "'" + this.telp + "'"
                    + " WHERE idpasien = '" + this.idpasien + "'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM pasien WHERE idpasien = '" + this.idpasien + "'";
        Koneksi.executeQuery(SQL);
    }
}
