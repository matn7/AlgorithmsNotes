package december_2024;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett"};
//        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = {"wrtkj","wrt"};
//        String[] words = {"wrt","wrf","er","ett","rftt","te"};

        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.foreignDictionary(words);
        System.out.println(result);
    }

    public String foreignDictionary(String[] words) {
        Map<Character, Node> adj = new LinkedHashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new Node(c));
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int f = 0;
            int s = 0;
            while (f < first.length() && s < second.length()) {
                if (first.charAt(f) != second.charAt(s)) {
                    char c = first.charAt(f);
                    Node source = adj.get(c);
                    char d = second.charAt(s);
                    Node dest = adj.get(d);
                    if (source.id != dest.id) {
                        source.neighbors.add(dest);
                        dest.degree++;
                    }
                }
                f++;
                s++;
            }
        }
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                Node startNode = adj.get(c);
                if (!visited.contains(c) && !dfs(startNode, visiting, visited, builder)) {
                    return "";
                }
            }
        }
        return builder.toString();
    }

    private boolean dfs(Node node, Set<Character> visiting, Set<Character> visited, StringBuilder builder) {
        if (visiting.contains(node.id)) {
            return true;
        }
        if (visited.contains(node.id)) {
            return false;
        }
        visiting.add(node.id);
        builder.append(node.id);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (visiting.contains(neighbor.id)) {
                return true;
            }
            dfs(neighbor, visiting, visited, builder);
        }

        visiting.remove(node.id);
        visited.add(node.id);
        return false;
    }

    static class Node {
        char id;
        int degree;
        List<Node> neighbors;

        public Node(char id) {
            this.id = id;
            this.degree = 0;
            this.neighbors = new ArrayList<>();
        }
    }

}
