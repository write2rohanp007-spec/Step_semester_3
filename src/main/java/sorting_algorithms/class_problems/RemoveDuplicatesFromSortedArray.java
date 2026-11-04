package sorting_algorithms.class_problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, length)));

        int[] customNums = {5, 5, 5, 10, 10, 20, 20, 20, 30};
        int customLength = removeDuplicates(customNums);
        System.out.println("length = " + customLength);
        System.out.println("nums[0.." + (customLength - 1) + "] = " + Arrays.toString(Arrays.copyOf(customNums, customLength)));
    }
}
