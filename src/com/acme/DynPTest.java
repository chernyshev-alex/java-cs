package com.acme;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DynPTest {
//    Given the weights and values of N items, put these items in a knapsack of capacity W
//    to get the maximum total value in the knapsack.
//    In Fractional Knapsack, we can break items for maximizing the total value of the knapsack

//    Input: Items as (value, weight) pairs
//    arr[] = {{60, 10}, {100, 20}, {120, 30}}
//    Knapsack Capacity, W = 50
//    Output: Maximum possible value = 240
    @Test
    void testKnapsackProblemFractionAllowed() {
        List<DynP.KnapSackItem> ls = Arrays.asList(new DynP.KnapSackItem(500, 30));
        double result = new DynP().getMaxValueFractionAllowed(
                ls.toArray(new DynP.KnapSackItem[0]), 10);
        assertTrue(Math.abs(166.66 - result) < 0.01);

        ls = Arrays.asList(new DynP.KnapSackItem(60, 10),
                new DynP.KnapSackItem(100, 20),
                new DynP.KnapSackItem(120, 30));

        DynP.KnapSackItem[] ar2 = ls.toArray(new DynP.KnapSackItem[0]);
        result = new DynP().getMaxValueFractionAllowed(ar2, 50);
        assertEquals(240.0, result);
    }

    // Fraction not allowed !!!
    @Test
    void testKnapsackProblem() {
        List<DynP.KnapSackItem> ls = Arrays.asList(new DynP.KnapSackItem(60, 10),
                new DynP.KnapSackItem(100, 20),
                new DynP.KnapSackItem(120, 30));

        DynP.KnapSackItem[] ar2 = ls.toArray(new DynP.KnapSackItem[0]);
        double result = new DynP().getMaxValueOfKnapsack(ar2, 50);
        assertEquals(220.0, result);
    }

    @Test
    void testKnapsackProblem2() {
        List<DynP.KnapSackItem> ls = Arrays.asList(
                new DynP.KnapSackItem(1000, 1),
                new DynP.KnapSackItem(2000, 2));
              //  new KnapsackProblems.ItemVal(120, 3));

        DynP.KnapSackItem[] ar = ls.toArray(new DynP.KnapSackItem[0]);
        double result = new DynP().getMaxValueOfKnapsack(ar, 2);
        assertEquals(60, result);
    }

    @Test
    //TODO
    void testMissingRolls() {
       // int[] -> int[] A, int F, int M
        int[] result = new DynP().missingRolls(new int[0], 1, 1);
        //assertEquals(60, result);
    }

}