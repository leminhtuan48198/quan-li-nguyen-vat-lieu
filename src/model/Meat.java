package model;

import model.Material;

import java.time.LocalDate;

import static model.Date.convertDateToDays;

public class Meat extends Material implements Discount {
    public static final int FIVE_DAYS = 5;
    public static final double DISCOUNT_30 = 0.3;
    public static final double DISCOUNT_10 = 0.1;
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost()*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        return getAmount()*(1-getDiscount());
    }
    public int getNoDayToExpiry(){
        return convertDateToDays(getExpiryDate()) - convertDateToDays(now);
    }
    LocalDate now= LocalDate.now();
    public double getDiscount(){
        return (getNoDayToExpiry()<= FIVE_DAYS)? DISCOUNT_30 : DISCOUNT_10;
    }

    @Override
    public String toString() {
        return super.toString()+"Meat{" +
                "weight=" + weight +
                '}';
    }
}
