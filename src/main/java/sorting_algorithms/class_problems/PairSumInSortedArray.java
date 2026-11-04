package sorting_algorithms.class_problems;

public class PairSumInSortedArray {

    public static String pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return "(" + nums[left] + ", " + nums[right] + ")";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        int[] nums2 = {1, 2, 3};

        System.out.println(pairSumSorted(nums1, 4));
        System.out.println(pairSumSorted(nums2, 100));

        int[] customNums = {1, 2, 4, 6, 8, 10};
        System.out.println(pairSumSorted(customNums, 12));
    }
}
