package com.csc;

import java.util.ArrayList;
import java.util.List;

public class Factorizer {

    // Method to calculate prime factors of a given number
    public List<Integer> primeFactors(int number) {
        if (number <= 1) {
            return null; // Return null for numbers less than or equal to 1
        }

        List<Integer> factors = new ArrayList<>();
        
        // Check for number of 2s that divide number
        while (number % 2 == 0) {
            factors.add(2);
            number /= 2;
        }

        // Check for odd factors from 3 onwards
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }

        // If the remaining number is a prime number greater than 2
        if (number > 2) {
            factors.add(number);
        }

        return factors;
    }

    // Method to check if a number is prime
    public boolean isPrime(int number) {
        List<Integer> factors = primeFactors(number);
        return factors != null && factors.size() == 1 && factors.get(0) == number;
    }

    // Method to reduce a fraction using prime factors
    public String reduce(int numerator, int denominator) {
        if (denominator == 0) {
            return "Undefined"; // Division by zero is undefined
        }

        List<Integer> numFactors = primeFactors(numerator);
        List<Integer> denFactors = primeFactors(denominator);

        if (numFactors == null || denFactors == null) {
            return "0";
        }

        // Remove common factors
        for (Integer factor : numFactors) {
            if (denFactors.contains(factor)) {
                denFactors.remove(factor);
                numerator /= factor;
                denominator /= factor;
            }
        }

        if (denominator == 1) {
            return String.valueOf(numerator); // Return simplified numerator if denominator is 1
        }

        return numerator + "/" + denominator;
    }
}