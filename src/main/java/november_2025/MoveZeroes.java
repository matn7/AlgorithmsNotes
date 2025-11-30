package november_2025;

public class MoveZeroes {

    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {1};
        int[] nums = {0, 1};
//        int[] nums = {1, 0};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println();
    }

    // O(n) time | O(1) space
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                if (r != l) {
                    swap(nums, l, r);
                }
                l++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
