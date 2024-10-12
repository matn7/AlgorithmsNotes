package september_2023;

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

        // [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
        //  *
        // seen = {1:T, 11:F, 3:T, 0:T, 15:F, 5:T, 2:T, 4:T, 10:F, 7:T, 12:F, 6:T}
        Map<Integer, Boolean> seen = new HashMap<>();
        for (int num : array) {
            seen.put(num, Boolean.FALSE);
        }
        int[] range = {0, 0};
        int maxRange = 0;
        for (int num : array) {
            if (seen.get(num)) {
                continue;
            }
            int currRangeLen = 1;
            seen.put(num, Boolean.TRUE);
            int numToLeft = num - 1; // 0
            while (seen.containsKey(numToLeft)) { // -1
                seen.put(numToLeft, Boolean.TRUE);
                currRangeLen++;
                numToLeft--;
            }
            int numToRight = num + 1;
            while (seen.containsKey(numToRight)) { // 8
                seen.put(numToRight, Boolean.TRUE);
                currRangeLen++;
                numToRight++;
            }
            numToLeft += 1;
            numToRight -= 1;
            if (currRangeLen > maxRange) {
                maxRange = currRangeLen;
                range[0] = numToLeft;
                range[1] = numToRight;
            }
        }
        return range;
    }

}
