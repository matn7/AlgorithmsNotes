package march_2025;

import java.util.*;

public class LetterCombinations {

    public static void main(String[] args) {
        String digit = "23";

        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations(digit);
        System.out.println(strings);
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

    // O(n*4^n) time | O(n) space
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        List<Character> curr = new ArrayList<>();
        backtrack(digits, 0, curr, result);
        return result;
    }

    private void backtrack(String digits, int i, List<Character> curr, List<String> result) {
        if (i == digits.length()) {
            StringBuilder mnemo = new StringBuilder();
            for (char c : curr) {
                mnemo.append(c);
            }
            result.add(mnemo.toString());
            return;
        }
        char key = digits.charAt(i);
        List<Character> characters = keyPad.get(key);
        for (char c : characters) {
            curr.add(c);
            backtrack(digits, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

}
