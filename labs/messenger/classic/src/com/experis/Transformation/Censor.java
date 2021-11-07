package com.experis.Transformation;


import java.util.ArrayList;

public class Censor implements Transform<String> {
    public ArrayList<String> censorList;

    public Censor(ArrayList<String> censorList) {
        this.censorList = censorList;
    }

    public String transforn(String message) {
        String[] massgeWors = message.split(" ");

        for (int i = 0; i < massgeWors.length; i++) {
            if (censorList.indexOf(massgeWors[i]) >= 0) {
                String stars = star(massgeWors[i].length());
                massgeWors[i] = stars;
            }

        }
        return String.join(" ", massgeWors);

    }

    public String star(int size) {
        String stars = "*";
        for (int i = 1; i < size; i++) {
            stars = stars + "*";
        }
        return stars;
    }
}
