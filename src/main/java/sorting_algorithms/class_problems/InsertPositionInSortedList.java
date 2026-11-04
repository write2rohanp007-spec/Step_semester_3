package sorting_algorithms.class_problems;

public class InsertPositionInSortedList {

    public static int searchInsertPosition(int[] nums, int target) {
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
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsertPosition(nums, 5));
        System.out.println(searchInsertPosition(nums, 2));

        int[] customNums = {10, 20, 30, 40, 50};
        System.out.println(searchInsertPosition(customNums, 25));
        System.out.println(searchInsertPosition(customNums, 50));
    }
}
