package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutDuplicationNOT {

    public static void main(String[] args) {
        String str = "clementisacap";
        String result = longestSubstringWithoutDuplication(str);
        System.out.println();
    }

    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        Map<Character, Integer> lastSeen = new HashMap<>();
        List<Integer[]> allOccurs = new ArrayList<>();
        int start = 0;
        int end = 0;

        char curr = ' ';
        for (int idx = 0; idx < str.length(); idx++) {
            curr = str.charAt(idx);
            if (lastSeen.containsKey(curr)) {
                Integer last = lastSeen.get(curr);
                if (!allOccurs.isEmpty()) {
                    Integer[] topElement = allOccurs.get(allOccurs.size() - 1);
                    if (last < topElement[1]) {
                        start = topElement[1];
                    }
                    end = idx;
                    allOccurs.add(new Integer[]{start, end});
                    start = idx;
                } else {
                    allOccurs.add(new Integer[]{start, last + 1});
                    start = last + 1;
                }
                lastSeen.put(curr, idx);
            } else {
                lastSeen.put(curr, idx);
            }
        }

        Integer[] topElem = allOccurs.remove(allOccurs.size() - 1);
        topElem[1] = str.length();
        allOccurs.add(topElem);

        Integer[] maxRange = {0, 0};
        for (Integer[] element : allOccurs) {
            if (element[1] - element[0] > maxRange[1] - maxRange[0]) {
                maxRange[0] = element[0];
                maxRange[1] = element[1];
            }
        }

        return str.substring(maxRange[0], maxRange[1] + 1);
    }



}
