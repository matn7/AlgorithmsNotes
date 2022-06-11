package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (seen.containsKey(current)) {
                seen.put(current, seen.get(current) + 1);
            } else {
                seen.put(current, 1);
            }
        }

        Map<Character, Boolean> seenOnce = new HashMap<>();
        for (Map.Entry<Character, Integer> element : seen.entrySet()) {
            if (element.getValue() == 1) {
                seenOnce.put(element.getKey(), Boolean.TRUE);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (seenOnce.containsKey(current)) {
                return i;
            }
        }

        return -1;
    }

}
