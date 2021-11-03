package com.experis.dataBase;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    final public HashMap<String, Book> BooksCatalog = new HashMap<String, Book>();
    final public HashMap<Book, String> BooksCatalogG = new HashMap<>();
    public ArrayList<EncodedString> booksTitle = new ArrayList<>();
    public ArrayList<EncodedString> publishers = new ArrayList<>();
    public ArrayList<EncodedString> authors = new ArrayList<>();
    public EncodedMap encodedMap = new EncodedMap();

    public int getIndex(ArrayList<EncodedString> EncodedStringArray, ArrayList<Integer> arrayList) {
        for (int i = 0; i < EncodedStringArray.size(); i++) {
            if (EncodedStringArray.get(i).compareTo(arrayList) == 0) {
                return i;
            }
        }
        return -1;
    }
}