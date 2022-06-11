package hard;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousMeasurementsREPEAT {

    public static void main(String[] args) {
        int[][] measuringCups = {
                {200,210},
                {450,465},
                {800,850}
        };

        AmbiguousMeasurementsREPEAT ambiguousMeasurements = new AmbiguousMeasurementsREPEAT();
        boolean result = ambiguousMeasurements.ambiguousMeasurements(measuringCups, 2100, 2300);

        System.out.println(result);
    }

    // O(low * high * n) time (n number of measuring cups) | O(low  * high) space
    // OK - repeated 05/02/2022
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        // Write your code here.
        Map<String, Boolean> memoization = new HashMap<>();
        boolean result = canMeasureInRange(measuringCups, low, high, memoization);
        return result;
    }

    // rec( 100,  200)  " 100: 200"
    // rec( 300,  410)  " 300: 410"
    // rec( 500,  620)  " 500: 620"
    // rec( 700,  830)  " 700: 830"
    // rec( 900, 1040)  " 900:1040"
    // rec(1100, 1250)  "1100:1250"
    // rec(1300, 1460)  "1300:1460"
    // rec(1500, 1670)  "1500:1670"
    // rec(1700, 1880)  "1700:1880"
    // rec(1900, 2090)  "1900:2090"
    // rec(2100, 2300)  "2100:2300"
    private boolean canMeasureInRange(int[][] measuringCups, int low, int high, Map<String, Boolean> memoization) {
        // [[200,210],
        //  [450,465],
        //  [800,850]]
        String memoizeKey = createHashableKey(low, high); // "2100:2300"
        if (memoization.containsKey(memoizeKey)) {
            return memoization.get(memoizeKey);
        }

        // 2100 < 0 && 2300 < 0
        if (low < 0 && high < 0) {
            return false;
        }

        boolean canMeasure = false;
        // rec( 900, 1040)  " 900:1040"
        for (int[] cup : measuringCups) { // [200,210]
            int cupLow = cup[0]; // 450
            int cupHigh = cup[1]; // 465
            //   #########
            // --+-------+-------+------+---
            //  200     210     1700   1880
            if (cupLow >= low && cupHigh <= high) { // 2100 <= 200 && 210 <= 2300
                canMeasure = true;
                break;
            }
            // rec( 450, 575)  " 900:1040"
            canMeasure = canMeasureInRange(measuringCups, low - cupLow, high - cupHigh, memoization);
            if (canMeasure) {
                break;
            }
        }
        memoization.put(memoizeKey, canMeasure);
        return canMeasure;
    }

    private String createHashableKey(int low, int high) {
        return low + ":" + high;
    }

}
