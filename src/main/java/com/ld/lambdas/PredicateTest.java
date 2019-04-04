package com.ld.lambdas;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        Predicate<Integer> predicate = x -> (x > 10);
        boolean isGT = predicate.test(9);
        System.out.println(isGT);
    }

}
