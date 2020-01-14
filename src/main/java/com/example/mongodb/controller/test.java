package com.example.mongodb.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        String[] strings = {"1", "2", "100", "124"};
        List<Integer> integerList = Arrays.stream(strings).map(b -> Integer.parseInt(b)).collect(Collectors.toList());
        System.out.println(integerList);

        String[] strArray = integerList.stream().map(s -> String.valueOf(s)).toArray(String[]::new);
        for (String s : strArray) {
            System.out.println(s);
        }
    }
}
