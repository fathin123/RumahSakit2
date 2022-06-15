package satu;

import satu.Koneksi.*;
import java.util.ArrayList;
import java.sql.*;

public class Obat {
    int idobat;
    String nama_obat, jenis_obat, harga_obat;
    
    public Obat(){
        
    }
    
    public Obat(String nama_obat, String jenis_obat, String harga_obat){
        this.nama_obat=nama_obat;
        this.jenis_obat=jenis_obat;
        this.harga_obat=harga_obat;
    }
    
    public int getIdobat(){
        return idobat;
    }
    
    public void setIdobat(int idobat){
        this.idobat=idobat;
    }
    
    public String getNama_obat(){
        return nama_obat;
    }
    
    public void setNama_obat(String nama_obat){
        this.nama_obat=nama_obat;
    }
    
    public String getJenis_obat(){
        return jenis_obat;
    }
    
    public void setJenis_obat(String jenis_obat){
        this.jenis_obat=jenis_obat;
    }
    
    public String getHarga_obat(){
        return harga_obat;
    }
    
    public void setHarga_obat(String harga_obat){
        this.harga_obat=harga_obat;
    }
    
   
     
    public Obat getById(int id){
        Obat ob = new Obat();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM obat WHERE idobat = '" + id + "'");
                
        try {
            while(rs.next()){
                ob = new Obat();
                ob.setIdobat(rs.getInt("idobat"));
                ob.setNama_obat(rs.getString("nama_obat"));
                ob.setJenis_obat(rs.getString("jenis_obat"));
                ob.setHarga_obat(rs.getString("harga_obat"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }
    
    public ArrayList<Obat> getAll(){
        ArrayList<Obat> ListObat = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM obat");
        
        try {
            while (rs.next()) {                
                Obat ob = new Obat();
                ob = new Obat();
                ob.setIdobat(rs.getInt("idobat"));
                ob.setNama_obat(rs.getString("nama_obat"));
                ob.setJenis_obat(rs.getString("jenis_obat"));
                ob.setHarga_obat(rs.getString("harga_obat"));
                
                ListObat.add(ob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListObat;
    }
    
    public ArrayList<Obat> search(String keyword){
        ArrayList<Obat> ListObat = new ArrayList();
        String sql = "SELECT * FROM obat WHERE "
                + "nama_obat LIKE '%" + keyword + "%'"
                + "OR jenis_obat LIKE '%" + keyword + "%'";
        ResultSet rs = Koneksi.selectQuery(sql);
        
        try {
            while (rs.next()) {                
                Obat ob = new Obat();
                ob = new Obat();
                ob.setIdobat(rs.getInt("idobat"));
                ob.setNama_obat(rs.getString("nama_obat"));
                ob.setJenis_obat(rs.getString("jenis_obat"));
                ob.setHarga_obat(rs.getString("harga_obat"));
                
                ListObat.add(ob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListObat;
    }
    
    public void save(){
        if(getById(idobat).getIdobat() == 0){
            String SQL = "INSERT INTO obat (nama_obat, jenis_obat, harga_obat) VALUES("
                    + "'" + this.nama_obat + "',"
                    + "'" + this.jenis_obat + "',"
                    +"'" + this.harga_obat + "'"
                    + ")";
            this.idobat = Koneksi.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE obat set "
                    + "nama_obat = '" + this.nama_obat + "', "
                    + "jenis_obat = '" + this.jenis_obat + "',"
                    + "harga_obat = '" + this.harga_obat + "'"
                    + " WHERE idobat = '" + this.idobat + "'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM obat WHERE idobat = '" + this.idobat + "'";
         Koneksi.executeQuery(SQL);
     }
}
