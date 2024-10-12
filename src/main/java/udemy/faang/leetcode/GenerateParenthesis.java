package udemy.faang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println(result);
    }

    //      2 * n!
    // ----------------
    //   n! * (n + 1)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper("", n, n, result);
        return result;
    }

    private void generateParenthesisHelper(String paren, int opening, int closing, List<String> result) {
        if (opening > 0) {
            String newStr = paren + "(";
            generateParenthesisHelper(newStr, opening - 1, closing, result);
        }
        if (closing > opening) {
            String newStr = paren + ")";
            generateParenthesisHelper(newStr, opening, closing - 1, result);
        }
        if (closing == 0) {
            result.add(paren);
        }
    }

}
