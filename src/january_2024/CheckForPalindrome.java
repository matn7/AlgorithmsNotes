package january_2024;

import java.util.HashMap;
import java.util.Map;

public class CheckForPalindrome {

    public static void main(String[] args) {
        String result = findPalindrome("foxfo");
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String findPalindrome(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (!charCounts.containsKey(c)) {
                charCounts.put(c, 0);
            }
            charCounts.put(c, charCounts.get(c) + 1);
        }

        StringBuilder pal = new StringBuilder();
        char oddChar = ' ';

        for (Map.Entry<Character, Integer> element : charCounts.entrySet()) {
            int cnt = element.getValue();
            char c = element.getKey();
            if (cnt % 2 == 0) {
                pal.append(String.valueOf(c).repeat(Math.max(0, cnt / 2)));
            } else if (oddChar == ' ') {
                oddChar = c;
                pal.append(String.valueOf(c).repeat(Math.max(0, cnt / 2)));
            } else {
                return "";
            }
        }
        String forward = pal.toString();
        StringBuilder reverse = pal.reverse();
        return forward + oddChar + reverse;

    }

}
