package november_2023;

import java.util.HashMap;
import java.util.Map;

public class CharacterMapping {

    public static void main(String[] args) {
        String s1 = "aac";
        String s2 = "def";

        System.out.println(characterMapping(s1, s2));
    }

    // O(n) time | O(n) space
    public static boolean characterMapping(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (mapping.containsKey(c1)) {
                Character toCompare = mapping.get(c1);
                if (toCompare != c2) {
                    return false;
                }
            } else {
                mapping.put(c1, c2);
            }
        }
        return true;

    }

}
