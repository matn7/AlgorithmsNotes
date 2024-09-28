package problems.other;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.genParens(3);

    }

    // O(2^n) time | O(2^n) space
    public List<String> genParens(int n) {
        List<String> result = new ArrayList<>();

        genParensHelper(n, 0, 0, "", result);

        return result;
    }

    private void genParensHelper(int n, int left, int right, String str, List<String> result) {
        if (left + right == 2 * n) {
            result.add(str);
            return;
        }
        if (left < n) {
            genParensHelper(n, left + 1, right, str + "(", result);
        }
        if (right < left) {
            // (() - there is a possibility to create valid example
            // ()) - it is not right > left
            genParensHelper(n, left, right + 1, str + ")", result);
        }
    }


    // O(2^n) time | O(2^n) space
    public List<String> genParenMy(int n) {
        List<String> result = new ArrayList<>();
        genParenHelperMy(n, n, "", result);
        return result;
    }

    private void genParenHelperMy(int open, int closing, String curr, List<String> result) {
        if (open > 0) {
            String newCurr = curr + "(";
            genParenHelperMy(open - 1, closing, newCurr, result);
        }
        if (closing > open) {
            String newCurr = curr + ")";
            genParenHelperMy(open, closing - 1, newCurr, result);
        }
        if (closing == 0) {
            result.add(curr);
        }
    }

}
