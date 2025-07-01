package june_2025;

import java.util.*;

public class AlienDictionary {


    public static void main(String[] args) {
        String[] words = {"hrn","hrf","er","enn","rfnn"}; // "hernf"
//        String[] words = {"wrtkj","wrt"};
//        String[] words = {"mnop","nopq","opqr","pqrs","qrst","rstu","stuv","tuvw","uvwx","vwxy","wxyz","xyz","yz","z",
//                "mnopqr","nopqrs","opqrst","pqrstu","qrstuv","rstuvw","stuvwx","tuvwxy","uvwxyz","vwxyz","wxyza","xyzab","yzabc","zabcd"};

        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.foreignDictionary(words);
        System.out.println(result);
    }

    // O(V + E) time | O(V + E) space
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                freqMap.putIfAbsent(c, 0);
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
                        freqMap.put(c2, freqMap.get(c2) + 1);
                    }
                    break;
                }
                j++;
                if (j == word2.length() && word1.length() > word2.length()) {
                    return "";
                }
            }
        }

        Queue<Character> zeroDeg = new LinkedList<>();
        for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() == 0) {
                zeroDeg.add(elem.getKey());
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!zeroDeg.isEmpty()) {
            Character removed = zeroDeg.poll();
            builder.append(removed);
            Set<Character> neighbors = adj.get(removed);
            for (char c : neighbors) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) - 1);
                if (freqMap.get(c) == 0) {
                    zeroDeg.add(c);
                }
            }
        }

        for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() != 0) {
                return "";
            }
        }

        return builder.toString();
    }


}
