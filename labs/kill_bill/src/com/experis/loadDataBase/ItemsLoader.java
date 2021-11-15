package com.experis.loadDataBase;

import com.experis.calcInvoice.Invoice;
import com.experis.calcInvoice.Item;
import com.experis.parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;

public class ItemsLoader extends Loader {

    private Invoice invoice;

    public ItemsLoader(Parser parser, String filePath, Invoice invoice) {
        super(parser, filePath);
        this.invoice = invoice;
        loadItem(bufferedReader);
    }


    public void loadItem(BufferedReader bufferedReader) {
        String currencyLine;
        try {
            while ((currencyLine = bufferedReader.readLine()) != null) {
                addToInvoice(currencyLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToInvoice(String currencyLine) {
        Item item = (Item) parser.parse(currencyLine);

        invoice.addItem(item);
    }

}
