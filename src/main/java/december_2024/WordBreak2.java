package december_2024;

import java.util.*;

public class WordBreak2 {

    public static void main(String[] args) {
//        String s = "leetcode";
//        String[] words = {"leet","code"};

//        String s = "applepenapple";
//        String[] words = {"apple","pen"};

//        String s = "catsandog";
//        String[] words = {"cats","dog","sand","and","cat"};

//        String s = "aaaaaaa";
//        String[] words = {"aaaa","aa"};

        String s = "aaaaaaa";
        String[] words = {"aaaa","aaa"};

        List<String> wordDict = new ArrayList<>(Arrays.asList(words));


        WordBreak2 wordBreak = new WordBreak2();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if ((i + w.length() <= s.length()) && s.substring(i, i + w.length()).equals(w)) {
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
