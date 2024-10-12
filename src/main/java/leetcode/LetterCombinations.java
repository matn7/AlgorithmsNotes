package leetcode;

import java.util.*;

public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> stringList = letterCombinations.letterCombinations("23");
        System.out.println();
    }

    static Map<String, List<String>> keyMap = new HashMap<>();
    static  {
        keyMap.put("2", Arrays.asList("a", "b", "c"));
        keyMap.put("3", Arrays.asList("d", "e", "f"));
        keyMap.put("4", Arrays.asList("g", "h", "i"));
        keyMap.put("5", Arrays.asList("j", "k", "l"));
        keyMap.put("6", Arrays.asList("m", "n", "o"));
        keyMap.put("7", Arrays.asList("p", "q", "r", "s"));
        keyMap.put("8", Arrays.asList("t", "u", "v"));
        keyMap.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    // O(4^n*n) time | O(4^n*n) space
    // 4 - "p", "q", "r", "s"
    // n num of digits
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        letterCombinationsHelper(digits, "", result);
        return result;
    }

    private void letterCombinationsHelper(String digit, String comb, List<String> result) {
        if (digit.isEmpty()) {
            result.add(comb);
            return;
        }

        String currDigit = digit.substring(0, 1);
        List<String> digitChars = keyMap.get(currDigit);
        for (String character : digitChars) {
            String newDigit = digit.substring(1);
            String newComb = comb + character;
            letterCombinationsHelper(newDigit, newComb, result);
        }
    }
}
