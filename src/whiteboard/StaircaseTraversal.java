package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class StaircaseTraversal {

    // O(nk) time | O(n) space
    public int staircaseTraversalDP(int height, int maxSteps) {
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;
        for (int currHeight = 2; currHeight < height + 1; currHeight++) {
            int step = 1;
            while (step <= maxSteps && step <= currHeight) {
                waysToTop[currHeight] = waysToTop[currHeight] + waysToTop[currHeight - step];
                step++;
            }
        }
        return waysToTop[height];
    }

//    // O(n) time | O(n) space (sliding window)
//    public int staircaseTraversal(int height, int maxSteps) {
//        // Write your code here.
//        int currNum = 0;
//        int[] waysToTop = new int[height + 1];
//        waysToTop[0] = 1;
//        int counter = 1;
//        for (int currHeight = 1; currHeight < height + 1; currHeight++) {
//            int startOfWindow = currHeight - maxSteps - 1;
//            int endOfWindow = currHeight - 1;
//            if (startOfWindow >= 0) {
//                currNum -= waysToTop[startOfWindow];
//            }
//            currNum += waysToTop[endOfWindow];
//            waysToTop[counter] = currNum;
//            counter++;
//        }
//        return waysToTop[height];
//    }

    // O(n) time | O(n) space
    // rand: 15/07/2022 - 28/07/2022
    public int staircaseTraversalMemo(int height, int maxSteps) {
        // Write your code here.
        Map<Integer, Integer> memoize = new HashMap<>();
        return numberOfWaysToTop(height, maxSteps, memoize);
    }

    private int numberOfWaysToTop(int height, int maxSteps, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }
        if (height <= 1) {
            return 1;
        }
        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberOfWaysToTop(height - step, maxSteps, memoize);
        }
        memoize.put(height, numberOfWays);
        return numberOfWays;
    }


}
