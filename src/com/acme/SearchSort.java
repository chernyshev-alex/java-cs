package com.acme;

public class SearchSort {

    void swap(int[] ar, int l, int r) {
        int t = ar[l];
        ar[l] = ar[r];
        ar[r] = t;
    }

    int partition(int[] ar, int l, int r) {
        int pivot = ar[r];
        int pidx = l;
        for (int i = l; i <  r; i++) {
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
}
