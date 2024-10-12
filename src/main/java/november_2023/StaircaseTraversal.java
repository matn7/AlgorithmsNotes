package november_2023;

import java.util.HashMap;
import java.util.Map;

public class StaircaseTraversal {

    public static void main(String[] args) {
        System.out.println(staircaseTraversal(4, 2));
    }

    // O(n) time | O(n) space
    public static int staircaseTraversal(int height, int maxSteps) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(0, 1);
        return staircaseTraversalHelper(height, maxSteps, memo);
    }

    private static int staircaseTraversalHelper(int height, int maxSteps, Map<Integer, Integer> memo) {
        if (memo.containsKey(height)) {
            return memo.get(height);
        }
        int res = 0;
        for (int step = 1; step < Math.min(height, maxSteps) + 1; step++) {
            res += staircaseTraversalHelper(height - step, maxSteps, memo);
        }
        memo.put(height, res);
        return res;
    }

}
