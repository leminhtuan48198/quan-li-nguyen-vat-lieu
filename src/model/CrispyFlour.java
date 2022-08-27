package model;

import java.io.Serializable;
import java.time.LocalDate;

import static model.Date.convertDateToDays;

public class CrispyFlour extends Material implements Discount, Serializable {
    public static final int TWO_MONTHS = 60;
    public static final int FOUR_MONTHS = 120;
    public static final double DISCOUNT_40 = 0.4;
    public static final double DISCOUNT_20 = 0.2;
    public static final double DISCOUNT_5 = 0.05;
    private double quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return getCost()*quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
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
        if (getNoDayToExpiry()<= TWO_MONTHS){
            return DISCOUNT_40;
        }else if (getNoDayToExpiry()<= FOUR_MONTHS){
            return DISCOUNT_20;
        }else return DISCOUNT_5;
    }

    @Override
    public String toString() {
        return super.toString()+"CrispyFlour{" +
                "quantity=" + quantity +
                '}';
    }
}
