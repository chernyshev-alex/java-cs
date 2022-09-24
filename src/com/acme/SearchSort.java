package com.acme;

import sun.misc.InnocuousThread;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SearchSort {

    void swap(int[] ar, int l, int r) {
        int t = ar[l];
        ar[l] = ar[r];
        ar[r] = t;
    }

    int partition(int[] ar, int l, int r) {
        int pivot = ar[r];
        int pidx = l;
        for (int i = l; i < r; i++) {
            if (ar[i] <= pivot) {
                swap(ar, i, pidx);
                pidx++;
            }
        }
        swap(ar, pidx, r);
        return pidx;
    };

    void qsort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            qsort(nums, l, p-1);
            qsort(nums, p+1, r);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        qsort(nums, 0, nums.length -1);
        return nums[nums.length-k];
    }

    public int findKthSmallest(int[] nums, int k) {
        for (int _k = 0; _k < k; _k++) {
            for (int i = _k; i < nums.length; i++) {
                if (nums[_k] > nums[i]) {
                    int t = nums[_k];
                    nums[_k] = nums[i];
                    nums[i] = t;
                }
            }
        }
        return  nums[k-1];
    }

    void __findKthSmallestQSort(int[] ints, int l, int r) {
        if (l < r) {
            int p = partition(ints, l, r);
            __findKthSmallestQSort(ints, l, p-1);
            __findKthSmallestQSort(ints, p+1, r);
        }
    }

    public int findKthSmallestQSort(int[] ints, int k) {
        __findKthSmallestQSort(ints, 0, ints.length-1);
        return ints[k-1];
    }

    public int findKthSmallestWithStream(int[] nums, int k) {
        return Arrays.stream(nums).sorted().toArray()[k-1];
    }

}
