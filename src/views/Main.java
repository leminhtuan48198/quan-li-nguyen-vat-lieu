package views;


import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
//    public static List<Material> materialList = MaterialManager.materialList;


    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();
        int choice;
        do {
            displayMenu();
            choice = 0;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    addCrispyFlour(materialManager);
                    break;
                case 2:
                    addMeat(materialManager);
                    break;
                case 3:
                    System.out.println(materialManager);
                    break;
                case 4:
                    System.out.println("So tien thuc phai tra la");
                    System.out.println(materialManager.getRealMoney());
                    break;
                case 5:
                    System.out.println("So tien chua giam gia la");
                    System.out.println(materialManager.getTotalMoney());
                    break;
                case 6:
                    System.out.println("Chenh lech tien la");
                    System.out.println(materialManager.getDifference());
                    break;
                case 7:
                    delete(materialManager, scanner);
                    int index;
                    break;
                case 8:
                    change(materialManager, scanner);
                    break;

                default:
                    System.out.println("Moi ban nhap so");
            }
        } while (choice != 0);
//        addCrispyFlour(materialManager);
//        addMeat(materialManager);
//
//        System.out.println(materialManager.getDifference());
//        System.out.println(materialManager);

    }

    private static void change(MaterialManager materialManager, Scanner scanner) {
        int index;
        System.out.println("Moi ban nhap vi tri can sua");
        index= scanner.nextInt();
        Material material=materialManager.removeMaterial(index-1);
        if( material instanceof CrispyFlour){
            addCrispyFlourIndex( index-1, materialManager);
        } else if(material instanceof Meat){
            addMeatIndex( index-1, materialManager);}
    }

    private static void delete(MaterialManager materialManager, Scanner scanner) {
        System.out.println("Moi ban nhap vi tri can xoa");
        int index= scanner.nextInt();
        materialManager.removeMaterial(index-1);
    }

    private static void displayMenu() {
        System.out.println("------MENU-----");
        System.out.println("1. Them bot");
        System.out.println("2. Them thit");
        System.out.println("3.Hien thi gio hang");
        System.out.println("4.Tinh tien thuc phai tra");
        System.out.println("5.Tinh gia tien chua giam gia");
        System.out.println("6.Tinh chenh lech tien");
        System.out.println("7.Xoa khoi gio hang");
        System.out.println("8.Sua gio hang");
        System.out.println("0.Ket thuc");
    }

    private static void addCrispyFlour(MaterialManager materialManager) {
        Material bot1 = getMaterialCrispyFlour();
        materialManager.addNewMaterial(bot1);
    }
    private static void addCrispyFlourIndex(int index,MaterialManager materialManager) {
        Material bot1 = getMaterialCrispyFlour();
        materialManager.addNewMaterialIndex(index,bot1);
    }
    private static void addMeat(MaterialManager materialManager) {
        Material meat = getMaterialMeat();
        materialManager.addNewMaterial(meat);
    }
    private static void addMeatIndex(int index,MaterialManager materialManager) {
        Material meat = getMaterialMeat();
        materialManager.addNewMaterialIndex(index,meat);
    }

    private static Material getMaterialCrispyFlour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap ten bot");

        String name = scanner.nextLine();
        System.out.println("Moi ban nhap id bot");
        String id = scanner.nextLine();

        System.out.println("Moi ban nhap ngay san xuat");
        int day = scanner.nextInt();
        System.out.println("Moi ban nhap thang san xuat");
        int month = scanner.nextInt();
        System.out.println("Moi ban nhap nam san xuat");
        int year = scanner.nextInt();
        System.out.println("Moi ban nhap gia tien");
        int cost= scanner.nextInt();
        System.out.println("Moi ban nhap so luong");
        double quantity=scanner.nextDouble();
        CrispyFlour bot1 = new CrispyFlour();
        bot1.setId(id);
        bot1.setName(name);
        bot1.setCost(cost);
        bot1.setQuantity(quantity);
        bot1.setManufacturingDate(LocalDate.of(year,month,day));
        return bot1;
    }
    private static Material getMaterialMeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap ten thit");

        String name = scanner.nextLine();
        System.out.println("Moi ban nhap id thit");
        String id = scanner.nextLine();

        System.out.println("Moi ban nhap ngay san xuat");
        int day = scanner.nextInt();
        System.out.println("Moi ban nhap thang san xuat");
        int month = scanner.nextInt();
        System.out.println("Moi ban nhap nam san xuat");
        int year = scanner.nextInt();
        System.out.println("Moi ban nhap gia tien");
        int cost= scanner.nextInt();
        System.out.println("Moi ban nhap can nang");
        double weight=scanner.nextDouble();
        Meat meat = new Meat();
        meat.setId(id);
        meat.setName(name);
        meat.setCost(cost);
        meat.setWeight(weight);
        meat.setManufacturingDate(LocalDate.of(year,month,day));
        return meat;
    }


}