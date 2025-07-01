package june_2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakDfs {

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList("aaaa","aaa");

        WordBreakDfs wordBreak = new WordBreakDfs();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);


    }

    Map<Integer, Boolean> memo;

    // O(s * w) time | O(s) space
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    if (dfs(s, wordDict, i + word.length())) {
                        memo.put(i, true);
                        return true;
                    }
                }
            }
        memo.put(i, false);
        return false;
    }


}
