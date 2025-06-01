package may_2025;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(n);
        System.out.println(result);
    }

    // O(2^n) time | O(2^n) space
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        helper(n, n, current, result);
        return result;
    }

    private void helper(int opening, int closing, StringBuilder curr, List<String> result) {
        if (opening > 0) {
            curr.append("(");
            helper(opening - 1, closing, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (closing > opening) {
            curr.append(")");
            helper(opening, closing - 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (opening == 0 && closing == 0) {
            result.add(curr.toString());
        }
    }

}
