package com.experis;

public class SecondQuestion {
    public static String trim(char[] chArray) {
        StringBuilder sb = new StringBuilder();

        if (chArray.length==1||chArray==null)
        {
            return String.valueOf(chArray);
        }

        for (int i = 0; i < chArray.length; i++) {
            char ch = chArray[i];

            if (ch != ' '||i - 1 < 0) {
                sb.append(ch);

            } else if (chArray[i - 1] != ' ') {
                sb.append(ch);
            }
        }
        return String.valueOf(sb);
    }
}
