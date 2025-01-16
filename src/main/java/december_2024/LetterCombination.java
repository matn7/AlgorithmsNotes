package december_2024;

import java.util.*;

public class LetterCombination {

    public static void main(String[] args) {
        String digits = "23";
        LetterCombination letterCombination = new LetterCombination();
        List<String> strings = letterCombination.letterCombinations(digits);
        System.out.println(strings);
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

    // O(n*4^n) time | O(n) space
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        StringBuilder builder = new StringBuilder();
        List<Character> part = new ArrayList<>();
        dfs(digits, 0, part, builder, result);
        return result;
    }

    private void dfs(String digits, int index, List<Character> part, StringBuilder builder, List<String> result) {
        if (index == digits.length()) {
            for (Character c : part) {
                builder.append(c);
            }
            result.add(builder.toString());
            builder.setLength(0);
        } else {
            char currChar = digits.charAt(index);
            List<Character> characters = keyMap.get(currChar);
            for (Character character : characters) {
                part.add(character);
                dfs(digits, index + 1, part, builder, result);
                part.remove(part.size() - 1);
            }
        }
    }

}
