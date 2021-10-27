package com.experis;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoadDatabase {


    private HashMap<String, String[]> BooksCatalogISBN = new HashMap<String, String[]>();
    private HashMap<String, String[]> BooksCatalogTitel = new HashMap<String, String[]>();
    private HashMap<Integer, String> publishers = new HashMap<Integer, String>();
    private HashMap<Integer, String> authors = new HashMap<Integer, String>();
    private HashMap<String, Integer> titeFildlInHashMap = new HashMap<String, Integer>();
    private FileInputStream fstream;
    private BufferedReader br;

    public LoadDatabase(String filePath) {

        loadFile(filePath);
        addToBookCatalogFromFile();
    }

    private void loadFile(String filePath) {

        try {
            fstream = new FileInputStream(filePath);
            br = new BufferedReader(new InputStreamReader(fstream));
        }

        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    private void addToBookCatalogFromFile() {

        try {
            String strLine = br.readLine();
            setTitelInHashMap(strLine);
            int nextIndexAuthor = 0;
            int nextIndexPublishersr = 0;
            while ((strLine = br.readLine()) != null) {

                String[] filds = strLine.split("\\|");
                nextIndexAuthor = addauthor(filds, nextIndexAuthor);
                nextIndexPublishersr = addPublishersr(filds, nextIndexPublishersr);
                String isbnFild = filds[titeFildlInHashMap.get("ISBN")];
                String titelFild = filds[titeFildlInHashMap.get("Book-Title")];
                BooksCatalogISBN.put(isbnFild, filds);
                BooksCatalogTitel.put(titelFild, filds);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    private void setTitelInHashMap(String strLine) {
        assert strLine != null;
        String[] fildName = strLine.split("\\|");
        int index = 0;

        for (String e : fildName) {
            titeFildlInHashMap.put(e, index++);
        }
    }

    private int AddIndexTofild(String[] filds, int nextIndex, int indexInFild, HashMap<Integer, String> hashMapToSaveFild) {
        assert filds != null;
        assert hashMapToSaveFild != null;

        Boolean isExist = false;

        for (Map.Entry e : hashMapToSaveFild.entrySet()) {
            String value = (String) e.getValue();
            if (value.equals(filds[indexInFild])) {
                isExist = true;
                filds[indexInFild] = String.valueOf(e.getKey());
            }
        }
        if (!isExist) {
            hashMapToSaveFild.put(nextIndex, filds[indexInFild]);
            filds[indexInFild] = String.valueOf(nextIndex++);
        }
        return nextIndex;
    }

    private int addauthor(String[] filds, int nextIndex) {
        assert filds != null;
        return AddIndexTofild(filds, nextIndex, titeFildlInHashMap.get("Book-Author"), authors);
    }

    private int addPublishersr(String[] filds, int nextIndex) {
        assert filds != null;
        return AddIndexTofild(filds, nextIndex, titeFildlInHashMap.get("Publisher"), publishers);
    }

    public HashMap<String, String[]> getBooksCatalogISBN() {
        return BooksCatalogISBN;
    }

    public HashMap<String, String[]> getBooksCatalogTitel() {
        return BooksCatalogTitel;
    }

    public HashMap<Integer, String> getPublishers() {
        return publishers;
    }

    public HashMap<Integer, String> getAuthors() {
        return authors;
    }

    public HashMap<String, Integer> getTiteFildlInHashMap() {
        return titeFildlInHashMap;
    }
}

