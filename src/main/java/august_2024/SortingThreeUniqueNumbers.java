package august_2024;

public class SortingThreeUniqueNumbers {

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 1, 3, 2, 1};

        int[] result = sortUniqueNums(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] sortUniqueNums(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int ptr = 0;

        while (ptr <= last) {
            if (nums[ptr] == 1) {
                swap(nums, ptr, first);
                ptr++;
                first++;
            } else if (nums[ptr] == 3) {
                swap(nums, ptr, last);
                last--;
            } else {
                ptr++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
