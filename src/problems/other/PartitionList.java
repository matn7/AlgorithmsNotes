package problems.other;

import java.util.ArrayList;
import java.util.List;

public class PartitionList {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int[] nums = {8, 9, 1, 9, 2, 4, 1, 0};
        for (int n : nums) {
            arr.add(n);
        }
        int k = 3;

        // [0, 1, 1, 2, 9, 4, 9, 8]
        // [0, 1, 1, 2, 4, 9, 9, 8]

        PartitionList partitionList = new PartitionList();
        List<Integer> result = partitionList.partition(arr, k);
        System.out.println(result);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(1) space
    public List<Integer> partition(List<Integer> nums, int k) {

        //  0  1  2  3  4  5  6  7
        // [0, 1, 1, 2, 4, 9, 9, 8]
        //        l     h
        //              i

        int low = 0;
        int high = nums.size() - 1;

        int i = 0;
        while (i <= high) {
            int n = nums.get(i); // 4
            if (n > k) { // 4 > 3
                swap(nums, high, i);
                high--;
            }
            if (n < k) { // 1 < 3
                swap(nums, low, i);
                low++;
                i++;
            }
            if (n == k) {
                i++;
            }
        }
        return nums;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
