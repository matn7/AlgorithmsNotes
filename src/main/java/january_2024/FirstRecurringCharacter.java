package january_2024;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        System.out.println(firstRecurringChars("qwertty"));
        System.out.println(firstRecurringChars("qwerty"));
    }

    // O(n) time | O(1) space
    public static Character firstRecurringChars(String str) {
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        return null;
    }

}
