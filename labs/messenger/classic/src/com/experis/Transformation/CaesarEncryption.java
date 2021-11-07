package com.experis.Transformation;


public class CaesarEncryption implements Transform<String> {
    public String transforn(String massage) {

        StringBuilder sb = new StringBuilder(massage);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch < 'n' && ch >= 'a' || ch < 'N' && ch >= 'A') {
                sb.setCharAt(i, (char) (ch + 13));

            } else if (ch <= 'z' && ch >= 'n' || ch <= 'Z' && ch >= 'N') {
                sb.setCharAt(i, (char) (ch - 13));
            }
        }

        return String.valueOf(sb);
    }
}

