package com.experis.calcInvoice;

import java.util.ArrayList;

public class Invoice {
    private ArrayList<Item> items;

    public Invoice(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
