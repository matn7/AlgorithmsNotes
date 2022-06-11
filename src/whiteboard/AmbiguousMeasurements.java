package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousMeasurements {

    public static void main(String[] args) {
        int[][] measuringCups = {
                {200, 210},
                {450, 465},
                {800, 850}
        };

        int low = 2100;
        int high = 2300;

        AmbiguousMeasurements measurements = new AmbiguousMeasurements();
        measurements.ambiguousMeasurements(measuringCups, low, high);
    }

    // O(low * high * n) time } O(low * high) space
    // n - number of measuring cups
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        // Write your code here.
        Map<String, Boolean> cache = new HashMap<>();
        boolean result = ambiguousMeasurementsHelper(measuringCups, low, high, cache);
        return result;
    }

    private boolean ambiguousMeasurementsHelper(int[][] measuringCups, int low, int high, Map<String, Boolean> cache) {
        String key = low + "-" + high;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (low < 0 && high < 0) {
            return false;
        }

        boolean canMeasure = false;
        for (int[] cup : measuringCups) {
            int cupLow = cup[0];
            int cupHigh = cup[1];
            if (low <= cupLow && cupHigh <= high) {
                canMeasure = true;
                break;
            }
            int currentLow = low - cup[0];
            int currentHigh = high - cup[1];

            canMeasure = ambiguousMeasurementsHelper(measuringCups, currentLow, currentHigh, cache);
            if (canMeasure) {
                break;
            }
        }
        cache.put(key, canMeasure);
        return canMeasure;
    }

}
