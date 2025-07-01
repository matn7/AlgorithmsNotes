package june_2025;

import java.util.*;

public class ForeignDictionary {

    public static void main(String[] args) {
        String[] words = {"hrn", "hrf", "er", "enn", "rfnn"};

        ForeignDictionary foreignDictionary = new ForeignDictionary();
        String result = foreignDictionary.foreignDictionary(words);
        System.out.println(result);
    }

    // O(N + V + E) time | O(V + E) space
    public String foreignDictionary(String[] words) {
        Map<Character, Node> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!adj.containsKey(c)) {
                    adj.put(c, new Node(c));
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];

            if (a.startsWith(b) && a.length() > b.length()) {
                return ""; // Niepoprawny porządek słownikowy
            }

            for (int k = 0; k < Math.min(a.length(), b.length()); k++) {
                char s = a.charAt(k);
                char d = b.charAt(k);
                if (s != d) {
                    Node source = adj.get(s);
                    Node destination = adj.get(d);
                    if (!source.neighbors.contains(destination)) {
                        source.neighbors.add(destination);
                        destination.deg++;
                    }
                    break; // tylko pierwsza różnica się liczy!
                }
            }
        }

        List<Node> zeroDeg = new ArrayList<>();
        for (Map.Entry<Character, Node> elem : adj.entrySet()) {
            if (elem.getValue().deg == 0) {
                zeroDeg.add(elem.getValue());
            }
        }
        StringBuffer builder = new StringBuffer();
        while (!zeroDeg.isEmpty()) {
            Node removed = zeroDeg.remove(0);
            builder.append(removed.c);
            Set<Node> neighbors = removed.neighbors;
            for (Node nei : neighbors) {
                nei.deg--;
                if (nei.deg == 0) {
                    zeroDeg.add(nei);
                }
            }
        }
        if (builder.length() < adj.size()) {
            return ""; // cykl – nie da się wyznaczyć poprawnego porządku
        }
        return builder.toString();
    }

    static class Node {
        char c;
        int deg;
        Set<Node> neighbors;

        public Node(char c) {
            this.c = c;
            this.deg = 0;
            this.neighbors = new HashSet<>();
        }
    }

}
