package september_2024;

public class PartitionList {

    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 9, 2, 4, 1, 0};

        int[] result = partitionList(nums, 3);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] partitionList(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] >= k && nums[end] <= k) {
                swap(nums, start, end);
            }
            if (nums[start] <= k) {
                start++;
            }
            if (nums[end] >= k) {
                end--;
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
