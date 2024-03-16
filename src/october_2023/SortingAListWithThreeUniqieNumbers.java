package october_2023;

public class SortingAListWithThreeUniqieNumbers {

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 1, 3, 2, 1};

        sortNumbers(nums);
    }

    // O(n) time | O(1) space
    public static int[] sortNumbers(int[] nums) {
        int startIdx = 0;
        int endIdx = nums.length - 1;
        int idx = 0;

        while (idx <= endIdx) {
            if (nums[idx] == 1) {
                swap(nums, idx, startIdx);
                idx++;
                startIdx++;
            } else if (nums[idx] == 3) {
                swap(nums, idx, endIdx);
                endIdx--;
            } else {
                idx++;
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
