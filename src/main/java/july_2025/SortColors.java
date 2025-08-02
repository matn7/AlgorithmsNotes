package july_2025;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);

        System.out.println();

    }

    // O(n) time | O(1) space
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                i++;
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
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
