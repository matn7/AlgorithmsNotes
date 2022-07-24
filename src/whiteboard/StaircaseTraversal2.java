package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class StaircaseTraversal2 {

    public static void main(String[] args) {
        StaircaseTraversal2 staircaseTraversal2 = new StaircaseTraversal2();
        int result = staircaseTraversal2.staircaseTraversal(4, 2);
        System.out.println(result);
    }

    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        Map<Integer, Integer> memoize = new HashMap<>();
        return staircaseTraversalHelper(height, maxSteps, memoize);
    }

    private int staircaseTraversalHelper(int height, int maxSteps, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }
        if (height <= 1) {
            return 1;
        }

        int waysToTop = 0;
        for (int step = 1; step < Math.min(height, maxSteps) + 1; step++) {
            waysToTop += staircaseTraversalHelper(height - step, maxSteps, memoize);
        }
        memoize.put(height, waysToTop);
        return waysToTop;
    }

}
