package november_2024;

import java.util.WeakHashMap;

public class MoveZeroes {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};

        int[] nums = {1, 0};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        int posIdx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[posIdx] = num;
                posIdx++;
            }
        }
        for (int i = posIdx; i < nums.length; i++) {
            nums[posIdx] = 0;
        }

    }


}
