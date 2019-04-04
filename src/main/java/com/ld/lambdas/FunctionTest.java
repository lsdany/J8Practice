package com.ld.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }


    public static void main(String[] args) {

        List<Integer> list = map(Arrays.asList("This","is","a","test") ,
                s -> s.length());

        System.out.println(list);

    }

}
