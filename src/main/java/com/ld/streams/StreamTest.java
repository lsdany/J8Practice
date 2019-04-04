package com.ld.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Hello", "world", "with", "streams");


        stringList.forEach(System.out::println);
        stringList.forEach(System.out::println);


        Stream<String> stringStream = stringList.stream();
        stringStream.forEach(System.out::println);
        //stringStream.forEach(System.out::println); this second returns an IllegalStateException


        List<Dish> vegiDishes = Dish.menu.stream().
                filter(Dish::isVetarian).
                collect(Collectors.toList());

        vegiDishes.stream().forEach(System.out::println);


        //getting dishes names
        List<String> names = Dish.menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println("Names: "+names.toString());

        List<String> letters = Arrays.asList("Hello", "world", "again", "bye");
        List<Integer> lettersSize = letters.stream().map(String::length).collect(Collectors.toList());
        System.out.println("Sizes: "+lettersSize.toString());

        //joining the two
        List<Integer> listNamesSizes = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("Names and Sizes "+listNamesSizes.toString());


        //returning unique characters from a list of words
        List<String> words = Arrays.asList("Hello", "World", "And", "Bye");
        List<String> listUniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Uniques characters "+listUniqueCharacters.toString());

        //return the square from a list of numbers
        List<Integer> listNumbers = Arrays.asList(2, 5, 6, 9);
        List<Integer> listSquares = listNumbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("List of squares: "+listSquares.toString());


        //creating two number's lists, and make a list with the pair of two
        List<Integer> listOne = Arrays.asList(1,2,3);
        List<Integer> listTwo = Arrays.asList(4,5);

        List<int []> listPairs = listOne.stream()
                .flatMap(i -> listTwo.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        System.out.println("Pairs list "+listPairs.toString());


        //checking boolean expressions anyMatch
        if(Dish.menu.stream().anyMatch(Dish::isVetarian)){
            System.out.println("there is vegetarian food");
        }


        //finding

        Optional<Dish> someDish = Dish.menu.stream()
                .filter(Dish::isVetarian)
                .findAny();
        System.out.println("any vegeterian food "+someDish.get());

        Dish.menu.stream()
                .filter(Dish::isVetarian)
                .findAny()
                .ifPresent(s -> System.out.println("the same "+s.getName()));


        //reduce, sum values

        List<Integer> numberList = Arrays.asList(1,2,3,4,5);
        int sum = numberList.stream()
                .reduce(0, (a , b) -> a+b);
        System.out.println("Sum "+sum);

        // the same but with a method reference

        int sumReference = numberList.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum with reference "+sumReference);

        // max and min

        int maxList = numberList.stream()
                .reduce(0, Integer::max)
                ;

        int minList = numberList.stream()
                .reduce(0, Integer::min);

        System.out.println("Mayor "+maxList+" Min "+minList);


        //sum of calories
        int sumCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum()
                ;

        System.out.println(sumCalories);

        //pythagoras not optimized

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );


        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                        .mapToObj(
                                b -> new double[]{a,b, Math.sqrt(a * a + b * b)}
                        ).filter(t -> t[2] % 1 == 0));

        System.out.println("-----------------------------");

        pythagoreanTriples2.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


        // counting dishes

        long dishesCount = Dish.menu.stream().count();
        System.out.println(dishesCount);


        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };

        IntSupplier pair = new IntSupplier(){
            private int number = 0;

            public int getAsInt(){

                this.number = this.number + 2;

                return this.number;
            }
        };

        System.out.println("--------------------------");

        IntStream.generate(pair).limit(20/2).forEach(System.out::println);
    }

}
