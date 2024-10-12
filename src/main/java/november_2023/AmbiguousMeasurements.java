package november_2023;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousMeasurements {

    public static void main(String[] args) {
        int[][] measuringCups = {{200,210}, {400,465}, {800,850}};
        int low = 2100;
        int high = 2300;

        boolean result = canMeasure(measuringCups, low, high);
        System.out.println(result);
    }

    // O(low * high * n) time | O(low * high) space
    public static boolean canMeasure(int[][] measuringCups, int low, int high) {
        Map<String, Boolean> memo = new HashMap<>();
        return canMeasureHelper(measuringCups, low, high, memo);
    }

    private static boolean canMeasureHelper(int[][] measuringCups, int low, int high, Map<String, Boolean> memo) {
        if (low < 0 && high < 0) {
            return false;
        }
        String key = low + ":" + high;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean canMeasure = false;
        for (int[] cup : measuringCups) {
            if (cup[0] >= low && cup[1] <= high) {
                return true;
            }
            canMeasure = canMeasureHelper(measuringCups, low - cup[0], high - cup[1], memo);
            if (canMeasure) {
                break;
            }
        }
        memo.put(key, canMeasure);
        return memo.get(key);
    }


}
