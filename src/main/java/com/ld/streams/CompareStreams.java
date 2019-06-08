package com.ld.streams;

import com.ld.domain.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.awt.print.Book;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompareStreams {

    public static void main(String[] args) {
        Books book1 = Books.builder().id("1").name("viaje al centro de la tierra").build();
        Books book2= Books.builder().id("2").name("la ciudad sin nombre").build();
        Books book3 = Books.builder().id("3").name("la traicion de roma").build();
        Books book4 = Books.builder().id("4").name("la guerra y la paz").build();
        Books book5 = Books.builder().id("5").name("crimen y castigo").build();

        List<Books> books1 = Arrays.asList(book1, book2, book3, book4, book5);
        List<Books> books2 = Arrays.asList(book2, book5);

        List<String> booksByName1 = books1.stream()
                .map(Books::getName)
                .collect(Collectors.toCollection(ArrayList::new));

        List<String> booksByName2 = books2.stream()
                .map(Books::getName)
                .collect(Collectors.toCollection(ArrayList::new));


        Collection<Books> test = CollectionUtils.disjunction(books1, books2);
        test.forEach(t -> System.out.println(t.toString()));

//        books1.stream()
//                .map(Books::getName)
//                .forEach(System.out::println);
//
//        books2.stream()
//                .map(Books::getName)
//                .filter( b -> books2.stream()
//                        .map(Books::getName).allMatch(s -> s.equalsIgnoreCase(b)))
//        .forEach(System.out::println);


        List<String> list1 = Arrays.asList("1","2","3","4","5");
        List<String> list2 = Arrays.asList("1","2","3");


//        Predicate<String> notIn2 = s -> ! list2.stream().anyMatch(mc -> s.equals(mc));
//        List<String> list3 = list1.stream().filter(notIn2).collect(Collectors.toList());

//        List<String> repetedItems =
//                list2.stream()
//                .filter(l -> !list2.contains(l))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

//        System.out.println(repetedItems);

// stream the list and use the set to filter it
//        List<String> unavailable = list1.stream()
//                .filter(e -> repetedItems.contains(e))
//                .collect(Collectors.toList());

    }

}
