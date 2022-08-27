package storage;

import model.Material;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static List<Material> readFile(){
        List<Material> materialList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("material.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            materialList = (List<Material>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return materialList;
    }
    public static void writeFile(List<Material> materialList){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("material.dat");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(materialList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
