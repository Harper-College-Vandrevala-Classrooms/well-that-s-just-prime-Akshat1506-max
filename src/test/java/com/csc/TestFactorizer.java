package com.csc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFactorizer {

    Factorizer factorizer;

    @BeforeEach
    void setUp() {
        factorizer = new Factorizer();
    }

    @Test
    public void testPrimeFactorsZero() {
        System.out.println("Running testPrimeFactorsZero...");
        assertNull(factorizer.primeFactors(0)); // Expect null for input 0
    }

    @Test
    public void testPrimeFactorsOne() {
        System.out.println("Running testPrimeFactorsOne...");
        assertNull(factorizer.primeFactors(1)); // Expect null for input 1
    }

    @Test
    public void testPrimeFactorsTen() {
        System.out.println("Running testPrimeFactorsTen...");
        List<Integer> expected = Arrays.asList(2, 5);
        assertEquals(expected, factorizer.primeFactors(10)); // Prime factors of 10 are 2 and 5
    }

    @Test
    public void testPrimeFactorsTwentyFour() {
        System.out.println("Running testPrimeFactorsTwentyFour...");
        List<Integer> expected = Arrays.asList(2, 2, 2, 3);
        assertEquals(expected, factorizer.primeFactors(24)); // Prime factors of 24 are 2, 2, 2, 3
    }

    @Test
    public void testIsPrime() {
        System.out.println("Running testIsPrime...");
        assertTrue(factorizer.isPrime(17)); // 17 is a prime number
        assertTrue(!factorizer.isPrime(12)); // 12 is not a prime number
    }

    @Test
    public void testReduce() {
        System.out.println("Running testReduce...");
        assertEquals("3", factorizer.reduce(36, 12)); // Simplifies to 3
        assertEquals("1", factorizer.reduce(12, 12)); // Simplifies to 1
        assertEquals("6/7", factorizer.reduce(12, 14)); // Simplifies to 6/7
        assertEquals("12/37", factorizer.reduce(12, 37)); // Cannot be simplified
    }
}
