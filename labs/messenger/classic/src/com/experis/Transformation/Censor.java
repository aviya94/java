package com.experis.Transformation;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Censor implements Transform<String> {
    String sensorPattern;

    public Censor(ArrayList<String> censorList) {
        sensorPattern = getPattern(censorList);
    }

    private String getPattern(List<String> forbidden) {
        final var stringJoiner = new StringJoiner("|", "(", ")");
        for (String word : forbidden) {
            stringJoiner.add(Pattern.quote(word));
        }

        return stringJoiner.toString();
    }

    public String transforn(String message) {
        Pattern pattern = Pattern.compile(sensorPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(message);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(sb, "****");
        }
        return String.valueOf(sb);

    }
}

