package com.experis.Transform;

import java.util.function.Function;

public class caesarEncryption {
    public Function<String, String> caesarEncryptionTransform(String massage) {

        Function<String, String> caesarEncryption = (str) -> {
            StringBuilder sb = new StringBuilder(str);

            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);

                if (ch < 'n' && ch >= 'a' || ch < 'N' && ch >= 'A') {
                    sb.setCharAt(i, (char) (ch + 13));

                } else if (ch <= 'z' && ch >= 'n' || ch <= 'Z' && ch >= 'N') {
                    sb.setCharAt(i, (char) (ch - 13));
                }
            }

            return String.valueOf(sb);
        };
        return caesarEncryption;

    }
}
