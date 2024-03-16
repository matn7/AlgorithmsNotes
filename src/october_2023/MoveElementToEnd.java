package october_2023;

public class MoveElementToEnd {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 2, 2, 3, 4, 2};
        int k = 2;

        moveElementToEnd(nums, k);
    }

    // O(n) time | O(1) space
    public static int[] moveElementToEnd(int[] nums, int k) {
        int endIdx = nums.length - 1;
        int startIdx = 0;
        //        e
        // [4, 1, 3, 2, 2, 2, 2, 2]
        //           s
        while (startIdx <= endIdx) {
            while (nums[endIdx] == k) {
                endIdx--;
            }
            while (nums[startIdx] != k) {
                startIdx++;
            }
            if (endIdx < startIdx) {
                break;
            }
            swap(nums, startIdx, endIdx);
            startIdx++;
            endIdx--;
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
