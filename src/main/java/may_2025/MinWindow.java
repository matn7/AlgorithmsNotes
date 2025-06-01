package may_2025;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "ab";
        String t = "a";

        MinWindow minWindow = new MinWindow();
        String result = minWindow.minWindow(s, t);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int count = t.length();

        Map<Character, Integer> sMap = new HashMap<>();
        int[] curr = {0, s.length() - 1};

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && sMap.get(c) <= tMap.get(c)) {
                count--;
            }

            if (count == 0) {
                while (!tMap.containsKey(s.charAt(i)) || (sMap.get(s.charAt(i)) > tMap.get(s.charAt(i)))) {
                    sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) - 1);
                    i++;
                }
                if (j - i < curr[1] - curr[0]) {
                    curr[0] = i;
                    curr[1] = j;
                }
            }
        }

        return count == 0 ? s.substring(curr[0], curr[1] + 1) : "";
    }

}
