package com.acme;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumsTest {

    static Nums g;

    @org.junit.jupiter.api.BeforeAll
    static void setupAll() {   g = new Nums(); }

    @Test
    void testFindNumbers() {
        char result = g.firstNonRepeatedCharacter("geeksforgeeks");
        assertEquals('f', result);
    }

    @Test
    void testFindNumbersWithMap() {
        Optional<Character> result = g.firstNonRepeatedCharacterWithMap("geeksforgeeks");
        assertEquals('r', result.get() );
    }

    // Form the largest possible number from the array of number.
    @Test
    void testLargestNumber() {
        String result = g.findLargestNumber(Arrays.asList("54", "546", "548", "60"));
        assertEquals("6054854654", result);
    }

    @Test
    void testNumOfDigits() {
        assertEquals(g.numberOfDigits(10), 2);
        assertEquals(g.numberOfDigits(1000), 4);
    }

    // https://leetcode.com/problems/numbers-with-repeated-digits/
    // Given an integer n, return the number of positive integers in the range [1, n]
    // that have at least one repeated digit.
    // Input: n = 20  Output: 1
    // Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
    // Input: n = 100 Output: 10
    // Explanation: The positive numbers (<= 100) with at least 1 repeated digit
    // are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
    // Input: n = 1000; Output: 262
    @Test
    void testNumDupDigitsAtMostN() {
        assertEquals(g.numDupDigitsAtMostN(20), 1);
        assertEquals(g.numDupDigitsAtMostN(100), 10);
        assertEquals(g.numDupDigitsAtMostN(1000), 262);
    }

    @Test
    void testGenerateFiboNums() {
        assertEquals(Arrays.<Integer>asList(0, 1,1,2,3,5),  g.generateFibo(6).collect(Collectors.toList()));
    }

    @Test
    void testIsPrime() {
        assertEquals(true,  g.IsPrime(2));
        assertEquals(true,  g.IsPrime(3));
        assertEquals(true,  g.IsPrime(5));
        assertEquals(false,  g.IsPrime(4));
    }

    @Test
    void testIsPrimeStream() {
        assertEquals(true,  g.IsPrimeStream(2));
        assertEquals(true,  g.IsPrimeStream(3));
        assertEquals(true,  g.IsPrimeStream(5));
        assertEquals(false,  g.IsPrimeStream(4));
    }

    @Test
    void testIsPrimeErat() {
        assertEquals(true,  g.IsPrimeErat(2));
        assertEquals(true,  g.IsPrimeErat(3));
        assertEquals(true,  g.IsPrimeErat(5));
        assertEquals(false,  g.IsPrimeErat(4));
    }

    @Test
    void testGeneratePrime() {
        assertEquals(Arrays.<Integer>asList(2,3,5), g.generatePrime(6));
    }

    @Test
    void testCountSetBits() {
        assertEquals(2, g.countSetBits(6));
        assertEquals(3, g.countSetBits(13));
    }
}