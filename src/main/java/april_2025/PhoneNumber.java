package april_2025;

import java.util.*;

public class PhoneNumber {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        String digits = "23";
        List<String> result = phoneNumber.letterCombinations(digits);
        System.out.println(result);

    }

    static Map<Character, List<Character>> keyPad = new HashMap<>();
    static {
        keyPad.put('2', Arrays.asList('a', 'b', 'c'));
        keyPad.put('3', Arrays.asList('d', 'e', 'f'));
        keyPad.put('4', Arrays.asList('g', 'h', 'i'));
        keyPad.put('5', Arrays.asList('j', 'k', 'l'));
        keyPad.put('6', Arrays.asList('m', 'n', 'o'));
        keyPad.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyPad.put('8', Arrays.asList('t', 'u', 'v'));
        keyPad.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    // O(4^n) time | O(n*4^n) space
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        StringBuilder builder = new StringBuilder();
        helper(digits, 0, builder, result);
        return result;
    }

    private void helper(String digits, int i, StringBuilder builder, List<String> result) {
        if (i == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char d = digits.charAt(i);
        List<Character> characters = keyPad.get(d);
        for (char c : characters) {
            builder.append(c);
            helper(digits, i + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


}
