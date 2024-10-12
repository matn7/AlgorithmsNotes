package october_2023;

import java.util.HashMap;
import java.util.Map;

public class FindPytharogeanTriplets {

    public static void main(String[] args) {
        int[] nums = {3, 5, 12, 5, 13};

        findTriplets(nums);
    }

    // O(n^2) time | O(n) space
    public static boolean findTriplets(int[] nums) {
        Map<Integer, Boolean> squareCache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int square = nums[i] * nums[i];
            squareCache.put(square, Boolean.TRUE); // [9, 25, 144, 25, 169]
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[i] + nums[j] * nums[j];
                if (squareCache.containsKey(key)) {
                    return true;
                }
            }
        }
        return false;

    }

}
