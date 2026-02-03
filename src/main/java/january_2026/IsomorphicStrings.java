package january_2026;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "bbbaaaba", t = "aaabbbba";

        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        boolean isomorphic = isomorphicStrings.isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

    // O(n) time | O(n) space
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            sFreq.put(cs, sFreq.getOrDefault(cs, 0) + 1);
            tFreq.put(ct, tFreq.getOrDefault(ct, 0) + 1);
        }
        if (sFreq.size() != tFreq.size()) {
            return false;
        }
        Map<Character, Character> pair = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (pair.containsKey(cs)) {
                if (pair.get(cs) != ct) {
                    return false;
                }
            } else {
                pair.put(cs, ct);
            }

//            if (sFreq.get(cs) != tFreq.get(ct)) {
//                return false;
//            }
        }
        return true;
    }

}
