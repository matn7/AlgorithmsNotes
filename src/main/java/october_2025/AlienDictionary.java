package october_2025;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
//        String[] words = {"hrn", "hrf", "er", "enn", "rfnn"};

        String[] words = {"aj","ai","ah","ag","af","ae","ad","ac","ab","ak","al","am","an","ao","ap","aq","ar","as","at",
                "au","av","aw","ax","ay","az","ba","bb","bc","bd","be","bf","bg","bh","bi","bj","bk","bl","bm","bn","bo",
                "bp","bq","br","bs","bt","bu","bv","bw","bx","by","bz"};

        AlienDictionary alienDictionary = new AlienDictionary();
        String ressult = alienDictionary.foreignDictionary(words);
        System.out.println(ressult);

    }

    // O(n^2 * m) time | O(C^2) space
    public String foreignDictionary(String[] words) {
        Set<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
        }
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : chars) {
            freqMap.put(c, 0);
        }

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String next = words[j];
                boolean matchFound = false;
                for (int k = 0; k < Math.min(curr.length(), next.length()); k++) {
                    if (curr.charAt(k) != next.charAt(k)) {
                        adj.putIfAbsent(curr.charAt(k), new HashSet<>());
                        if (!adj.get(curr.charAt(k)).contains(next.charAt(k))) {
                            adj.get(curr.charAt(k)).add(next.charAt(k));
                            freqMap.put(next.charAt(k), freqMap.get(next.charAt(k)) + 1);
                        }
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound && curr.length() > next.length()) {
                    return ""; // invalid order for example: ["abc", "ab"]
                }
            }
        }
        LinkedList<Character> zeroDeg = new LinkedList<>();
        for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
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
            freqMap.remove(current);
            builder.append(current);
            Set<Character> neighbors = adj.getOrDefault(current, Collections.emptySet());
            for (char nei : neighbors) {
                freqMap.put(nei, freqMap.getOrDefault(nei, 0) - 1);
                if (freqMap.get(nei) == 0) {
                    zeroDeg.add(nei);
                }
            }
        }

        return freqMap.isEmpty() ? builder.toString() : "";
    }

}
