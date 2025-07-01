package june_2025;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
//        List<String> wordDict = Arrays.asList("leet", "code");
//        String s = "leetcode";

//        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
//        String s = "catsandog";

        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList("aaaa","aaa");

        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);


    }

    // O(s * w) time | O(s) space
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[dp.length - 1] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.startsWith(word, i)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }



}
