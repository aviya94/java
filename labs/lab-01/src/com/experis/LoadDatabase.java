package com.experis;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoadDatabase {


    final private HashMap<String, String[]> BooksCatalogISBN = new HashMap<String, String[]>();
    final private HashMap<String, String[]> BooksCatalogTitel = new HashMap<String, String[]>();
    final private HashMap<Integer, String> publishers = new HashMap<Integer, String>();
    final private HashMap<Integer, String> authors = new HashMap<Integer, String>();
    final private HashMap<String, Integer> titleFildlInHashMap = new HashMap<String, Integer>();
    private FileInputStream fileInputStream;
    private BufferedReader bufferedReader;

    public LoadDatabase(String filePath) {

        loadFile(filePath);
        addDataToStructuresDataFromFile();
    }

    private void loadFile(String filePath) {

        try {
            fileInputStream = new FileInputStream(filePath);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        }

        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    private void addDataToStructuresDataFromFile() {

        try {
            String line = bufferedReader.readLine();
            setTitlesFildsInHashMap(line);
            int nextIndexAuthor = 0;
            int nextIndexPublishersr = 0;

            while ((line = bufferedReader.readLine()) != null) {

                String[] lineFilds = line.split("\\|");
                if(lineFilds.length==titleFildlInHashMap.size()) {
                    nextIndexAuthor = addauthor(lineFilds, nextIndexAuthor);
                    nextIndexPublishersr = addPublishersr(lineFilds, nextIndexPublishersr);
                    addToBookCatalogStructuresData(lineFilds);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    private void addToBookCatalogStructuresData(String[] lineFilds){

        String isbnFild = lineFilds[titleFildlInHashMap.get("ISBN")];
        String titelFild = lineFilds[titleFildlInHashMap.get("Book-Title")];

        BooksCatalogISBN.put(isbnFild, lineFilds);
        BooksCatalogTitel.put(" "+titelFild+" ", lineFilds);

    }

    private void setTitlesFildsInHashMap(String strLine) {
        assert strLine != null;
        String[] fildName = strLine.split("\\|");
        int index = 0;

        for (String e : fildName) {
            titleFildlInHashMap.put(e.stripLeading(), index++);
        }
    }

    private int addIndexToFildStructurData(String[] filds, int nextIndex, int indexInFild, HashMap<Integer, String> hashMapToSaveFild) {
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
        int next=addIndexToFildStructurData(filds, nextIndex, titleFildlInHashMap.get("Book-Author"), authors);
        return next;
    }

    private int addPublishersr(String[] filds, int nextIndex) {
        assert filds != null;
        return addIndexToFildStructurData(filds, nextIndex, titleFildlInHashMap.get("Publisher"), publishers);
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
        return titleFildlInHashMap;
    }
}

