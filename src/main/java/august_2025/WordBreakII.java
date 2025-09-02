package august_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    // O(m + n*2^n) time | O(m + 2^n) space
    // n - len of str s, m - sum of lengths of strs in wordDict
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        return backtrack(s, 0, wordDictSet);
    }

    private List<String> backtrack(String s, int i, Set<String> wordDict) {
        if (i == s.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> res = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            String w = s.substring(i, j + 1);
            if (!wordDict.contains(w)) {
                continue;
            }
            List<String> strings = backtrack(s, j + 1, wordDict);
            if (strings.isEmpty()) {
                continue;
            }
            for (String substr : strings) {
                String sentence = w;
                if (!substr.isEmpty()) {
                    sentence += " " + substr;
                }
                res.add(sentence);
            }
        }
        return res;
    }

    // O(m + n*2^n) time | O(m + 2^n) space
    // n - len of str s, m - sum of lengths of strs in wordDict
    public List<String> wordBreak2(String s, List<String> wordDict) {

        List<String> cur = new ArrayList<>();
        List<String> res = new ArrayList<>();
        Set<String> wordDictSet = new HashSet<>(wordDict);
        backtrack2(s, 0, wordDictSet, cur, res);
        return res;

    }

    private void backtrack2(String s, int i, Set<String> wordDict, List<String> cur, List<String> res) {
        if (i == s.length()) {
            res.add(String.join(" ", cur));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String w = s.substring(i, j + 1);
            if (wordDict.contains(w)) {
                cur.add(w);
                backtrack2(s, j + 1, wordDict, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

}
