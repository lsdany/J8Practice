package com.ld.streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));


        // Number 1  Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> t2011 = transactions.stream()
                .filter(d -> d.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(t2011);

        // Number 2 What are all the unique cities where the traders work?

        List<String> tCities = transactions.stream()
                .map(s -> s.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(tCities);

        // Number 3 Find all traders from Cambridge and sort them by name.

        List<Trader> tTraders = transactions.stream()
                .filter(c -> c.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(t -> t.getName()))
                .collect(Collectors.toList());

        System.out.println(tTraders);

        //Number 4 Return a string of all traders’ names sorted alphabetically.
        String names = transactions.stream()
                .map(c -> c.getTrader().getName())
                .distinct()
                .sorted(Comparator.comparing(t -> t))
                .collect(Collectors.joining(" "));

        System.out.println(names);


        //Number 5, Are any traders based in Milan?
        boolean inMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(inMilan);


        //Number 6, Print all transactions’ values from the traders living in Cambridge.
        List<Integer> transLiveInCambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        System.out.println(transLiveInCambridge);

        //Number 7,  What’s the highest value of all the transactions?
        int maxValue = transactions.stream()
                .map(t -> t.getValue())
                .reduce(0, Integer::max);

        System.out.println(maxValue);

        //Number 8, Find the transaction with the smallest value.

        Transaction minValue = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)).get();

        System.out.println(minValue.toString());


    }

}
