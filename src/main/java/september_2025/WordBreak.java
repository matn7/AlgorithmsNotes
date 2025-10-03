package september_2025;

import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple","pen");

        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);
    }


    // O(s * w * m) time | O(s) space
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[dp.length - 1] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length()) {
                    String sub = s.substring(i, i + w.length());
                    if (sub.equals(w)) {
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
