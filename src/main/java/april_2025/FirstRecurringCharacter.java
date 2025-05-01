package april_2025;

import july_2024.CoinChange;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        String string = "qwertty";

        FirstRecurringCharacter firstRecurringCharacter = new FirstRecurringCharacter();
        char result = firstRecurringCharacter.firstRecurringChars(string);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public char firstRecurringChars(String str) {
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
