package com.experis;

public class TotalBill {
    private double bill;

    public TotalBill() {
        this.bill = 0;
    }

    public void addToBill(double bill) {
        this.bill += bill;
    }

    public double getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return "TotalBill=" + bill;
    }
}
