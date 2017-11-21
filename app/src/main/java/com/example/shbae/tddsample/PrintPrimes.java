package com.example.shbae.tddsample;//package function;

/*
 PrintPrimesTest 를 생성하여
 본 함수의 코드가 수정된다고 하더라도
 기능에 문제가 있는지를 확인할 수 있도록 한다.
 */

public class PrintPrimes {
    static final int numberOfPrimes = 1000;
    static final int linesPerPage = 50;
    static final int columns = 4;

    public static void main(String[] args) {
        PrimeGenerater primeGenerater = new PrimeGenerater();
        int primes[] = primeGenerater.generatePrimes(numberOfPrimes);
        NumberPrinter numberPrinter = new NumberPrinter(linesPerPage, columns);
        numberPrinter.print(primes, numberOfPrimes);
    }
}
