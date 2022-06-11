package hard;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring {

    public static void main(String[] args) {

        String str = "testthis is a testtest to see if testestest it works";
        String substring = "test";

        String result = underscorifySubstring(str, substring);

        System.out.println(result);

    }

    // O(n + m) time | O(n) space
    // traverse: O(n) find(): O(n+m) (KMP algorithm)
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        List<Integer[]> locations = collapse(getLocations(str, substring));
        return underscorify(str, locations);
    }

    private static List<Integer[]> getLocations(String str, String substring) {
        List<Integer[]> locations = new ArrayList<>();
        int startIdx = 0;
        while (startIdx < str.length()) {
            int nextIdx = str.indexOf(substring, startIdx);
            if (nextIdx != -1) {
                locations.add(new Integer[] {nextIdx, nextIdx + substring.length()});
                startIdx = nextIdx + 1;
            } else {
                break;
            }
        }
        return locations;
    }

    private static List<Integer[]> collapse(List<Integer[]>  locations) {
        if (locations.isEmpty()) {
            return locations;
        }
        List<Integer[]> newLocations = new ArrayList<>();
        newLocations.add(locations.get(0));
        Integer[] previous = newLocations.get(0);
        for (int i = 1; i < locations.size(); i++) {
            Integer[] current = locations.get(i);
            if (current[0] <= previous[1]) { // overlaps
                previous[1] = current[1];
            } else {
                newLocations.add(current);
                previous = current;
            }
        }

        return newLocations;
    }

    private static String underscorify(String string, List<Integer[]> locations) {
        int locationsIdx = 0;
        int stringIdx = 0;
        boolean inBetweenUnderscores = false;
        List<String> finalChars = new ArrayList<>();
        int i = 0;
        while (stringIdx < string.length() && locationsIdx < locations.size()) {
            if (stringIdx == locations.get(locationsIdx)[i]) { // [[0, 4], [8, 12], [19, 23]]
                finalChars.add("_");
                inBetweenUnderscores = !inBetweenUnderscores;
                if (!inBetweenUnderscores) {
                    locationsIdx++;
                }
                if (i == 1) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
            finalChars.add(String.valueOf(string.charAt(stringIdx)));
            stringIdx++;
        }
        if (locationsIdx < locations.size()) {
            finalChars.add("_");
        } else if (stringIdx < string.length()) {
            finalChars.add(string.substring(stringIdx));
        }
        StringBuilder result = new StringBuilder();
        for (String element : finalChars) {
            result.append(element);
        }
        return result.toString();
    }
}
