package may_2024;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 1, 8, 7, 2, 4};

        selectionSort(nums);
        System.out.println(nums);
    }

    // O(n^2) time | O(1) space
    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
