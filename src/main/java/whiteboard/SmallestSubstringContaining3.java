package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestSubstringContaining3 {

    public static void main(String[] args) {
//        String bigString = "abcd$ef$axb$c$";
//        String smallString = "$$abf";

        String bigString = "14562435612z!8828!193236!336!5$41!23!5!6789901#";
        String smallString = "#!2z";

        String result = smallestSubstringContaining(bigString, smallString);
        System.out.println(result);
    }

    public static String smallestSubstringContaining(String bigString, String smallString) {
        // Write your code here.
        if (bigString.isEmpty() || smallString.isEmpty() || smallString.length() > bigString.length()) {
            return "";
        }
        int[] result = {0, Integer.MAX_VALUE};
        List<Integer> seen = new ArrayList<>();
        int start = 0;
        int currIdx = 0;
        Map<Character, Integer> countsMap = prepareCountsMap(smallString);
        int counter = smallString.length();

        for (int i = 0; i < bigString.length(); i++) {
            char curr = bigString.charAt(i);
            if (countsMap.containsKey(curr) && countsMap.get(curr) > 0) {
                counter--;
                countsMap.put(curr, countsMap.get(curr) - 1);
                seen.add(i);
            }
            if (counter == 0 && countsMap.containsKey(curr)) {
                start = seen.remove(0);
//                currIdx = seen.get(seen.size() - 1);
//                updateMap(countsMap, bigString.charAt(start));
//                counter++;
                if (i - start < result[1] - result[0]) {
                    result[0] = start;
                    result[1] = i;
                }
            }
        }
        if (result[1] == Integer.MAX_VALUE) {
            return "";
        }
        if (counter > 0) {
            start = seen.remove(0);
            currIdx = seen.get(seen.size() - 1);
            if (currIdx - start < result[1] - result[0]) {
                result[0] = start;
                result[1] = currIdx;
            }
        }
        return bigString.substring(result[0], result[1] + 1);
    }

    private static Map<Character, Integer> prepareCountsMap(String smallString) {
        Map<Character, Integer> countsMap = new HashMap<>();
        for (int i = 0; i < smallString.length(); i++) {
            char curr = smallString.charAt(i);
            if (countsMap.containsKey(curr)) {
                countsMap.put(curr, countsMap.get(curr) + 1);
            } else {
                countsMap.put(curr, 1);
            }
        }
        return countsMap;
    }

    private static void updateMap(Map<Character, Integer> countsMap, char element) {
        countsMap.put(element, countsMap.get(element) + 1);
    }


}
