package satu;

import satu.Koneksi.*;
import java.sql.*;
import java.util.ArrayList;


public class Petugas {
    private int idpetugas;
    private String nama_petugas;
    
    public Petugas(){
        
    }
    
    public Petugas(int idpetugas, String nama_petugas){
        this.nama_petugas=nama_petugas;
    }
    
    public int getIdPetugas(){
        return idpetugas;
    }
    
    public void setIdPetugas(int idpetugas){
        this.idpetugas=idpetugas;
    }
    
    public String getNama_petugas(){
        return nama_petugas;
    }
    
    public void setNama_petugas(String nama_petugas){
        this.nama_petugas=nama_petugas;
    }
    
    public String toString(){
        return nama_petugas;
    }
    
    public Petugas getById(int id){
        Petugas pet = new Petugas();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM petugas WHERE idpetugas = '" + id + "'");
                
        try {
            while(rs.next()){
                pet = new Petugas();
                pet.setIdPetugas(rs.getInt("idpetugas"));
                pet.setNama_petugas(rs.getString("nama_petugas"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pet;
    }
    
    public ArrayList<Petugas> getAll(){
        ArrayList<Petugas> ListPetugas = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM petugas");
        
        try {
            while (rs.next()) {                
                Petugas pet = new Petugas();
                pet.setIdPetugas(rs.getInt("idpetugas"));
                pet.setNama_petugas(rs.getString("nama_petugas"));
                
                ListPetugas.add(pet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPetugas;
    }
    
    public ArrayList<Petugas> search(String keyword){
        ArrayList<Petugas> ListPetugas = new ArrayList();
        String sql = "SELECT * FROM petugas WHERE "
                + "nama_petugas LIKE '%" + keyword + "%'";
        ResultSet rs = Koneksi.selectQuery(sql);
        
        try {
            while (rs.next()) {                
                Petugas pet = new Petugas();
                pet.setIdPetugas(rs.getInt("idpetugas"));
                pet.setNama_petugas(rs.getString("nama_petugas"));
                
                ListPetugas.add(pet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPetugas;
    }

    public void save(){
        if(getById(idpetugas).getIdPetugas() == 0){
            String SQL = "INSERT INTO petugas (nama_petugas) VALUES("
                    + "'" + this.nama_petugas + "'"
                    + ")";
            this.idpetugas = Koneksi.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE petugas set "
                    + " nama_petugas = '" + this.nama_petugas + "'"
                    + " WHERE idpetugas = '" + this.idpetugas + "'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM petugas WHERE idpetugas = '" + this.idpetugas + "'";
        Koneksi.executeQuery(SQL);
    }
}
