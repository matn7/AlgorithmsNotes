package hard;

import java.util.HashMap;
import java.util.Map;

public class LargestRangeREPEAT {

    public static void main(String[] args) {
        int[] array = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        largestRange(array);
    }

    // O(n) time | O(n) space
    // OK - repeated 31/01/2022
    public static int[] largestRange(int[] array) {
        // Write your code here.
        int[] bestRange = new int[2];
        int longestLength = 0;
        // nums = {
        //  1: TRUE, 11: TRUE, 3: TRUE, 0: TRUE,
        //  15: TRUE, 5: TRUE, 2: TRUE, 4: TRUE,
        //  10: TRUE, 7: TRUE, 12: TRUE, 6:TRUE
        // }
        Map<Integer, Boolean> nums = new HashMap<>();
        for (int num : array) {
            nums.put(num, Boolean.TRUE);
        }

        // nums = {
        //  1: FALSE, 11: FALSE, 3: FALSE, 0: FALSE,
        //  15: FALSE, 5: FALSE, 2: FALSE, 4: FALSE,
        //  10: FALSE, 7: FALSE, 12: FALSE, 6:FALSE
        // }
        //                                       *
        // [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
        for (int num : array) {
            if (!nums.get(num)) {
                continue;
            }
            nums.put(num, Boolean.FALSE);
            int currentLength = 1; // 1
            int left = num - 1; // 14
            int right = num + 1; // 16
            while (nums.containsKey(left)) {
                nums.put(left, Boolean.FALSE);
                currentLength++;
                left--;
            }
            while (nums.containsKey(right)) {
                nums.put(right, Boolean.FALSE);
                currentLength++;
                right++;
            }
            if (currentLength > longestLength) { // 1 > 8
                longestLength = currentLength; // 8
                bestRange[0] = left + 1; // [0,7]
                bestRange[1] = right - 1;
            }
        }

        return bestRange; // [0,7]
    }

}
