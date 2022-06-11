package hard;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstringREPEAT {

    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String substring = "test";

        underscorifySubstring(str, substring);
    }

    // O(n + m) time | O(n) space
    // OK - repeated 30/01/2022
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        // locations [[0,4], [14,18], [18,22], [33,37], [36,40], [39,34]]
        List<Integer[]> locations = collapse(getLocations(str, substring));
        return underscorify(str, locations);
    }

    private static List<Integer[]> getLocations(String string, String substring) {
        // "testthis is a testtest to see if testestest it works"
        // "test"
        List<Integer[]> locations = new ArrayList<>();
        int startIdx = 0;
        
        while (startIdx < string.length()) {
            int nextIdx = string.indexOf(substring, startIdx); // 0
            if (nextIdx != -1) {
                locations.add(new Integer[]{nextIdx, nextIdx + substring.length()}); // [0, 4]
                startIdx = nextIdx + 1;
            } else {
                break;
            }
        }
        return locations; // [[0,4], [14,18], [18,22], [33,37], [36,40], [39,43]]
    }

    private static List<Integer[]> collapse(List<Integer[]> locations) {
        if (locations.isEmpty()) {
            return locations;
        }
        // [[0,4], [14,18], [18,22], [33,37], [36,40], [39,43]]
        List<Integer[]> newLocations = new ArrayList<>();
        newLocations.add(locations.get(0)); // [[0,4], [14,22], [33,43]]
        Integer[] previous = newLocations.get(0); // [[0,4]]
        for (int i = 1; i < locations.size(); i++) {
            // previous = [33,43]
            Integer[] current = locations.get(i); // [39,43]
            if (current[0] <= previous[1]) {
                previous[1] = current[1];
            } else {
                newLocations.add(current);
                previous = current;
            }
        }
        return newLocations;
    }

    private static String underscorify(String string, List<Integer[]> locations) {
        // "testthis is a testtest to see if testestest it works"
        // [[0,4], [14,22], [33,43]]
        int locationsIdx = 0; // 3
        int stringIdx = 0;
        boolean inBetweenUnderscores = false;
        List<String> finalChars = new ArrayList<>();
        int i = 0; // 0
        while (stringIdx < string.length() && locationsIdx < locations.size()) {
            // [[0,4], [14,22], [33,43]]
            if (stringIdx == locations.get(locationsIdx)[i]) { // 43 == 43
                // _test_this is a _testtest_ to see if _testestest_ it works
                finalChars.add("_");
                inBetweenUnderscores = !inBetweenUnderscores; // false
                if (!inBetweenUnderscores) {
                    locationsIdx++;
                }
                i = i == 1 ? 0 : 1;
            }
            finalChars.add(String.valueOf(string.charAt(stringIdx)));
            stringIdx++;
        }
        if (locationsIdx < locations.size()) {
            finalChars.add("_");
        } else if (stringIdx < string.length()) {
            finalChars.add(string.substring(stringIdx)); // it works
        }
        return String.join("", finalChars);
    }

}
