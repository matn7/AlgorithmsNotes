package october_2023;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String string = "clementisacap";

        String result = longestString(string);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String longestString(String str) {
        Map<Character, Integer> charsMap = new HashMap<>();
        int startIdx = 0;
        int[] res = new int[] {0, 0};
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charsMap.containsKey(c)) {
                startIdx = Math.max(startIdx, charsMap.get(c) + 1);
            }
            charsMap.put(c, i);
            if (i - startIdx > res[1] - res[0]) {
                res[0] = startIdx;
                res[1] = i;
            }

        }

        return str.substring(res[0], res[1] + 1);
    }

}
