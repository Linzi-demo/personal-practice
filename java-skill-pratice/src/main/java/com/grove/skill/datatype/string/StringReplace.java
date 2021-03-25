package com.grove.skill.datatype.string;

import java.util.regex.Pattern;

public class StringReplace {

    public static void main(String[] args) {
        String str = "123\\d";

        String replace = str.replace("\\d", "456");
        String replace2 = str.replaceAll("\\d", "456");
        String replace3 = str.replaceAll(Pattern.quote("\\d"), "456");

        System.out.println(replace);
        System.out.println(replace2);
        System.out.println(replace3);
    }
}
