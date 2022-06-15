package satu;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Fathin dan Thalia
 */
public class Dokter {
    int iddokter;
    String nama_dokter, spesialis;
    
    public Dokter(){
        
    }
    
    public Dokter(int iddokter, String nama_dokter, String spesialis){
        this.iddokter=iddokter;
        this.nama_dokter=nama_dokter;
        this.spesialis=spesialis;
    }
    
    public int getIdDokter() {
        return iddokter;
    }

    public void setIdDokter(int iddokter) {
        this.iddokter = iddokter;
    }
    
    public String getNama_dokter(){
        return nama_dokter;
    }
    
    public void setNama_dokter(String nama_dokter){
        this.nama_dokter=nama_dokter;
    }
    
    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
    
    public String toString(){
        return nama_dokter;
    }
    
    public Dokter getById(int id){
        Dokter dok = new Dokter();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM dokter WHERE iddokter = '" + id + "'");
        
        try {
            while(rs.next()){
                dok = new Dokter();
                dok.setIdDokter(rs.getInt("iddokter"));
                dok.setNama_dokter(rs.getString("nama_dokter"));
                dok.setSpesialis(rs.getString("spesialis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dok;
    }
    
    public ArrayList<Dokter> getAll(){
        ArrayList<Dokter> ListDokter = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM dokter");
        
        try {
            while (rs.next()) {                
                Dokter dok = new Dokter();
                dok.setIdDokter(rs.getInt("iddokter"));
                dok.setNama_dokter(rs.getString("nama_dokter"));
                dok.setSpesialis(rs.getString("spesialis"));
                
                ListDokter.add(dok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListDokter;
    }
    
    public ArrayList<Dokter> search(String keyword){
        ArrayList<Dokter> ListDokter = new ArrayList();
        String sql = "SELECT * FROM dokter WHERE "
                + "nama_dokter LIKE '%" + keyword + "%'"
                + "OR spesialis LIKE '%" + keyword + "%'";
        ResultSet rs = Koneksi.selectQuery(sql);
        
        try {
            while (rs.next()) {                
                Dokter dok = new Dokter();
                dok.setIdDokter(rs.getInt("iddokter"));
                dok.setNama_dokter(rs.getString("nama_dokter"));
                dok.setSpesialis(rs.getString("spesialis"));
                
                ListDokter.add(dok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListDokter;
    }
    
    public void save(){
        if(getById(iddokter).getIdDokter() == 0){
            String SQL = "INSERT INTO dokter (nama_dokter, spesialis) VALUES("
                    + "'" + this.nama_dokter + "',"
                    + "'" + this.spesialis + "'"
                    + ")";
            this.iddokter = Koneksi.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE dokter set "
                    + " nama_dokter = '" + this.nama_dokter + "', "
                    + " spesialis = '" + this.spesialis + "'"
                    + " WHERE iddokter = '" + this.iddokter + "'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM dokter WHERE iddokter = '" + this.iddokter + "'";
        Koneksi.executeQuery(SQL);
    }
}
