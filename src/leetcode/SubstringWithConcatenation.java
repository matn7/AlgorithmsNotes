package leetcode;

import java.util.*;

public class SubstringWithConcatenation {

    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar","foo","the"};
//        String s = "aaa";
//        String[] words = {"a", "a"};
        String s = "aaaaaaaaaaaaaa";
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        SubstringWithConcatenation substringWithConcatenation = new SubstringWithConcatenation();
        substringWithConcatenation.findSubstring(s, words);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> wordsArr = Arrays.asList(words);
        List<String> permutations = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        for (String w : words) {
            strBuilder.append(w);
        }
        String str = strBuilder.toString();
        getPermutations(str, "", permutations);

//        getPermutations(wordsArr, "", permutations);
        System.out.println();
        Set<Integer> result = new HashSet<>();
        for (String perm : permutations) {
            int idx = 0;
            while (idx <= s.length()) {
                int i = s.indexOf(perm, idx);
                if (i == -1) {
                    break;
                }
                result.add(i);
                idx = i + 1;
            }
        }
        List<Integer> listRes = new ArrayList<>(result);
        return listRes;
    }

    private void getPermutations(String str, String ans, List<String> result) {
        boolean alpha[] = new boolean[26];

        if (str.length() == 0) {
            result.add(str);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            if (alpha[ch - 'a'] == false) {
                getPermutations(ros, ans + ch, result);
            }

            alpha[ch - 'a'] = true;
        }
    }

    private void getPermutations(List<String> words, String word, List<String> result) {
        if (words.isEmpty()) {
            result.add(word);
        } else {
            for (int i = 0; i < words.size(); i++) {
                List<String> newWords = new ArrayList<>(words);
                String w = newWords.remove(i);
                String newWord = word + w;
                getPermutations(newWords, newWord, result);
            }
        }
    }

}
