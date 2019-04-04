package com.ld.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    static List<Integer> numbersList = Arrays.asList(100,
            158260522,
            877914575,
            602436426,
            24979445,
            861648772,
            623690081,
            433933447,
            476190629,
            262703497,
            211047202,
            971407775,
            628894325,
            731963982,
            822804784,
            450968417,
            430302156,
            982631932,
            161735902,
            880895728);

    static List<Integer> numbersList2 = Arrays.asList(2,9,8);


    /*
     * Complete the divisors function below.
     */
    static int divisors(int n) {
        /*
         * Write your code here.
         */
        List<Integer> listDiv = new ArrayList<>();
        for(int i =1 ; i <= n ; i++){

            //es divisor
            if(n % i == 0){
                listDiv.add(i);
            }
        }

        int counter = 0;

        for(Integer i : listDiv){

            if(i % 2 == 0){
                counter++;
            }

        }

        return counter;

    }

    static int divisors4(int n) {
        /*
         * Write your code here.
         */


        IntSupplier pair = new IntSupplier(){
            private int number = 0;

            public int getAsInt(){

                this.number = this.number + 2;

                return this.number;
            }
        };



        return (int)IntStream.generate(pair)
                .limit(n/2)
                .parallel()
                .filter(t -> n % t == 0 && t % 2 == 0)
                .count();

    }


    static int divisors2(int n) {
        /*
         * Write your code here.
         */

        return IntStream.rangeClosed(1, n)
                .map(t -> n % t == 0 ? t : 0)
                .filter(t -> t != 0)
                .map(t -> t % 2 == 0 ? t : 0)
                .filter(t -> t != 0)
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);

        //return 0;

    }


    public static int divisors3(int n){


        return (int)IntStream.rangeClosed(1, n)
                .parallel()
                .filter(t -> n % t == 0 && t % 2 == 0)
                .count();


    }


    //de momento el mas rapido
    public static int divisors5(int n){

        int limit = new Double( Math.floor(Math.sqrt(n))).intValue();

        return IntStream.rangeClosed(1, limit)
                .parallel()
                .filter(t -> n % t == 0 && t % 2 == 0)
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);


    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int t = Integer.parseInt(scanner.nextLine().trim());


        long time_start, time_end;
        time_start = System.currentTimeMillis();
        for(Integer i : numbersList){
            System.out.println(divisors5(i));
        }

//        System.out.println(divisors5(31));
//        System.out.println(divisors5(30));

        time_end = System.currentTimeMillis();
        System.out.println("the task has taken "+ ( time_end - time_start )/1000 +" seconds");



    }
}