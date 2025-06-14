package com.interviewprep.arrays;

import java.util.HashSet;

public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
        // Add data from nums to a hashset
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxLength = 0;

        for(int num : nums) {

            if(!set.contains(num - 1)) {
                int currentNumber = num;
                int currentLen = 1;

                while(set.contains(currentNumber + 1)) {
                    currentNumber += 1;
                    currentLen += 1;
                }

                maxLength = Math.max(maxLength,currentLen);

            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSeq longestConsecutiveSeq = new LongestConsecutiveSeq();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutiveSeq.longestConsecutive(nums);
        System.out.println(result);

        int [] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        result = longestConsecutiveSeq.longestConsecutive(nums1);
        System.out.println(result);
    }
}
