package december_2025;

import java.util.*;

public class AlienDictionary2 {

    // O(v + e) time | O(v + e) space
    public String alienOrder(String[] words) {
        Set<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
        }

        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (char c : chars) {
            adj.put(c, new HashSet<>());
            degree.put(c, 0);
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int j = 0;

            while (j < w1.length() && j < w2.length()) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
                j++;
            }
            // w1 = "abc", w2 = "ab"
            if (j == w2.length() && w1.length() > w2.length()) {
                return "";
            }
        }
        LinkedList<Character> zeroDeg = new LinkedList<>();
        for (Map.Entry<Character, Integer> elem : degree.entrySet()) {
            if (elem.getValue() == 0) {
                zeroDeg.add(elem.getKey());
            }
        }
        if (zeroDeg.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        while (!zeroDeg.isEmpty()) {
            char c = zeroDeg.poll();
            builder.append(c);
            Set<Character> neighbors = adj.get(c);
            for (char nei : neighbors) {
                degree.put(nei, degree.get(nei) - 1);
                if (degree.get(nei) == 0) {
                    zeroDeg.add(nei);
                }
            }
        }
        return builder.length() == chars.size() ? builder.toString() : "";
    }

}
