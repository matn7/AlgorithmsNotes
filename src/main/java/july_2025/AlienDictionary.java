package july_2025;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
//        String[] words = {"hrn","hrf","er","enn","rfnn"};
        String[] words= {"wrtkj","wrt"};
        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.foreignDictionary(words);
        System.out.println(result);
    }

    // O(N + V + E) time | O(V + E) space
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> freq = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.computeIfAbsent(c, k -> new HashSet<>());
                freq.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int j = 0;
            while (j < w1.length() && j < w2.length()) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1!=c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        freq.put(c2, freq.get(c2) + 1);
                    }
                    break;
                }
                j++;
                if (j == w2.length() && w1.length() > w2.length()) { // abc - ab
                    return "";
                }
            }
        }

        Queue<Character> zeroDeg = new LinkedList<>();
        for (Map.Entry<Character, Integer> elem : freq.entrySet()) {
            if (elem.getValue() == 0) {
                zeroDeg.add(elem.getKey());
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!zeroDeg.isEmpty()) {
            char curr = zeroDeg.poll();
            builder.append(curr);
            Set<Character> neighbors = adj.get(curr);
            for (char nei : neighbors) {
                freq.put(nei, freq.getOrDefault(nei, 0) - 1);
                if (freq.get(nei) == 0) {
                    zeroDeg.add(nei);
                }
            }
        }

        for (Map.Entry<Character, Integer> elem : freq.entrySet()) {
            if (elem.getValue() != 0) {
                return "";
            }
        }

        return builder.toString();
    }

}
