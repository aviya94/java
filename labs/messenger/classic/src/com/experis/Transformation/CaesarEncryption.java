package com.experis.Transformation;


public class CaesarEncryption implements Transform<String> {
    public String transforn(String massage) {

        char[] messageArray = massage.toCharArray();
        for (int i = 0; i < messageArray.length; i++) {

            if (messageArray[i] < 'n' && messageArray[i] >= 'a' || messageArray[i] < 'N' && messageArray[i] >= 'A') {
                messageArray[i] = (char) (messageArray[i] + 13);
            } else if (messageArray[i] <= 'z' && messageArray[i] >= 'n' || messageArray[i] <= 'Z' && messageArray[i] >= 'N') {
                messageArray[i] = (char) (messageArray[i] - 13);
            }
        }

        return String.valueOf(messageArray);
    }
}

