package august_2024;

import java.util.ArrayList;
import java.util.List;

public class SortStackV2 {

    public static void main(String[] args) {
        int[] arr = {-5, 2, -2, 4, 3, 1};
        List<Integer> nums = new ArrayList<>();
        for (int a : arr) {
            nums.add(a);
        }

        List<Integer> integers = sortStack(nums);
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
            // [-5, 2], -2
            Integer largestElement = nums.get(nums.size() - 1);
            if (toAdd < largestElement) {
                Integer removed = nums.remove(nums.size() - 1);
                merge(nums, toAdd);
                nums.add(removed);
            } else {
                nums.add(toAdd);
            }
        }
    }

}
