package september_2023;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousMeasurements {

    public static void main(String[] args) {
        int[][] measuringCups = {
                {200, 210},
                {450, 465},
                {800, 850}
        };

        AmbiguousMeasurements ambiguousMeasurements = new AmbiguousMeasurements();
        ambiguousMeasurements.ambiguousMeasurements(measuringCups, 2100, 2300);


    }

    // O(low * high * n) time | O(low * high) space (n - num of measuring cups)
    public boolean ambiguousMeasurements(
            int[][] measuringCups, int low, int high
    ) {
        // Write your code here.
        Map<String, Boolean> cache = new HashMap<>();
        boolean result = ambiguousMeasurementsHelper(measuringCups, low, high, cache);
        return result;
    }

    public boolean ambiguousMeasurementsHelper(
            int[][] measuringCups, int low, int high, Map<String, Boolean> cache
    ) {
        // Write your code here.
        String key = low + ":" + high;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (low < 0 && high < 0) {
            return false;
        }

        boolean canMeasure = false;
        for (int[] cup : measuringCups) {
            // ============================
            // low    200         210     high
            if (cup[0] >= low && cup[1] <= high) {
                canMeasure = true;
                break;
            }

            canMeasure = ambiguousMeasurementsHelper(measuringCups, low - cup[0], high - cup[1], cache);
            if (canMeasure) {
                break;
            }
        }
        cache.put(key, canMeasure);
        return canMeasure;
    }

}
