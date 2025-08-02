package july_2025;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NextPermutation2 nextPermutation2 = new NextPermutation2();
        nextPermutation2.nextPermutation(nums);

        System.out.println();

    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }


    private void backtrack(int[] nums, boolean[] pick, List<Integer> part, List<List<Integer>> result) {
        if (part.size() == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!pick[j]) {
                pick[j] = true;
                part.add(nums[j]);
                backtrack(nums, pick, part, result);
                pick[j] = false;
                part.remove(part.size() - 1);
            }
        }
    }

}
