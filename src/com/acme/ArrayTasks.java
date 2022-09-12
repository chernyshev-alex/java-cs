package com.acme;

import java.util.HashMap;
import java.util.Map;

public class ArrayTasks {

    public int[] find2SumIndices(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap(); // num, pos
        for (int pos = 0; pos < nums.length; pos++) {
            Integer pos2  = map.get(target - nums[pos]);
            if (pos2 != null) {
                return new int[] { pos2, pos };
            }
            map.put(nums[pos], pos); // keep num & pos
        }
        return new int[] {};
    }

    public int findMaxArea(int[] height) {
        int best_area = 0;
        int x1 = 0, x2 = height.length -1;
        while (x1 < x2) {
            int area = Math.min(height[x1], height[x2]) * (x2 -x1);
            best_area = Math.max(area, best_area);
            if (height[x1] <= height[x2]) {
                x1++;
            } else {
                x2--;
            }
        }
        return best_area;
    }

    public int trappingRainWater(int[] height) {
        int result = 0;
        int l =0, r = height.length -1;
        int lmax = 0, rmax = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] > lmax) {
                    lmax = height[l];
                } else {
                    result += lmax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rmax) {
                    rmax = height[r];
                } else {
                    result += rmax -height[r];
                }
                r--;
            }
        }
        return  result;
    }
}
