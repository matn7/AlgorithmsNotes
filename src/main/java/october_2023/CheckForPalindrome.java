package october_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckForPalindrome {

    public static void main(String[] args) {
        String str = "foxxxfoooooffff";

        palindrome(str);
    }

    public static String palindrome(String str) {
        // all chars in str are even "fofo
        // all chars in str are even + one odd "foxfo"
        Map<Character, Integer> countsMap = generateCountsMap(str);

        char oddCharacter = ' '; // we can only have one odd character

        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (Map.Entry<Character, Integer> element : countsMap.entrySet()) {
            char c = element.getKey(); // f
            Integer counts = element.getValue();
            if (counts % 2 == 1) {
                // odd number
                if (oddCharacter != ' ') {
                    // we already have one odd character cannot create palindrome.
                    return "";
                }
                oddCharacter = c;
            } else {
                builder.append(String.valueOf(c).repeat(Math.max(0, counts / 2)));
                stack.push(c);
            }
        }

        if (oddCharacter != ' ') {
            Integer oddCounts = countsMap.get(oddCharacter);
            builder.append(String.valueOf(oddCharacter).repeat(Math.max(0, oddCounts)));
        }

        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            Integer counts = countsMap.get(pop);
            builder.append(String.valueOf(pop).repeat(Math.max(0, counts / 2)));
        }

        return builder.toString();
    }

    private static Map<Character, Integer> generateCountsMap(String str) {
        Map<Character, Integer> charsMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (charsMap.containsKey(c)) {
                charsMap.put(c, charsMap.get(c) + 1);
            } else {
                charsMap.put(c, 1);
            }
        }
        return charsMap;
    }

}
