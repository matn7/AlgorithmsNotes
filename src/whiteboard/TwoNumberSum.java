package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    // O(n) time | O(n) space
    // #2: 09/07/2022
    // rand: 27/09/2022
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.

        Map<Integer, Boolean> seen = new HashMap<>();
        for (int element : array) {
            int sum = targetSum - element;
            if (seen.containsKey(sum)) {
                int[] res = {sum, element};
                return res;
            } else {
                seen.put(element, Boolean.TRUE);
            }
        }

        return new int[0];
    }

}
