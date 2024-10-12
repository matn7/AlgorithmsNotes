package november_2023;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> result = generateParentheses(3);
    }

    // O(2^n) time | O(2^n) space
    public static List<String> generateParentheses(int num) {

        List<String> result = new ArrayList<>();
        generateParenthesesHelper(0, 0, "", num, result);
        return result;
    }

    private static void generateParenthesesHelper(int open, int close, String word, int num, List<String> result) {
        if (open < num) {
            String newWord = word + "(";
            generateParenthesesHelper(open + 1, close, newWord, num, result);
        }
        if (close < open) {
            String newWord = word + ")";
            generateParenthesesHelper(open, close + 1, newWord, num, result);
        }
        if (close == num) {
            result.add(word);
        }
    }

}
