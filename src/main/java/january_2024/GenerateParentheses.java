package january_2024;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        generateParentheses(3);
    }

    // O(2^n) time | O(2^n) space
    public static List<String> generateParentheses(int num) {
        List<String> result = new ArrayList<>();
        generateParenthesesHelper(num, 0, 0, "", result);
        return result;
    }

    private static void generateParenthesesHelper(int num, int open, int close, String curr, List<String> result) {
        if (open < num) {
            String newStr = curr + "(";
            generateParenthesesHelper(num, open + 1, close, newStr, result);
        }
        // ((
        if (close < open) {
            String newStr = curr + ")";
            generateParenthesesHelper(num, open, close + 1, newStr, result);
        }

        if (close == num) {
            result.add(curr);
        }
    }



}
