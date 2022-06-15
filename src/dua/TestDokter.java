package dua;

import satu.*;
public class TestDokter {
    public static void main(String[] args){
    Dokter dok1 = new Dokter(1, "Aku", "Anak");
    Dokter dok2 = new Dokter(2, "Kamu", "Penyakit Dalam");
    Dokter dok3 = new Dokter(3, "Dia", "THT");
    Dokter dok4 = new Dokter(4, "Kita", "Mata");
    
        System.out.println("==================Tambah Data=======================");
    // test tambah data (insert)
    dok1.save();
    dok2.save();
    dok3.save();
    dok4.save();

        System.out.println("==================Update Data=======================");
    //test edit data (update)
    dok3.setNama_dokter("KITA");
    
        System.out.println("==================Hapus Data=======================");
    // test hapus data (delete)
    dok4.delete();

        System.out.println("==================Menampilkan Data=======================");
    // test select all
    for(Dokter d : new Dokter().getAll())
    {
        System.out.println("ID Dokter: " + d.getIdDokter() + ", Nama Dokter: " + d.getNama_dokter() + ", Spesialis: " + d.getSpesialis());
    }
    
        System.out.println("==================Search Data=======================");
    // test search
    for(Dokter d : new Dokter().search("Kamu"))
    {
        System.out.println("ID Dokter: " + d.getIdDokter() + ",Nama Dokter: " + d.getNama_dokter() + ", Spesialis: " + d.getSpesialis());
    }
  }
}
