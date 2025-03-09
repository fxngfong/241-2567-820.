package com.example.utils;

public class StringHelper {
    public static String reverse(String text){
        //StringBuilder builder = new StringBuilder(text);
        //String rev = builder.reverse().toString();
        //return rev;
        return new StringBuilder(text).reverse().toString();
    }
}
