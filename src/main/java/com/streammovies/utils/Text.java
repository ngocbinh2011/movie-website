package com.streammovies.utils;

import java.text.Normalizer;

public class Text {
    public static String ignoreAccents(String input){
        input = Normalizer.normalize(input, Normalizer.Form.NFD);
        input = input.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replaceAll("[\\đ\\Đ]", "d");
        return input;
    }

    // url code same a-b-c-d
    public static String getUrlCodeIgnoreAccents(String input){
        input = ignoreAccents(input);
        input = input.replaceAll("[^\\w]+", " ").trim().replaceAll("[\\s]+", "-").toLowerCase();
        return input;
    }

}
