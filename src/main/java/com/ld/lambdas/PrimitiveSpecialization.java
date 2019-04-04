package com.ld.lambdas;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PrimitiveSpecialization {

    public static void main(String[] args) {

        //no boxing
        IntPredicate intPredicate = i -> i % 2 == 0;
        System.out.println(intPredicate.test(10));

        //boxing with the same result
        Predicate<Integer> predicate = (Integer i) -> i % 2 == 0;
        System.out.println(predicate.test(10));

    }

}
