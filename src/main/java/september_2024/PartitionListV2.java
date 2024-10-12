package september_2024;

public class PartitionListV2 {

    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 9, 2, 4, 1, 0};
        int k = 3;

//        int[] result = partitionList(nums, k);
        System.out.println();

        int[] result1 = partitionListV2(nums, k);
        System.out.println();
    }

    public static int[] partitionListV2(int[] nums, int k) {
        int high = nums.length - 1;
        int low = 0;
        int i = 0;

        while (i <= high) {
            int num = nums[i]; // 8
            if (num > k) {
                swap(nums, i, high);
                high--;
            }
            if (num < k) {
                swap(nums, i, low);
                low++;
                i++;
            }
            if (num == k) {
                i++;
            }
        }
        return nums;
    }

    // O(n) time | O(1) space
    public static int[] partitionList(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
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
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
