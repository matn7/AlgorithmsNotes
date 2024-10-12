package udemy.faang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "aab"; // { 'a': [0, 1], 'b': [2]}
        String p = "aa*"; // { 'a': [0, 1], 'b': [2]}

        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        boolean match = regularExpressionMatching.isMatch(s, p);
        System.out.println(match);
    }

    public boolean isMatch(String s, String p) {

        Map<Character, List<Integer>> sMap = new HashMap<>();
        Map<Character, List<Integer>> pMap = new HashMap<>();

        populateMap(s, sMap);
        populateMap(p, pMap);

        if (pMap.containsKey('*') && pMap.containsKey('.')) {

        } else if (pMap.containsKey('*')) {
            System.out.println();

        } else if (pMap.containsKey('.')) {

        } else {
            // no key check if
            for (Map.Entry<Character, List<Integer>> entry : sMap.entrySet()) {
                Character key = entry.getKey();
                List<Integer> stringIdx = entry.getValue();
                if (!pMap.containsKey(key)) {
                    return false;
                }
                List<Integer> patternIdx = pMap.get(key);
                for (int i = 0; i < stringIdx.size(); i++) {
                    if (stringIdx.get(i) != patternIdx.get(i)) {
                        return false;
                    }
                }
            }
        }

        return true;

    }

    private void populateMap(String str, Map<Character, List<Integer>> map) {
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (map.containsKey(curr)) {
                List<Integer> indexes = map.get(curr);
                indexes.add(i);
                map.put(curr, indexes);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                map.put(curr, indexes);
            }
        }
    }


}
