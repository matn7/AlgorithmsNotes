package december_2024;

import java.util.*;

public class LetterCombination2 {

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

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(0, digits, "", res);
        return res;
    }

    private void backtrack(int i, String digits, String curStr, List<String> res) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        List<Character> characters = keyMap.get(digits.charAt(i));
        for (Character character : characters) {
            backtrack(i + 1, digits, curStr + character, res);
        }
    }

}
