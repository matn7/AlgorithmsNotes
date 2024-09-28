package august_2024;

import java.util.ArrayList;
import java.util.List;

public class SortStack {

    public static void main(String[] args) {
        int[] nums = {-5, 2, -2, 4, 3, 1};
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }

        List<Integer> integers = sortStack(numsArr);
        System.out.println(integers);
    }

    // O(n^2) time | O(n) space
    public static List<Integer> sortStack(List<Integer> nums) {
        if (nums.size() == 0) {
            return nums;
        }
        sort(nums);
        return nums;
    }

    private static void sort(List<Integer> nums) {
        if (nums.isEmpty()) {
            return;
        }
        Integer removed = nums.remove(nums.size() - 1);
        sort(nums);
        merge(nums, removed);
    }

    private static void merge(List<Integer> nums, Integer toAdd) {
        if (nums.isEmpty()) {
            nums.add(toAdd);
        } else {
            Integer largest = nums.get(nums.size() - 1);
            if (largest > toAdd) {
                Integer removed = nums.remove(nums.size() - 1);
                merge(nums, toAdd);
                nums.add(removed);
            } else {
                nums.add(toAdd);
            }
        }
    }

}
