package april_2025;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(nums);
    }

    // O(n) time | O(1) space
    public void sortColors(int[] nums) {
        int idx = 0;
        int L = 0;
        int R = nums.length - 1;

        while (idx <= R) {
            if (nums[idx] == 0) {
                swap(nums, idx, L);
                idx++;
                L++;
            } else if (nums[idx] == 2) {
                swap(nums, idx, R);
                R--;
            } else {
                idx++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
