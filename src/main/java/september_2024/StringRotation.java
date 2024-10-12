package september_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "watxerbotwatle";
        String s2 = "erbotwatlewatx";

        StringRotation stringRotation = new StringRotation();
        boolean result = stringRotation.stringRotation(s1, s2);
        System.out.println(result);

        boolean rotation = stringRotation.isRotation(s1, s2);
        System.out.println(rotation);
    }

    // O(n^2) time | O(n) space
    public boolean stringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> s1FreqMap = populateFreqMap(s1);
        Map<Character, Integer> s2FreqMap = populateFreqMap(s2);
        if (!checkFrequencies(s1FreqMap, s2FreqMap)) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        int count1 = s1.length();
        int index = 0;
        while (index < s2.length()) {
            while (p1 < s1.length() && s1.charAt(p1) == s2.charAt(p2 % s2.length())) {
                p1++;
                p2++;
                count1--;
            }
            if (count1 == 0) {
                return true;
            }
            p2 = index;
            count1 = s1.length();
            p1 = 0;
            p2++;
            index++;

        }
        return true;
    }

    private boolean checkFrequencies(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> element : map1.entrySet()) {
            Character key = element.getKey();
            Integer value = element.getValue();
            if (!map2.containsKey(key) || !Objects.equals(map2.get(key), value)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> populateFreqMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    // Book
    boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

}
