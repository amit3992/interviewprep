package com.interviewprep.heaps;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add initial numbers
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val); // Add to heap

        if (minHeap.size() > k) {
            minHeap.poll(); // Remove smallest if heap exceeds size k
        }

        return minHeap.peek(); // kth largest
    }

    public static void main(String[] args) {
    }
}
