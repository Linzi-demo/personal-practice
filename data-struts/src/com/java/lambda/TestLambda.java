package com.java.lambda;

public class TestLambda {

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.printf("hello world");

        r1.run();
    }
}
