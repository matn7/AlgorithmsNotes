package december_2025;

import java.util.*;

public class PhoneKeypadCombinations {

    public static void main(String[] args) {
        PhoneKeypadCombinations phoneKeypadCombinations = new PhoneKeypadCombinations();
        String digits = "69";
        List<String> result = phoneKeypadCombinations.letterCombinations(digits);
        System.out.println(result);
    }

    static Map<Character, List<Character>> keyPad;

    static {
        keyPad = new HashMap<>();
        keyPad.put('1', Arrays.asList('1'));
        keyPad.put('2', Arrays.asList('a', 'b', 'c'));
        keyPad.put('3', Arrays.asList('d', 'e', 'f'));
        keyPad.put('4', Arrays.asList('g', 'h', 'i'));
        keyPad.put('5', Arrays.asList('j', 'k', 'l'));
        keyPad.put('6', Arrays.asList('m', 'n', 'o'));
        keyPad.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyPad.put('8', Arrays.asList('t', 'u', 'v'));
        keyPad.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        keyPad.put('0', Arrays.asList('0'));
    }

    // O(n * 4^n) time | O(n) space
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        dfs(digits, 0, builder, result);
        return result;
    }

    private void dfs(String digits, int i, StringBuilder builder, List<String> result) {
        if (i == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char curr = digits.charAt(i);
        List<Character> chars = keyPad.get(curr);
        for (char c : chars) {
            builder.append(c);
            dfs(digits, i + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
