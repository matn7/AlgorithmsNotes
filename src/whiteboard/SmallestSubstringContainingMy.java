package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestSubstringContainingMy {

    public static void main(String[] args) {
//        String bigString = "abcd$ef$axb$c$";
//        String smallString = "$$abf";
        String bigString = "a$fuu+afff+affaffa+a$Affab+a+a+$a$";
        String smallString = "a+$aaAaaaa$++";

        smallestSubstringContaining(bigString, smallString);
    }

    public static String smallestSubstringContaining(String bigString, String smallString) {
        // Write your code here.
        if (smallString.length() > bigString.length() || smallString.isEmpty()) {
            return "";
        }
        Map<Character, Integer> occurrences = getOccurrences(smallString);
        List<Integer> minSeenIdx = new ArrayList<>();
        int[] range = new int[] {0, Integer.MAX_VALUE};
        int counter = smallString.length();
        for (int currIdx = 0; currIdx < bigString.length(); currIdx++) {
            char current = bigString.charAt(currIdx);
            if (occurrences.containsKey(current) && occurrences.get(current) > 0) {
                Integer currVal = occurrences.get(current);
                occurrences.remove(current);
                int newValue = currVal - 1;
                occurrences.put(current, newValue);
                counter--;
                minSeenIdx.add(currIdx);
            }
            if (counter == 0) {
                Integer startIdx = minSeenIdx.remove(0);
                Integer currentIdx = minSeenIdx.get(minSeenIdx.size() - 1);
                char startChar = bigString.charAt(startIdx);
                updateOccurrences(occurrences, startChar);
                counter++;
                if (currentIdx - startIdx < range[1] - range[0]) {
                    range[0] = startIdx;
                    range[1] = currentIdx;
                }
            }
        }
        if (counter == 1) {
            int start = minSeenIdx.get(0);
            int end = minSeenIdx.get(minSeenIdx.size() - 1);
            System.out.println();
        }
        if (range[1] == Integer.MAX_VALUE) {
            return "";
        }
        String substring = bigString.substring(range[0], range[1] + 1);
        return substring;
    }

    private static Map<Character, Integer> getOccurrences(String string) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char curr = string.charAt(i);
            if (occurrences.containsKey(curr)) {
                occurrences.put(curr, occurrences.get(curr) + 1);
            } else {
                occurrences.put(curr, 1);
            }
        }
        return occurrences;
    }

    private static void updateOccurrences(Map<Character, Integer> occurrences, char element) {
        occurrences.put(element, occurrences.get(element) + 1);
    }

}
