package com.interviewprep.sort;

public class QuickSort {

    private int partition(int[] nums, int low, int high) {

        int start = low;
        int end = high;
        int mid = low + (high - low) / 2;
        int pivot = nums[mid];


        // partition
        while (start < end) {
            while (start < high && nums[start] <= pivot) {
                start++;
            }
            while (end > low && nums[end] > pivot) {
                end--;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        // swap pivot with end
        int temp = nums[end];
        nums[end] = nums[low];
        nums[low] = temp;

        // return pivot
        return end;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {5, 3, 1, 2, 4};
        quickSort.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
