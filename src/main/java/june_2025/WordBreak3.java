package june_2025;

import java.util.Arrays;
import java.util.List;

public class WordBreak3 {

    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList("leet","code");

//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList("apple","pen");

        String s = "abcd";
        List<String> wordDict = Arrays.asList("a","abc","b","cd");

        WordBreak3 wordBreak3 = new WordBreak3();
        boolean result = wordBreak3.wordBreak(s, wordDict);
        System.out.println(result);

    }

    // O(n * m * t) time | O(n) space
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[dp.length - 1] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length()) {
                    String word = s.substring(i, i + w.length());
                    if (w.equals(word)) {
                        dp[i] = dp[i + w.length()];
                    }
                }
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }

}
