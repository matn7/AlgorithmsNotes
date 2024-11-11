package october_2024;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.alienDictionary(words);
        System.out.println(result);
    }

    public String alienDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.put(c, new HashSet<>());
            }
        }

        for (int i =  words.length - 2; i >= 0; i--) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        Map<Character, Boolean> visit = new HashMap<>();
        List<Character> res = new ArrayList<>();

        for (Map.Entry<Character, Set<Character>> element : adj.entrySet()) {
            if (dfs(element.getKey(), visit, adj, res)) {
                return "";
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : res) {
            builder.append(c);
        }

        return builder.reverse().toString();
    }

    private boolean dfs(char c, Map<Character, Boolean> visit,  Map<Character, Set<Character>> adj, List<Character> res) {
        if (visit.containsKey(c)) {
            return visit.get(c);
        }

        visit.put(c, Boolean.TRUE);

        for (Character nei : adj.get(c)) {
            if (dfs(nei, visit, adj, res)) {
                return true;
            }
        }

        visit.put(c, Boolean.FALSE);
        res.add(c);
        return false;
    }

    static class Node {
        char id;
        int degree;
        List<Node> neighbors;

        public Node(char id, int degree) {
            this.id = id;
            this.degree = degree;
            this.neighbors = new ArrayList<>();
        }
    }

}
