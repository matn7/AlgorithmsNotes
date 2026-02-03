package january_2026;

public class MoveZeroes {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};

        int[] nums = {1, 0};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }

    // O(n) time | O(1) space
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int pos = 0;

        for (int noZero = 0; noZero < nums.length; noZero++) {
            while (noZero < nums.length && nums[noZero] == 0) {
                noZero++;
            }
            if (noZero == nums.length) {
                break;
            }
            swap(pos, noZero, nums);
            pos++;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
