package september_2023;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String string = "abcdcaf";

        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        firstNonRepeatingCharacter.firstNonRepeatingCharacter(string);
    }

    // O(n) time | O(n) space
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        // a b c d c a f
        // *
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (seen.containsKey(c)) {
                seen.put(c, seen.get(c) + 1);
            } else {
                seen.put(c, 1);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (seen.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

}
