package december_2024;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
//        String s = "leetcode";
//        String[] words = {"leet","code"};

        String s = "applepenapple";
        String[] words = {"apple","pen"};

//        String s = "catsandog";
//        String[] words = {"cats","dog","sand","and","cat"};

//        String s = "aaaaaaa";
//        String[] words = {"aaaa","aa"};

//        String s = "aaaaaaa";
//        String[] words = {"aaaa","aaa"};

        List<String> wordDict = new ArrayList<>(Arrays.asList(words));


        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);
    }

    TrieNode root = new TrieNode();

    public boolean wordBreak(String s, List<String> wordDict) {
        populateTrie(wordDict);

        TrieNode curr = root;
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
            if (curr.word && curr.children.size() == 0) {
                curr = root;
            }
            i++;
        }

        return i == s.length() && (curr.word || curr == root);
    }

    private void populateTrie(List<String> wordDict) {
        for (String word : wordDict) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.word = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word;
    }

}
