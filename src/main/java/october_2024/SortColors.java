package october_2024;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(nums);
    }

    public void sortColors(int[] nums) {
        int idx = 0;
        int l = 0;
        int r = nums.length - 1;

        while (idx <= r) {
            if (nums[idx] == 0) {
                swap(l, idx, nums);
                l++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(r, idx, nums);
                r--;
            } else {
                idx++;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
