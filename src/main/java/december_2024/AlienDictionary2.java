package december_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary2 {

    public static void main(String[] args) {
//        String[] words = {"wrt", "wrf", "er", "ett"};
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = {"wrtkj","wrt"};
//        String[] words = {"wrt","wrf","er","ett","rftt","te"};

        AlienDictionary2 alienDictionary = new AlienDictionary2();
        String result = alienDictionary.foreignDictionary(words);
        System.out.println(result);
    }

    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
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
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Character, Set<Character>> elem : adj.entrySet()) {
            if (dfs(elem.getKey(), visit, adj, builder)) {
                return "";
            }
        }
        return builder.reverse().toString();
    }

    private boolean dfs(char c,  Map<Character, Boolean> visit, Map<Character, Set<Character>> adj, StringBuilder builder) {
        if (visit.containsKey(c)) {
            return visit.get(c);
        }
        visit.put(c, true);

        for (Character nei : adj.get(c)) {
            if (dfs(nei, visit, adj, builder)) {
                return true;
            }
        }

        visit.put(c, false);
        builder.append(c);
        return false;
    }

}
