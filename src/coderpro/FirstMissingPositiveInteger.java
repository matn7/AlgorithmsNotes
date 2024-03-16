package coderpro;

import udemy.leetcode.FirstAndLastOccurrencesOfTarget;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositiveInteger {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        FirstMissingPositiveInteger firstMissingPositiveInteger = new FirstMissingPositiveInteger();
        firstMissingPositiveInteger.firstMissingPosition(nums);
    }

    public int firstMissingPosition(int[] nums) {
        Map<Integer, Boolean> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, Boolean.TRUE);
        }
        for (int i = 1; i < nums.length; i++) {
            if (!hash.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    // O(n) time | O(n) space
    public int firstMissing(int[] nums) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        Map<Integer, Boolean> seen = new HashMap<>();

        for (int num : nums) {
            if (num < 0) {
                seen.put(num, Boolean.TRUE);
            } else {
                min = Math.min(min, num);
                max = Math.max(max, num);
                seen.put(num, Boolean.TRUE);
            }
        }

        for (int num = min; num <= max; num++) {
            if (!seen.containsKey(num)) {
                return num;
            }
        }
        return -1;
    }

    // O(n) time | O(n) space
    public int firstMissingPositiveInteger(int[] nums) {
        Map<Integer, Boolean> hash = new HashMap<>();
        for (int n : nums) {
            hash.put(n, Boolean.TRUE);
        }

        for (int i = 1; i < nums.length; i++) {
            if (!hash.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

}
