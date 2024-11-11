package october_2024;

import java.util.*;

public class WordBreak2 {

    public static void main(String[] args) {
        WordBreak2 wordBreak = new WordBreak2();

        boolean result = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(result);
    }

    // O(m * n^2) time | O(n) space
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }



}
