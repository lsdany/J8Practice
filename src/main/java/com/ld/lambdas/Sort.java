package com.ld.lambdas;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void main(String[] args) {

        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.addAll(Arrays.asList(new Apple(10,"red"), new Apple(2, "red"), new Apple(30, "green")));
        System.out.println(appleInventory);


        //comparing by weight
        appleInventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(appleInventory);

        //with lambda
        //appleInventory.sort(Comparator.comparing((a) -> a.getWeight()));

        appleInventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(appleInventory);


        appleInventory.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));
        System.out.println(appleInventory);

    }




    @ToString
    public static class Apple{

        public Apple(Integer weight, String color){
            this.weight = weight;
            this.color = color;
        }

        @Getter
        private Integer weight;
        @Getter
        private String color;


    }


    public static class AppleComparator implements Comparator<Apple>{

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
}
