package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    // O(n) time | O(1) space (O(26), 26 characters)
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char key = string.charAt(i);
            if (seen.containsKey(key)) {
                seen.put(key, seen.get(key) + 1);
            } else {
                seen.put(key, 1);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            char key = string.charAt(i);
            if (seen.get(key) == 1) {
                return i;
            }
        }

        return -1;
    }
}
