package january_2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        PhoneNumber phoneNumber = new PhoneNumber();
        List<String> result = phoneNumber.letterCombinations(digits);
        System.out.println(result);
    }

    static Map<Character, List<Character>> keyMap;

    static {
        keyMap = new HashMap<>();
        keyMap.put('1', List.of('1'));
        keyMap.put('2', List.of('a', 'b', 'c'));
        keyMap.put('3', List.of('d', 'e', 'f'));
        keyMap.put('4', List.of('g', 'h', 'i'));
        keyMap.put('5', List.of('j', 'k', 'l'));
        keyMap.put('6', List.of('m', 'n', 'o'));
        keyMap.put('7', List.of('p', 'q', 'r', 's'));
        keyMap.put('8', List.of('t', 'u', 'v'));
        keyMap.put('9', List.of('w', 'x', 'y', 'z'));
        keyMap.put('0', List.of('0'));
    }

    // O(n * 4^n) time | O(n * 4^n) space
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(digits, 0, builder, result);
        return result;
    }

    private void backtrack(String digits, int i, StringBuilder builder, List<String> result) {
        if (builder.length() == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char key = digits.charAt(i);
        List<Character> characters = keyMap.get(key);
        for (char c : characters) {
            builder.append(c);
            backtrack(digits, i + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
