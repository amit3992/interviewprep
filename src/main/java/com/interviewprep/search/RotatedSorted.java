package com.interviewprep.search;

public class RotatedSorted {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSorted rotatedSorted = new RotatedSorted();
        System.out.println(rotatedSorted.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
