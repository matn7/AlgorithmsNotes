package august_2025;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
//        String[] words = {"hrn","hrf","er","enn","rfnn"};
        String[] words = {"wrt","wrf","er","ett","rftt","te"};
        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.foreignDictionary(words);
        System.out.println(result);

        // Output: "hernf"
    }

    public String foreignDictionary(String[] words) {
        Set<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
        }
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                degree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0;
            while (j < word1.length() && j < word2.length()) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
                j++;
                if (j == word2.length() && word1.length() > word2.length()) {
                    return "";
                }
            }
        }

//        for (char c : chars) {
//            if (!adj.containsKey(c)) {
//                adj.put(c, new HashSet<>());
//                degree.put(c, 0);
//            }
//        }
//
//        for (int i = 0; i < words.length - 1; i++) {
//            String w1 = words[i];
//            String w2 = words[i + 1];
//            int j = 0;
//            for (j = 0; j < Math.min(w1.length(), w2.length()); j++) {
//                char c1 = w1.charAt(j);
//                char c2 = w2.charAt(j);
//                if (c1 == c2) {
//                    continue;
//                }
//                if (adj.get(c1).contains(c2)) {
//                    continue;
//                }
//                adj.get(c1).add(c2);
//                degree.put(c2, degree.getOrDefault(c2, 0) + 1);
//                break;
//            }
//            if (j == w2.length() && w1.length() > w2.length()) {
//                return "";
//            }
//        }
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
            char current = zeroDeg.poll();
            builder.append(current);

            Set<Character> neighbors = adj.get(current);
            for (char nei : neighbors) {
                degree.put(nei, degree.getOrDefault(nei, 0) - 1);
                if (degree.get(nei) == 0) {
                    zeroDeg.add(nei);
                }
            }
        }
        return builder.length() == chars.size() ? builder.toString() : "";
    }

}
