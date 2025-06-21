package com.interviewprep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SumProblems {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int complement = target - nums[low];
            if (nums[low] + nums[high] == complement) {
                result[0] = low;
                result[1] = high;
                return result;
            } else if (nums[low] + nums[high] < complement) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

    /*
    *  Sum of nums[i] + nums[j] + nums[k] == 0
    * */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        SumProblems sumProblems = new SumProblems();
        int [] result = sumProblems.twoSum(new int[]{2, 7, 11, 15}, 9);
        int [] result2 = sumProblems.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + " " + result[1]);
        System.out.println(result2[0] + " " + result2[1]);

        List<List<Integer>> threeSumResult = sumProblems.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : threeSumResult) {
            System.out.println(list);
        }
    }
}
