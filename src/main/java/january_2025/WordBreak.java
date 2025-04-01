package january_2025;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);
    }

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
