package april_2025;

public class PartitionArr {

    public static void main(String[] args) {
        PartitionArr partitionArr = new PartitionArr();
        int[] nums = {8, 9, 2, 4, 1, 0};
        int k = 3;

        int[] result = partitionArr.partitionArr(nums, k);
        System.out.println(result);
    }

    public int[] partitionArr(int[] nums, int k) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            if (nums[L] >= k && nums[R] <= k) {
                swap(nums, L, R);
            }
            if (nums[L] <= k) {
                L++;
            }
            if (nums[R] >= k) {
                R--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
