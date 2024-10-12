package november_2023;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static void main(String[] args) {
        int[] arr = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        largestRange(arr);
    }

    // O(n) time | O(n) space
    public static int[] largestRange(int[] arr) {
        Map<Integer, Boolean> seen = new HashMap<>();
        for (int n : arr) {
            seen.put(n, Boolean.FALSE);
        }
        int[] result = new int[] {0, 0};

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (seen.get(curr)) {
                continue;
            }
            int currLen = 1;
            seen.put(curr, Boolean.TRUE);
            int toLeft = curr - 1;
            while (seen.containsKey(toLeft)) {
                seen.put(toLeft, Boolean.TRUE);
                toLeft--;
                currLen++;
            }

            int toRight = curr + 1;
            while (seen.containsKey(toRight)) {
                seen.put(toRight, Boolean.TRUE);
                toRight++;
                currLen++;
            }

            if (currLen > result[1] - result[0]) {
                result[0] = toLeft + 1;
                result[1] = toRight - 1;
            }

        }

        return result;
    }

}
