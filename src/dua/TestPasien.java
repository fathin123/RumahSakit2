/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dua;
import satu.*;

public class TestPasien {
    public static void main(String[] args) {
        Pasien pas = new Pasien("1","Sarah", "Sariawan", "P", "Kapas", "0813xxx");
    
        pas.save();
        
        //pas.delete();
   
        for(Pasien p : new Pasien().getAll())
        {
            System.out.println("ID Pasien: " + p.getIdPasien()
                    + ", ID Dokter: " + p.getIdDokter()
                    + ", Nama Pasien: " + p.getNama_pasien() 
                    + ", Penyakit: " + p.getPenyakit() 
                    + ", Jenis Kelamin: " + p.getJk() 
                    + ", Alamat: " + p.getAlamat() 
                    + ", Telepon: " + p.getTelp());
        }
    }
}
