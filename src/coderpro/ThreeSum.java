package coderpro;

import java.util.*;

public class ThreeSum {

    // all values unique
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -4, -3};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSumHash(nums, 0);
        System.out.println();
    }

    public List<List<Integer>> threeSumIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            twoSumIndices(nums, i, result);
        }
        return result;
    }

    private void twoSumIndices(int[] nums, int start, List<List<Integer>> result) {
        int low = start + 1;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[start] + nums[low] + nums[high];
            if (sum == 0) {
                List<Integer> oneResult = new ArrayList<>();
                oneResult.add(nums[start]);
                oneResult.add(nums[low]);
                oneResult.add(nums[high]);
                result.add(oneResult);
                low++;
                high--;
            } else if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
    }

    public List<List<Integer>> threeSumHash(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            twoSumHashmap(nums, i, result);
        }
        return result;
    }

    private void twoSumHashmap(int[] nums, int start, List<List<Integer>> result) {
        Map<Integer, Boolean> values = new HashMap<>();
        int target = -nums[start];
        for (int i = start + 1; i < nums.length; i++) {
            int n = nums[i];
            int diff = target - n;
            if (values.containsKey(diff)) {
                List<Integer> oneResult = new ArrayList<>();
                oneResult.add(n);
                oneResult.add(diff);
                oneResult.add(nums[start]);
                result.add(oneResult);
            }
            values.put(n, Boolean.TRUE);
        }
    }

    // O(n^3) time | O(1) space
    public List<List<Integer>> threeSumBruteForce(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    if (nums[i1] + nums[i2] + nums[i3] == target) {
                        List<Integer> oneResult = new ArrayList<>();
                        oneResult.add(nums[i1]);
                        oneResult.add(nums[i2]);
                        oneResult.add(nums[i3]);
                        result.add(oneResult);
                    }
                }
            }
        }
        return result;
    }

    // O(n^2) time | O(log(n)) space
    public List<List<Integer>> threeSumMy(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        //  i   s            e
        // -4, -3, -1, 0, 1, 2

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[i]);
                    oneResult.add(nums[start]);
                    oneResult.add(nums[end]);
                    result.add(oneResult);
                    start++;
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

}
