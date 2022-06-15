package dua;

import satu.*;
/**
 *
 * @author Fathin dan Thalia
 */
public class TestObat {
    public static void main(String[] args) {
        Obat ob1 = new Obat("Paracetamol","Pereda Panas","10000");
        Obat ob2 = new Obat("Demacolin","Batuk Pilek","20000");
        Obat ob3 = new Obat("Amocxilin","Pereda Nyeri","30000");
    
        ob1.save();
        ob2.save();
        ob3.save();
        
//        //test delete
//        ob1.delete();
   
        for(Obat o : new Obat().getAll())
        { 
            System.out.println("Nama Obat: " + o.getNama_obat() + ", Jenis Obat: " + 
                                o.getJenis_obat() + ", Harga Obat: " + o.getHarga_obat()); 
        }
    }
}

