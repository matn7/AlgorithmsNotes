package july_2025;

import java.util.*;

public class PhoneNumber {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        List<String> result = phoneNumber.letterCombinations("23");
        System.out.println(result);
    }

    static Map<Character, List<Character>> keyMap = new HashMap<>();

    static {
        keyMap.put('1', Arrays.asList('1'));
        keyMap.put('2', Arrays.asList('a', 'b', 'c'));
        keyMap.put('3', Arrays.asList('d', 'e', 'f'));
        keyMap.put('4', Arrays.asList('g', 'h', 'i'));
        keyMap.put('5', Arrays.asList('j', 'k', 'l'));
        keyMap.put('6', Arrays.asList('m', 'n', 'o'));
        keyMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyMap.put('8', Arrays.asList('t', 'u', 'v'));
        keyMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        keyMap.put('0', Arrays.asList('0'));
    }

    // O(n * 4^n) time | O(n * 4^n) space
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        StringBuilder builder = new StringBuilder();
        backtrack(digits, 0, builder, result);
        return result;
    }

    private void backtrack(String digits, int i, StringBuilder builder, List<String> result) {
        if (builder.length() == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char curr = digits.charAt(i);
        List<Character> letters = keyMap.get(curr);
        for (char letter : letters) {
            builder.append(letter);
            backtrack(digits, i + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
