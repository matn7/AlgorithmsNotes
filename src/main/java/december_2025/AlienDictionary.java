package december_2025;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};

        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.alienOrder(words);
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
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for (char c : chars) {
            adj.putIfAbsent(c, new HashSet<>());
            degree.putIfAbsent(c, 0);
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
                        continue;
                    }
                    break;
                }
                j++;
                if (j == w2.length() && w1.length() > w2.length()) {
                    return "";
                }
            }

            // w1 = abc, w2 = ab
            //        x         x
        }

        Queue<Character> zeroDeg = new LinkedList<>();
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
            Character current = zeroDeg.poll();
            builder.append(current);
            Set<Character> neighbors = adj.get(current);
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
