package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static void main(String[] args) {
        int[] array = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        int[] result = largestRange(array);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static int[] largestRange(int[] array) {
        // Write your code here.
        if (array.length == 1) {
            return new int[] {array[0], array[0]};
        }

        Map<Integer, Boolean> seen = new HashMap<>();
        for (int num : array) {
            seen.put(num, Boolean.FALSE);
        }

        int[] range = {-1, -1};

        for (int num : array) {
            if (seen.get(num)) {
                continue;
            }
            seen.put(num, Boolean.TRUE);
            int toLeft = num - 1;
            while (seen.containsKey(toLeft)) {
                seen.put(toLeft, Boolean.TRUE);
                toLeft--;
            }
            int toRight = num + 1;
            while (seen.containsKey(toRight)) {
                seen.put(toRight, Boolean.TRUE);
                toRight++;
            }

            int[] currentRange = {toLeft + 1, toRight - 1};
            if (currentRange[1] - currentRange[0] > range[1] - range[0]) {
                range[0] = currentRange[0];
                range[1] = currentRange[1];
            }
        }

        return range;
    }

}
