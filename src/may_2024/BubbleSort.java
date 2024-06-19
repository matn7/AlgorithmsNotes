package may_2024;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 1, 8, 7, 2, 4};

        bubbleSort(nums);

        System.out.println(nums);
    }

    // O(n^2) time | O(1) space
    public static int[] bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
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
