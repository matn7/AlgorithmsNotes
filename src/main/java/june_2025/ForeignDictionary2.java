package june_2025;

import java.util.*;

public class ForeignDictionary2 {

    public static void main(String[] args) {
//        String[] words = {"hrn","hrf","er","enn","rfnn"};
//        String[] words = {"z","o"};
//        String[] words = {"abc","bcd","cde"}; // edabc
        String[] words = {"wrtkj","wrt"};
//        String[] words = {"wrt","wrf","er","ett","rftt","te"};
        ForeignDictionary2 foreignDictionary2 = new ForeignDictionary2();
        String result = foreignDictionary2.foreignDictionary(words);
        System.out.println(result);
    }
    // DODAĆ DO NOTATEK
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                freqMap.putIfAbsent(c, 0); // domyślna liczba wejść = 0
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
                    // dodaj krawędź c1 -> c2 tylko jeśli jeszcze nie istnieje
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        freqMap.put(c2, freqMap.get(c2) + 1);
                    }
                    break; // ważne! przerywamy po znalezieniu pierwszej różnicy
                }
                j++;
            }

            // corner case: prefix problem, np. "abc" i "ab"
            if (j == word2.length() && word1.length() > word2.length()) {
                return ""; // niepoprawna kolejność
            }
        }

        List<Character> zeroDeg = new ArrayList<>();
        for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() == 0) {
                zeroDeg.add(elem.getKey());
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!zeroDeg.isEmpty()) {
            char curr = zeroDeg.remove(0);
            builder.append(curr);

            for (char nei : adj.getOrDefault(curr, Collections.emptySet())) {
                freqMap.put(nei, freqMap.get(nei) - 1);
                if (freqMap.get(nei) == 0) {
                    zeroDeg.add(nei);
                }
            }
        }

        for (int val : freqMap.values()) {
            if (val != 0) {
                return ""; // cykl — nie da się ustalić kolejności
            }
        }

        return builder.toString();
    }

}
