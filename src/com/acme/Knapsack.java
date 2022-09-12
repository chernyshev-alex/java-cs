package com.acme;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    static class ItemVal {
        int value, weight;
        public ItemVal(int val, int wt)  {
            this.weight = wt;
            this.value = val;
        }
    }

   Comparator<ItemVal> itemValCompF = (ItemVal o1, ItemVal o2) -> {
        double c1 = o1.value / o1.weight;
        double c2 = o2.value / o2.weight;
        return c1 < c2 ? 1 : -1;
    };

    double getMaxValueFractionAllowed(ItemVal[] items, int capacity) {
        Arrays.sort(items, itemValCompF);

        double maxPossibleValue = 0d;
        for (ItemVal item : items) {
            if (capacity >= item.weight) {
                // this weight can be picked while
                capacity -= item.weight;
                maxPossibleValue += item.value;
            } else {
                // item cant be picked whole
                double fraction = capacity / (double) item.weight;
                maxPossibleValue += item.value * fraction;
                break;
            }
        }
        return maxPossibleValue;
    }

    // Fraction NOT Allowed, DP time complexity= O(N*W), Auxiliary Space: O(W)
    public double getMaxValueOfKnapsack(ItemVal[] items, int capacity) {
        int[] dp = new int[capacity+1];
        for (int i = 1; i <= items.length; i++) {
            for (int w = capacity; w >= 0 ; w--) {
                ItemVal prev = items[i-1];
                if (prev.weight <= w) {
                    dp[w] = Math.max(dp[w], dp[w - prev.weight] + prev.value);
                }
                System.out.println(String.format("%d), {%d,%d} [w]=%d %s"
                        ,i, prev.weight, prev.value, w, Arrays.toString(dp)));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[capacity];
    }
}
