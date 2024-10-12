package october_2023;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 0, 1, 1, 2, 0, 0, 0, 1, 0, 0, 0};

        sortColors(nums);
        System.out.println(nums);

    }

    // O(n) time | O(1) space
    public static int[] sortColors(int[] nums) {
        //                       l
        // [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2]
        //                                   r
        //                                    idx
        int left = 0;
        int idx = 0;
        int right = nums.length - 1;
        while (idx <= right) {
            if (nums[idx] == 0) {
                swap(nums, left, idx);
                left++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(nums, right, idx);
                right--;
            } else {
                idx++;
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
