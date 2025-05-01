package april_2025;

import java.util.*;

public class AlienDictionary {

    // O(N + V + E) time | O(V + E) space
    // V - num of unique chars
    // E - num of edges
    // N - sum of lengths of all strings
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() &&
                    w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        Map<Character, Boolean> visit = new HashMap<>();
        List<Character> res = new ArrayList<>();

        for (char c : adj.keySet()) {
            if (dfs(c, visit, adj, res)) {
                return "";
            }
        }

        Collections.reverse(res);
        StringBuilder builder = new StringBuilder();
        for (char c : res) {
            builder.append(c);
        }
        return builder.toString();
    }

    private boolean dfs(char c, Map<Character, Boolean> visit, Map<Character, Set<Character>> adj, List<Character> res) {
        if (visit.containsKey(c)) {
            return visit.get(c);
        }
        visit.put(c, true);

        for (char nei : adj.get(c)) {
            if (dfs(nei, visit, adj, res)) {
                return true;
            }
        }
        visit.put(c, false);
        res.add(c);
        return false;
    }

}
