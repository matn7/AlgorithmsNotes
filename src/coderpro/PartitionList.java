package coderpro;

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

        PartitionList partitionList = new PartitionList();
        List<Integer> result = partitionList.partition(arr, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public List<Integer> partition(List<Integer> nums, int k) {
        int low = 0;
        int high = nums.size() - 1;

        int i = 0;
        while (i <= high) {
            int n = nums.get(i);
            if (n > k) {
                swap(nums, high, i);
                high--;
            }
            if (n < k) {
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

    // O(n) time | O(1) space
    public List<Integer> partition2(List<Integer> nums, int k) {
//        arr.add(0, k);

//        int pivotIdx = 0;
        int left = 0;
        int right = nums.size() - 1;

        // [3, 8, 9, 2, 4, 1, 0]
        //  p     l        r
        while (left <= right) {
            if (nums.get(left) >= k && nums.get(right) < k) {
                swap(nums, left, right);
                left++;
                right--;
            }
            if (nums.get(left) < k) {
                left++;
            }
            if (nums.get(right) > k) {
                right--;
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
