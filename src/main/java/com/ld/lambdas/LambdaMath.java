package com.ld.lambdas;

import java.util.function.DoubleFunction;

public class LambdaMath {

    public static void main(String[] args) {

        double d = integrate((double dFunc) -> new Double(8), 1,3);
        System.out.println(d);
    }


    public static double integrate(DoubleFunction<Double> f, double a, double b) {
        return (f.apply(a) + f.apply(b)) * (b-a) / 2.0;
    }


}
