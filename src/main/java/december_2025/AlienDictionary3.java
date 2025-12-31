package december_2025;

import java.util.*;

public class AlienDictionary3 {

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};

        AlienDictionary3 alienDictionary3 = new AlienDictionary3();
        String result = alienDictionary3.alienOrder(words);
        System.out.println(result);
    }

    // O(v + e) time | O(v + e) space
    public String alienOrder(String[] words) {
        Set<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
        }
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (char c : chars) {
            degree.put(c, 0);
            adj.put(c, new HashSet<>());
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            int j = 0;
            while (j < word1.length() && j < word2.length()) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    // not matched yet
                    if (!adj.get(c1).contains(c2)) {
                        degree.put(c2, degree.get(c2) + 1);
                        adj.get(c1).add(c2);
                    }
                    break;
                }
                j++;
            }
            // match not possible for example: [abc, ab]
            if (word1.length() > word2.length() && j == word2.length()) {
                return "";
            }
        }

        ArrayDeque<Character> zeroDeg = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> elem : degree.entrySet()) {
            if (elem.getValue() == 0) {
                zeroDeg.addLast(elem.getKey());;
            }
        }
        // cycle detected
        if (zeroDeg.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        while (!zeroDeg.isEmpty()) {
            char curr = zeroDeg.removeFirst();
            builder.append(curr);

            Set<Character> neighbors = adj.get(curr);
            for (char nei : neighbors) {
                degree.put(nei, degree.get(nei) - 1);
                if (degree.get(nei) == 0) {
                    zeroDeg.addLast(nei);
                }
            }
        }

        return builder.length() != chars.size() ? "" : builder.toString();
    }

}
