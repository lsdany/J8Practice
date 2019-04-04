package com.ld.collect;

import com.ld.streams.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectExample {

    public enum CaloricLevel { DIET, NORMAL, FAT }

    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> groupType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println(groupType);

        Map<CaloricLevel, List<Dish>> groupCaloric = Dish.menu.stream()
                .collect(Collectors.groupingBy(
                        dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else
                                if (dish.getCalories() <= 700)
                                    return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        }
                ));


        System.out.println(groupCaloric);


        Map<Boolean, List<Integer>> primesMap = partitionPrimes(100);
        System.out.println(primesMap);


    }


    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }
}
