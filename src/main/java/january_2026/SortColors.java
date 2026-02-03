package january_2026;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);

        System.out.println();
    }

    // O(n) time | O(1) space
    public void sortColors(int[] nums) {
        int i = 0; // track pos of 0
        int j = nums.length - 1; // track pos of 2
        int idx = 0; // pointer

        while (idx <= j) {
            if (nums[idx] == 0) {
                swap(nums, idx, i);
                i++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(nums, idx, j);
                j--;
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
