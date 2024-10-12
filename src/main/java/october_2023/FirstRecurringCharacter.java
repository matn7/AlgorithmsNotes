package october_2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        String str = "qwertty";

        char result = firstRecurringCharacter(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static char firstRecurringCharacter(String str) {
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }

        return ' ';
    }

}
