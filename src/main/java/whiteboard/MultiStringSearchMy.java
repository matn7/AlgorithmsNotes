package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearchMy {

    public static void main(String[] args) {
        String[] smallStrings = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
//        String[] smallStrings = {"abc", "mnopqr", "tuw", "a", "bigger", "xyz", "kappa"};
        String bigString = "this is a big string";

        multiStringSearch(bigString, smallStrings);

    }

    // O(ns + bs) time | O(ns) space
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        Trie trie = prepareTrie(smallStrings);
        List<String> wordsFound = new ArrayList<>();

        for (int i = 0; i < bigString.length(); i++) {
            Trie curr = trie;
            int idx = i;
            char c = bigString.charAt(idx);
            while (idx < bigString.length() - 1 && curr.children.containsKey(c)) {
                if (!curr.children.get(c).word.equals("")) {
                    wordsFound.add(curr.children.get(c).word);
                    break;
                }
                curr = curr.children.get(c);
                idx++;
                if (idx == bigString.length()) {
                    break;
                }
                c = bigString.charAt(idx);
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (String word : smallStrings) {
            if (wordsFound.contains(word)) {
                result.add(Boolean.TRUE);
            } else {
                result.add(Boolean.FALSE);
            }
        }

        return result;
    }

    private static Trie prepareTrie(String[] smallStrings) {
        Trie trie = new Trie();
        for (String small : smallStrings) {
            Trie curr = trie;
            for (char c : small.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
            }
            curr.word = small;
            curr.children.put('*', null);
        }
        return trie;
    }

    static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        String word = "";
    }
    
}
