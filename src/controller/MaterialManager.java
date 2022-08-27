package controller;

import model.CrispyFlour;
import model.Discount;
import model.Material;
import model.Meat;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    public static List<Material> materialList = ReadWriteFile.readFile();

    public void addNewMaterial(Material material){
        materialList.add(material);
        ReadWriteFile.writeFile(materialList);
    }
    public void addNewMaterialIndex(int index,Material material){
        materialList.add( index,material);
        ReadWriteFile.writeFile(materialList);
    }
    public Material removeMaterial(int index){
        return  materialList.remove(index);


    }


    //tinh so tien sau giam gia
    public double getRealMoney(){
        double total=0;
        for (int i = 0; i < materialList.size(); i++) {
            if (materialList.get(i) instanceof Discount) {
                Discount discount = (Discount) materialList.get(i);
                total += discount.getRealMoney();
            }
        }
        return total;
    }
    public double getTotalMoney(){
        double total=0;
        for (int i = 0; i < materialList.size(); i++) {
            total += materialList.get(i).getAmount();
        }
        return total;
    }

    // tinh chenh lech
    public double getDifference(){
        double difference = getTotalMoney() - getRealMoney();
        return difference;
    }

    @Override
    public String toString() {
        String result="";
        for (int i = 0; i < materialList.size(); i++) {
            if(materialList.get(i) instanceof CrispyFlour){
                CrispyFlour crispyFlour=(CrispyFlour) materialList.get(i);
                result+= crispyFlour.toString()+"\n";
            }else if(materialList.get(i) instanceof Meat){
                Meat meat =(Meat) materialList.get(i);
                result+= meat.toString()+"\n";
            }
        }
        return result;
    }
}