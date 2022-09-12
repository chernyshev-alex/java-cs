package com.acme;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {
//    Given the weights and values of N items, put these items in a knapsack of capacity W
//    to get the maximum total value in the knapsack.
//    In Fractional Knapsack, we can break items for maximizing the total value of the knapsack

//    Input: Items as (value, weight) pairs
//    arr[] = {{60, 10}, {100, 20}, {120, 30}}
//    Knapsack Capacity, W = 50
//    Output: Maximum possible value = 240
    @Test
    void testKnapsackProblemFractionAllowed() {
        List<Knapsack.ItemVal> ls = Arrays.asList(new Knapsack.ItemVal(500, 30));
        double result = new Knapsack().getMaxValueFractionAllowed(
                ls.toArray(new Knapsack.ItemVal[0]), 10);
        assertTrue(Math.abs(166.66 - result) < 0.01);

        ls = Arrays.asList(new Knapsack.ItemVal(60, 10),
                new Knapsack.ItemVal(100, 20),
                new Knapsack.ItemVal(120, 30));

        Knapsack.ItemVal[] ar2 = ls.toArray(new Knapsack.ItemVal[0]);
        result = new Knapsack().getMaxValueFractionAllowed(ar2, 50);
        assertEquals(240.0, result);
    }

    // Fraction not allowed !!!
    @Test
    void testKnapsackProblem() {
        List<Knapsack.ItemVal> ls = Arrays.asList(new Knapsack.ItemVal(60, 10),
                new Knapsack.ItemVal(100, 20),
                new Knapsack.ItemVal(120, 30));

        Knapsack.ItemVal[] ar2 = ls.toArray(new Knapsack.ItemVal[0]);
        double result = new Knapsack().getMaxValueOfKnapsack(ar2, 50);
        assertEquals(220.0, result);
    }

    @Test
    void testKnapsackProblem2() {
        List<Knapsack.ItemVal> ls = Arrays.asList(
                new Knapsack.ItemVal(1000, 1),
                new Knapsack.ItemVal(2000, 2));
              //  new KnapsackProblems.ItemVal(120, 3));

        Knapsack.ItemVal[] ar = ls.toArray(new Knapsack.ItemVal[0]);
        double result = new Knapsack().getMaxValueOfKnapsack(ar, 2);
        assertEquals(60, result);
    }

}