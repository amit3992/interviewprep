package com.interviewprep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {


    public List<List<Integer>> subsetSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;
        backtrackAndAvoidDuplicates(nums, 0, target, current, result);
        return result;
    }

    private void backtrack(int[] nums, int start, int target, List<Integer> current, List<List<Integer>> result) {
        // Bounding function
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (target >= nums[i]) {
                current.add(nums[i]);
                backtrack(nums, i, target - nums[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private void backtrackAndAvoidDuplicates(int[] nums, int start, int target, List<Integer> current, List<List<Integer>> result) {
        // Bounding function
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            // Step 2: Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, target - nums[i], current, result);
            current.remove(current.size() - 1);  // Backtrack
        }
    }

    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int[] nums = {5, 10, 12, 13, 15, 18};
        int target = 30;
        List<List<Integer>> result = subsetSum.subsetSum(nums, target);
        System.out.println(result);
    }
}
