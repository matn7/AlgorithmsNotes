package april_2024;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 2};
        int t = 11;

        int[] result = twoSum(nums, t);
        System.out.println();

        int[] result2 = twoSumV2(nums, t);
        System.out.println();

    }

    // O(n^2) time | O(1) space
    public static int[] twoSum(int[] nums, int t) {
        if (nums.length < 2) {
            return new int[] {-1, -1};
        }

        for (int p1 = 0; p1 < nums.length; p1++) {
            for (int p2 = p1 + 1; p2 < nums.length; p2++) {
                if (nums[p1] + nums[p2] == t) {
                    return new int[] {p1, p2};
                }
            }
        }
        return new int[] {-1, -1};
    }

    // O(n) time | O(n) space
    public static int[] twoSumV2(int[] nums, int t) {
        if (nums.length < 2) {
            return new int[] {-1, -1};
        }
        // [1, 3, 7, 9, 2]
        // k = 11 - 2 = 9
        // sumsMap = {1 : 0, 3 : 1, 7 : 2, 9 : 3}

        Map<Integer, Integer> sumsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = t - nums[i];
            if (sumsMap.containsKey(key)) {
                return new int[] {sumsMap.get(key), i};
            } else {
                sumsMap.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }

}
