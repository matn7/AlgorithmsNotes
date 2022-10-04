package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestSubstringContainingRand {

    public static void main(String[] args) {
//        String bigString = "abcd$ef$axb$c$";
//        String smallString = "$$abf";

        String bigString = "1456243561288281932363365412356789901!";
        String smallString = "123!";

        String result = smallestSubstringContaining(bigString, smallString);
        System.out.println();
    }

    // O(b + s) time | O(b + s) space
    public static String smallestSubstringContaining(String bigString, String smallString) {
        // Write your code here.
        if (smallString.length() == 1) {
            return smallString;
        }
        int checkCount = smallString.length();
        Map<Character, Integer> countCharsMap = new HashMap<>();
        for (char element : smallString.toCharArray()) {
            if (countCharsMap.containsKey(element)) {
                countCharsMap.put(element, countCharsMap.get(element) + 1);
            } else {
                countCharsMap.put(element, 1);
            }
        }
        List<Integer> elementIndex = new ArrayList<>();
        int startIdx = 0;
        int[] res = {startIdx, Integer.MAX_VALUE};

        for (int idx = 0; idx < bigString.length(); idx++) {
            char current = bigString.charAt(idx);
            if (countCharsMap.containsKey(current) && countCharsMap.get(current) > 0) {
                elementIndex.add(idx);
                countCharsMap.put(current, countCharsMap.get(current) - 1);
                checkCount--;
                if (checkCount == 0) {
                    if (idx - startIdx < res[1] - res[0]) {
                        res[0] = startIdx;
                        res[1] = idx;
                    }
                }
            } else if (countCharsMap.containsKey(current) && checkCount == 0) {
                elementIndex.remove(0);
                startIdx = elementIndex.get(0);
                if (idx - startIdx < res[1] - res[0]) {
                    res[0] = startIdx;
                    res[1] = idx;
                }
            }
        }

        return res[1] != Integer.MAX_VALUE ? bigString.substring(res[0], res[1] + 1) : "";
    }

}
