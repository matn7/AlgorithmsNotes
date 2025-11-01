package october_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
//        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");

        String s = "aaaaaaa";
        wordDict.add("aaaa");
        wordDict.add("aaa");

        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length()) {
                    if (s.startsWith(w, i)) {
                        dp[i] = dp[i] || dp[i + w.length()];
                    }
//                    String sub = s.substring(i, i + w.length());
//                    if (w.equals(sub)) {
//                        dp[i] = dp[i] || dp[i + w.length()];
//                    }
                }
            }
        }
        return dp[0];
    }

}
