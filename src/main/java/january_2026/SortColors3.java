package january_2026;

public class SortColors3 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        SortColors3 sortColors3 = new SortColors3();
        sortColors3.sortColors(nums);


        System.out.println();
    }

    // O(n) time | O(1) space
    public void sortColors(int[] nums) {
        int idx = 0;
        int i = 0;
        int j = nums.length - 1;

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
