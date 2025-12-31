package december_2025;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");

//        String s = "leetcode";

        String s = "abcd";
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);
    }

    // O(n * m) time | O(n) space
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (dp.length > i + word.length()) {
                    String sub = s.substring(i, i + word.length());
                    if (sub.equals(word)) {
                        dp[i] = dp[i + word.length()];
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
