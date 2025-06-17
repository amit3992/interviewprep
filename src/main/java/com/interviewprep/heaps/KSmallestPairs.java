package com.interviewprep.heaps;

import java.util.*;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
        );

        // Start with pairs (i, 0) for i = 0 to Math.min(k, nums1.length)
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[0], j = pair[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }


    public static void main(String[] args) {
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
}
