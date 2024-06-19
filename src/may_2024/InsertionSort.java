package may_2024;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 1, 8, 7, 2, 4};

        insertionSort(nums);
        System.out.println();
    }

    // O(n^2) time | O(1) space
    public static int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
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
