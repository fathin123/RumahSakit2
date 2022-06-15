package dua;

import satu.*;
public class TestPetugas {
    public static void main(String[] args) {
        Petugas pet1 = new Petugas(1,"Clara");
        Petugas pet2 = new Petugas(2,"Karisma");
        Petugas pet3 = new Petugas(3,"Bayu");
       
        System.out.println("=========Tambah Data=========");
        // test tambah data (insert)
        pet1.save();
        pet2.save();
        pet3.save();
        
        
        for(Petugas p : new Petugas().getAll())
        {
            System.out.println("ID Petugas: " + p.getIdPetugas()+ ", Nama Petugas: " + p.getNama_petugas());
        }
    }
}
