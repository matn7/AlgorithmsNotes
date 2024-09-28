package problems.other;

import java.util.HashMap;
import java.util.Map;

public class SortingThreeUniqueNumbers {

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 1, 3, 2, 1};

        SortingThreeUniqueNumbers sortingThreeUniqueNumbers = new SortingThreeUniqueNumbers();
//        sortingThreeUniqueNumbers.sortNums2(nums);
        sortingThreeUniqueNumbers.sortNums(nums);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(1) space
    public int[] sortNums(int[] nums) {
        int one_index = 0;
        int three_index = nums.length - 1;
        int index = 0;
        while (index <= three_index) {
            if (nums[index] == 1) {
                swap(nums, index, one_index);
                one_index++;
                index++;
            }
            if (nums[index] == 2) {
                index++;
            }
            if (nums[index] == 3) {
                swap(nums, index, three_index);
                three_index--;
            }
        }
        return nums;
    }

    // O(n) time | O(n) space
    public int[] sortNums2(int[] nums) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }

        int counter = 0;
        for (int i = 1; i <= 3; i++) {
            Integer count = counts.get(i);
            for (int c = 0; c < count; c++) {
                nums[counter] = i;
                counter++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
