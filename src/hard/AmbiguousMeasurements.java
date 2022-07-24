package hard;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousMeasurements {

    public static void main(String[] args) {
        int[][] measuringCups = {
                {200,210},
                {450,465},
                {800,850}
        };

        AmbiguousMeasurements ambiguousMeasurements = new AmbiguousMeasurements();
        boolean result = ambiguousMeasurements.ambiguousMeasurements(measuringCups, 2100, 2300);

        System.out.println(result);
    }

    // O(low*high*n) time | O(low*high) space
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        // Write your code here.
        Map<String, Boolean> memoization = new HashMap<>();
        return canMeasureInRange(measuringCups, low, high, memoization);
    }

    private boolean canMeasureInRange(int[][] measuringCups, int low, int high, Map<String, Boolean> memoization) {
        String memoizeKey = low + ":" + high;
        if (memoization.containsKey(memoizeKey)) {
            return memoization.get(memoizeKey);
        }
        if (low < 0 && high < 0) {
            return false;
        }
        boolean canMeasure = false;
        for (int[] cup : measuringCups) {
            if (cup[0] >= low && cup[1] <= high) {
                canMeasure = true;
                break;
            }

            canMeasure = canMeasureInRange(measuringCups, low - cup[0], high - cup[1], memoization);
            if (canMeasure) {
                break;
            }
        }
        memoization.put(memoizeKey, canMeasure);
        return canMeasure;
    }

}
