package july_2025;

public class SortColors2 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors2 sortColors2 = new SortColors2();
        sortColors2.sortColors(nums);
        System.out.println();
    }

    // O(n) time | O(1) space
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int idx = 0;
        //      idx
        // [0,0,1,1,2,2]
        //      i   j

        while (idx <= j) {
            if (nums[idx] == 0) {
                swap(i, idx, nums);
                idx++;
                i++;
            } else if (nums[idx] == 1) {
                idx++;
            } else {
                swap(j, idx, nums);
                j--;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
