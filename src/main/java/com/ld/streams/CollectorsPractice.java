package com.ld.streams;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorsPractice {


    public static void main(String[] args) {

        //max and min

        Comparator<Dish> comparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> maxDish = Dish.menu.stream()
                .collect(maxBy(comparator));

        System.out.println(maxDish.get());

        //summarization

        int summCalories = Dish.menu.stream()
                .collect(summingInt(Dish::getCalories));

        System.out.println(summCalories);

        IntSummaryStatistics menuStatistics =
                Dish.menu.stream().collect(summarizingInt(Dish::getCalories));


        System.out.println(menuStatistics);


        String stringMenu = Dish.menu.stream()
                .map(Dish::getName)
                .collect(joining());

        System.out.println(stringMenu);


        String stringMenu2 = Dish.menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));
        System.out.println(stringMenu2);
    }

}
