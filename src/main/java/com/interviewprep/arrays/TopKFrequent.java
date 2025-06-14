package com.interviewprep.arrays;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket sort by frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        // Step 3: Gather top K frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null)
                result.addAll(bucket[i]);
        }

        // Convert to array and return first k elements
        int[] topK = new int[k];
        for (int i = 0; i < k; i++)
            topK[i] = result.get(i);
        return topK;
    }


    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        // System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 2}, 2)));
    }
}
