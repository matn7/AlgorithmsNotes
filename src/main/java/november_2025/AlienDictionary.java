package november_2025;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
//        String[] words = {"hrn","hrf","er","enn","rfnn"};


        String[] words = {"abc","bcd","cde"};

        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.foreignDictionary(words);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Set<Character> characters = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                characters.add(c);
            }
        }
        for (char c : characters) {
            adj.put(c, new ArrayList<>());
        }
        int[] degree = new int[26];

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i]; // hrn
            String word2 = words[i + 1]; // hrf
            int k = 0;
            int l = 0;

            while (k < word1.length() && l < word2.length()) {
                if (word1.charAt(k) != word2.charAt(l)) {
                    char s = word1.charAt(k);
                    char d = word2.charAt(l);
                    adj.get(s).add(d);
                    degree[d - 'a']++;
                    break;
                }
                k++;
                l++;
            }
            if (k < word1.length() && l == word2.length()) {
                // word1 = "abc", word2 = "ab"
                return "";
            }
        }

        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, List<Character>> elem : adj.entrySet()) {
            if (degree[elem.getKey() - 'a'] == 0) {
                queue.add(elem.getKey());
            }
        }
        if (queue.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.removeFirst();
            builder.append(curr);

            List<Character> neighbors = adj.get(curr);
            for (char nei : neighbors) {
                degree[nei - 'a']--;
                if (degree[nei - 'a'] == 0) {
                    queue.add(nei);
                }
            }
        }

        return builder.length() == adj.size() ? builder.toString() : "";
    }

}
