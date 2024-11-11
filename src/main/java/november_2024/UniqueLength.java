package november_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueLength {

    public static void main(String[] args) {
        String s = "aabca";
        UniqueLength uniqueLength = new UniqueLength();
        int result = uniqueLength.countPalindromicSubsequence(s);
        System.out.println(result);
    }

    public int countPalindromicSubsequence(String s) {
        Set<String> res = new HashSet<>();
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            right.put(s.charAt(i), right.get(s.charAt(i)) - 1);
            if (right.get(s.charAt(i)) == 0) {
                right.remove(s.charAt(i));
            }
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (left.contains(c) && right.containsKey(c)) {
                    res.add(s.charAt(i) + "" + c);
                }
            }
            left.add(s.charAt(i));
        }
        return res.size();
    }



}
