package hard;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static void main(String[] args) {
        int[] array = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        largestRange(array);
    }

    // O(n) time | O(n) space
    public static int[] largestRange(int[] array) {
        // Write your code here.
        int[] bestRange = new int[2];
        int longestLength = 0;
        Map<Integer, Boolean> nums = new HashMap<>();
        for (int num : array) {
            nums.put(num, Boolean.TRUE);
        }

        for (int num : array) {
            if (!nums.get(num)) {
                continue;
            }
            nums.put(num, Boolean.FALSE);
            int currentLength = 1;
            int left = num - 1;
            int right = num + 1;
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
            if (currentLength > longestLength) {
                longestLength = currentLength;
                bestRange[0] = left + 1;
                bestRange[1] = right - 1;
            }
        }

        return bestRange;
    }
}
