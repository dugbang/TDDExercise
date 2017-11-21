package com.example.shbae.tddsample;

/**
 * Created by shbae on 2017-11-15.
 */
public class PrimeGenerater {

    private static int[] primes;
    private static int candidate;
    private static int ord;
    private static int square;
    private static boolean possiblyPrime;
    private static int[] multiples;

    public static int[] generatePrimes(int numberOfPrimes) {
        final int ordmax = 30;
        primes = new int[numberOfPrimes + 1];

        int primeIndex;
        multiples = new int[ordmax + 1];
        candidate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;
        while (primeIndex < numberOfPrimes) {
            findNextPrime();
            primeIndex = primeIndex + 1;
            primes[primeIndex] = candidate;
        }
        return primes;
    }

    private static void findNextPrime() {
        int n;
        do {
            candidate = candidate + 2;
            if (candidate == square) {
                ord = ord + 1;
                square = primes[ord] * primes[ord];
                multiples[ord - 1] = candidate;
            }
            n = 2;
            possiblyPrime = true;
            while (n < ord && possiblyPrime) {
                while (multiples[n] < candidate)
                    multiples[n] = multiples[n] + primes[n] + primes[n];
                if (multiples[n] == candidate)
                    possiblyPrime = false;
                n = n + 1;
            }
        } while (!possiblyPrime);
    }
}
