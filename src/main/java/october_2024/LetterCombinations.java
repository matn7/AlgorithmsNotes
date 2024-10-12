package october_2024;

import java.util.*;

public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations("238");
        System.out.println(result);
    }


    static Map<Character, List<String>> keyMap = new HashMap<>();
    static {
        keyMap.put('1', Arrays.asList("1"));
        keyMap.put('2', Arrays.asList("a", "b", "c"));
        keyMap.put('3', Arrays.asList("d", "e", "f"));
        keyMap.put('4', Arrays.asList("g", "h", "i"));
        keyMap.put('5', Arrays.asList("j", "k", "cl"));
        keyMap.put('6', Arrays.asList("m", "n", "o"));
        keyMap.put('7', Arrays.asList("p", "q", "r", "s"));
        keyMap.put('8', Arrays.asList("t", "u", "v"));
        keyMap.put('9', Arrays.asList("w", "x", "y", "z"));
        keyMap.put('0', Arrays.asList("0"));
    }

    // O(n*4^n) time | O(n*4^n) space
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        helper(digits, 0, "", result);
        return result;
    }

    private void helper(String digits, int index, String curr, List<String> result) {
        if (index == digits.length()) {
            result.add(curr);
        } else {
            char key = digits.charAt(index);
            List<String> strings = keyMap.get(key);
            for (String str : strings) {
                helper(digits, index + 1, curr + str, result);
            }
        }
    }

}
