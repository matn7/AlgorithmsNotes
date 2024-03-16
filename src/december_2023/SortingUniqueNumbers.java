package december_2023;

public class SortingUniqueNumbers {

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 1, 3, 2, 1};

        int[] result = sorting(nums);
    }

    // O(n) time | O(1) space
    public static int[] sorting(int[] nums) {
        // [1, 1, 2, 2, 3, 3, 3]
        //        s
        //              i
        //              e
        int start = 0;
        int idx = 0;
        int end = nums.length - 1;
        while (idx <= end) {
            if (nums[idx] == 1) {
                swap(nums, idx, start);
                start++;
                idx++;
            } else if (nums[idx] == 2) {
                idx++;
            } else {
                swap(nums, idx, end);
                end--;
            }
        }
        return nums;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
