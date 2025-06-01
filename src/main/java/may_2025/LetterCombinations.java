package may_2025;

import java.util.*;

public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations(digits);
        System.out.println(result);
    }

    static Map<Character, List<Character>> keyMap;
    static {
        keyMap = new HashMap<>();
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

    // O(n*4^n) time | O(n) space
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
        if (i == digits.length()) {
            result.add(builder.toString());
            return;
        }
        List<Character> chars = keyMap.get(digits.charAt(i));
        for (char c : chars) {
            builder.append(c);
            backtrack(digits, i + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
