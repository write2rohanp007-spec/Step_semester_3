package sorting_algorithms.class_problems;

import java.util.HashSet;

public class PairWithTargetSum {

    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 4, 6};

        System.out.println(hasPairWithSum(nums1, 9));
        System.out.println(hasPairWithSum(nums2, 20));

        int[] customNums = {-3, 1, 4, 7, 10};
        System.out.println(hasPairWithSum(customNums, 1));
    }
}
