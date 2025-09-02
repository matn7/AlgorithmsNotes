package august_2025;

import java.util.*;

public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations(digits);
        System.out.println(result);
    }

    static Map<Character, List<Character>> kepMap = new HashMap<>();

    static {
        kepMap.put('1', Arrays.asList('1'));
        kepMap.put('2', Arrays.asList('a', 'b', 'c'));
        kepMap.put('3', Arrays.asList('d', 'e', 'f'));
        kepMap.put('4', Arrays.asList('g', 'h', 'i'));
        kepMap.put('5', Arrays.asList('j', 'k', 'l'));
        kepMap.put('6', Arrays.asList('m', 'n', 'o'));
        kepMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        kepMap.put('8', Arrays.asList('t', 'u', 'v'));
        kepMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        kepMap.put('0', Arrays.asList('0'));
    }

    // O(n * 4^n) time | O(n) space
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        StringBuilder builder = new StringBuilder();

        dfs(digits, 0, builder, result);

        return result;
    }

    private void dfs(String digits, int idx, StringBuilder builder, List<String> result) {
        if (idx == digits.length()) {
            result.add(builder.toString());
            return;
        }

        char ch = digits.charAt(idx);
        List<Character> chars = kepMap.get(ch);
        for (char c : chars) {
            builder.append(c);
            dfs(digits, idx + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


}
