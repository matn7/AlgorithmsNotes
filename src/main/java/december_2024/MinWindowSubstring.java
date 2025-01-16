package december_2024;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = "OUZODYYXAZV";
        String t = "XYZ";

        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        String result = minWindowSubstring.minWindow(s, t);
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> countS = new HashMap<>();
        int count = t.length();
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int[] res = {0, 0};
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            countS.put(c, countS.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && countS.get(c) <= countT.get(c)) {
                count--;
            }
            if (count == 0) {
                // find substring from l to r where our result is
                // now shrink
                while (l < r && (!countT.containsKey(s.charAt(l)) || countS.get(s.charAt(l)) > countT.get(s.charAt(l)))) {
                    countS.put(s.charAt(l), countS.getOrDefault(s.charAt(l), 0) - 1);
                    l++;
                }
                int currLen = r - l + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    res[0] = l;
                    res[1] = r;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

}
