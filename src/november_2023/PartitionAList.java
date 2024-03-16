package november_2023;

public class PartitionAList {

    public static void main(String[] args) {
        int[] nums = {8, 9, 2, 4, 1, 0, 99, 1, 1, 1, 89716};
        int k = 3;

        partitionListV2(nums, k);
    }

    // O(n) time | O(1) space
    public static int[] partitionList(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] > k && nums[end] < k) {
                swap(nums, start, end);
            }
            if (nums[start] <= k) {
                start++;
            }
            if (nums[end] >= k) {
                end--;
            }
        }
        // [1, 1, 2, 1, 1, 0, 99, 4, 9, 8, 89716]
        // [1, 1, 2, 1, 1, 0, 99, 4, 9, 89716, 8]
        return nums;
    }

    // O(n) time | O(1) space
    public static int[] partitionListV2(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        int i = 0;
        while (i <= end) {
            int n = nums[i];
            if (n > k) {
                swap(nums, end, i);
                end--;
            }
            if (n < k) {
                swap(nums, start, i);
                start++;
                i++;
            }
            if (n == k) {
                i++;
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
