package problems.other;

import java.util.HashMap;
import java.util.Map;

public class CheckForPalindrome {

    public static void main(String[] args) {
        String str = "foxfo";

        CheckForPalindrome checkForPalindrome = new CheckForPalindrome();
        checkForPalindrome.find_palindrome(str);
    }

    // O(n) time | O(n) space
    public String find_palindrome(String str) {
        Map<Character, Integer> char_counts = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (char_counts.containsKey(c)) {
                char_counts.put(c, char_counts.get(c) + 1);
            } else {
                char_counts.put(c, 1);
            }
        }

        StringBuilder pal = new StringBuilder();
        char odd_char = ' ';
        for (Map.Entry<Character, Integer> element : char_counts.entrySet()) {
            Character c = element.getKey();
            Integer cnt = element.getValue();
            if (cnt % 2 == 0) {
                pal.append(String.valueOf(c).repeat(Math.max(0, cnt / 2)));
            } else if (odd_char == ' ') {
                odd_char = c;
                pal.append(String.valueOf(c).repeat(Math.max(0, cnt / 2)));
            } else {
                return null;
            }
        }
        String palStr = pal.toString();

        StringBuilder palRev = new StringBuilder();
        for (int i = palStr.length() - 1; i >= 0; i--) {
            palRev.append(palStr.charAt(i));
        }

        String palRevStr = palRev.toString();

        String result = palStr + odd_char + palRevStr;
        return result;
    }

}
