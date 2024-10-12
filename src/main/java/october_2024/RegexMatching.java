package october_2024;

import java.util.HashMap;
import java.util.Map;

public class RegexMatching {


    public static void main(String[] args) {
//        String s = "aaxbxcxghi";
//        String p = "aa.b.c.*";

//        String s = "aa";
//        String p = "a*";

        String s = "aa";
        String p = "a";

        RegexMatching regexMatching = new RegexMatching();
        boolean match = regexMatching.isMatch(s, p);
        System.out.println(match);
    }

    // leetcode 10

    // O(n*m) time | O(n*m) space
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> cache = new HashMap<>();
        return dfs(s, 0, p, 0, cache);
    }

    private boolean dfs(String s, int i, String p, int j, Map<String, Boolean> cache) {
        String key = generateStr(i, j);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            cache.put(key, dfs(s, i, p, j + 2, cache) || (match && dfs(s, i + 1, p, j, cache)));
            return cache.get(key);
        }
        if (match) {
            cache.put(key, dfs(s, i + 1, p, j + 1, cache));
            return cache.get(key);
        }
        cache.put(key, false);
        return cache.get(key);
    }

    private String generateStr(int i, int j) {
        return i + ":" + j;
    }


}
