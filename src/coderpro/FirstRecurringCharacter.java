package coderpro;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        String str = "qwertty";

        FirstRecurringCharacter firstRecurringCharacter = new FirstRecurringCharacter();
        char result = firstRecurringCharacter.firstRecurring(str);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public char firstRecurring(String str) {
        Map<Character, Boolean> seen = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (seen.containsKey(c)) {
                return c;
            } else {
                seen.put(c, Boolean.TRUE);
            }
        }
        return ' ';
    }

}
