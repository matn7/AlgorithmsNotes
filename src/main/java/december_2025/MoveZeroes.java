package december_2025;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println();
    }
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j == nums.length) {
                break;
            }
            swap(nums, i, j);
            i++;
            j++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
