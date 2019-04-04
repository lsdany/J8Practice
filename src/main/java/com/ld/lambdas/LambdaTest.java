package com.ld.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaTest{

    public static String readOneLineFile7() throws IOException {
        //old java 7 use, you only can read one line
        try(BufferedReader br = new BufferedReader(new FileReader("example.txt"))){
            return br.readLine();
        }
    }

    public static String readOneLineFile8(BufferReaderProcessor p) throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader("example.txt"))){
            return p.process(br);
        }
    }

    public static String readTwoLineFile() throws IOException{
        return readOneLineFile8((BufferedReader br) -> br.readLine() + br.readLine());
    }


    public static void main(String[] args) throws IOException {

        System.out.println(readTwoLineFile());

    }

}
