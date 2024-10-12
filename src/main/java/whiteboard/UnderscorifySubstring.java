package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring {

    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String substring = "test";

        underscorifySubstring(str, substring);
    }

    // O(n + m) time | O(n) space
    // #2: 02/07/2022
    // rand: 16/07/2022
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        List<Integer[]> occurrences = findOccurrences(str, substring);
        List<Integer[]> merged = collapse(occurrences);
        return underscorify(str, merged);
    }

    private static List<Integer[]> findOccurrences(String str, String substring) {
        List<Integer[]> occurrences = new ArrayList<>();
        int startIdx = 0;
        while (startIdx < str.length()) {
            int nextIdx = str.indexOf(substring, startIdx);
            if (nextIdx == -1) {
                break;
            }
            Integer[] occur = {nextIdx, nextIdx + substring.length()};
            occurrences.add(occur);
            startIdx = nextIdx + 1;
        }
        return occurrences;
    }

    private static List<Integer[]> collapse(List<Integer[]> occurrences) {
        List<Integer[]> merged = new ArrayList<>();
        for (Integer[] element : occurrences) {
            Integer[] current = element;
            if (merged.isEmpty()) {
                merged.add(current);
                continue;
            }
            Integer[] top = merged.get(merged.size() - 1);
            if (top[1] >= current[0]) {
                top[1] = Math.max(top[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        return merged;
    }


    private static String underscorify(String str, List<Integer[]> merged) {
        if (merged.isEmpty()) {
            return str;
        }
        int nextMerged = 0;
        List<String> result = new ArrayList<>();
        Integer[] positions = merged.get(nextMerged);
        int posIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == positions[posIdx] && nextMerged < merged.size()) {
                result.add("_");
                if (posIdx == 1) {
                    nextMerged++;
                    if (nextMerged >= merged.size()) {
                        result.add(String.valueOf(str.charAt(i)));
                        continue;
                    }
                    positions = merged.get(nextMerged);
                }
                posIdx = posIdx == 0 ? 1 : 0;
            }
            result.add(String.valueOf(str.charAt(i)));
        }
        if (nextMerged < merged.size()) {
            result.add("_");
        }
        return String.join("", result);
    }


}
