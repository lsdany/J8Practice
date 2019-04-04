package com.ld.lambdas;


import java.util.function.Function;

public class Letter {

    public static String addHeader(String text) {
        return "From me to " + text;
    }


    public static String addFooter(String text) {
        return text + "regards...";
    }


    public static String checkSpelling(String text) {
        return text.replace("labda", "lambda");
    }

    public static void main(String[] args) {

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

//        Function<String, String> addHeader = Letter::addHeader;
//        Function<String, String> transformationPipeline
//                = addHeader.andThen(Letter::addFooter);

    }
}