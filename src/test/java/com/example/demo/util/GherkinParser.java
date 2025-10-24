package com.example.demo.util;

import java.util.Objects;

public class GherkinParser {

    public static int positionToIndex(String position) {
        String index = "0";
        if (!Objects.equals(position, "")) {
            index = position.replaceAll("\\D", "");
        }
        return Integer.parseInt(index) - 1;
    }
}
