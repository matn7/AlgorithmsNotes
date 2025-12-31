package december_2025;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        dutchNationalFlag.sortColors(nums);

        System.out.println();
    }

    public void sortColors(int[] nums) {
        int j = 0;
        int i = 0;
        int k = nums.length - 1;

        while (i <= k) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                j++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, k);
                k--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
