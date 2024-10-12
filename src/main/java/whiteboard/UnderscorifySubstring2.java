package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring2 {

    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String substring = "test";

        underscorifySubstring(str, substring);
    }

    // O(n + m) time | O(n) space - n length of main string, nm length of substring
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        List<Integer[]> locations = findLocations(str, substring);
        List<Integer[]> newLocations = collapse(locations);
        String underscorify = underscorify(str, newLocations);
        return underscorify;
    }

    private static List<Integer[]> findLocations(String string, String substring) {
        List<Integer[]> locations = new ArrayList<>();
        int start = 0;
        while (start < string.length()) {
            int index = string.indexOf(substring, start);
            if (index != -1) {
                locations.add(new Integer[] {index, index + substring.length()});
                start = index + 1;
            } else {
                break;
            }
        }
        return locations;
    }

    private static List<Integer[]> collapse(List<Integer[]> locations) {
        List<Integer[]> newLocations = new ArrayList<>();
        for (Integer[] location : locations) {
            if (newLocations.isEmpty()) {
                newLocations.add(location);
                continue;
            }
            Integer[] top = newLocations.get(newLocations.size() - 1);
            if (top[1] >= location[0]) {
                top[1] = Math.max(top[1], location[1]);
            } else {
                newLocations.add(location);
            }
        }
        return newLocations;
    }

    private static String underscorify(String string, List<Integer[]> locations) {
        if (locations.isEmpty()) {
            return string;
        }
        int swapIdx = 0;
        Integer[] currLoc = locations.remove(0);
        List<String> resArr = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (currLoc[0] != -1 && i == currLoc[swapIdx]) {
                if (swapIdx == 1) {
                    if (!locations.isEmpty()) {
                        currLoc = locations.remove(0);
                    } else {
                        currLoc = new Integer[] {-1, -1};
                    }
                }
                resArr.add("_");
                resArr.add(String.valueOf(string.charAt(i)));
                swapIdx = swapIdx == 0 ? 1 : 0;
            } else {
                resArr.add(String.valueOf(string.charAt(i)));
            }
        }
        if (swapIdx == 1) {
            resArr.add("_");
        }
        return String.join("", resArr);
    }

}
