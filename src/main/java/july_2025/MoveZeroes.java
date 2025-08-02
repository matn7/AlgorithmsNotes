package july_2025;

public class MoveZeroes {

    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
        int[] nums = {1};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println();

    }

    // O(n) time | O(1) space
    public void moveZeroes(int[] nums) {
        int posIdx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[posIdx] = num;
                posIdx++;
            }
        }
        for (int i = posIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
