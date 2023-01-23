package coderpro;

import java.util.HashMap;
import java.util.Map;

public class CharacterMapping {

    public static void main(String[] args) {
        CharacterMapping characterMapping = new CharacterMapping();
        boolean res1 = characterMapping.has_character_map("abc", "def");
        boolean res2 = characterMapping.has_character_map("aac", "def");
        System.out.println(res1);
        System.out.println(res2);
    }

    // O(n) time | O(n) space
    public boolean has_character_map(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> chars = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!chars.containsKey(s1.charAt(i))) {
                chars.put(s1.charAt(i), s2.charAt(i));
            } else {
                if (chars.get(s1.charAt(i)) != s2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
