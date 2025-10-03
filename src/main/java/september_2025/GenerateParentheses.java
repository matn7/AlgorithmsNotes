package september_2025;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(n);
        System.out.println(result);
    }

    // O(4^n / (n ^ 1/2)) time | O(n) space
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(n, 0, 0, builder, result);
        return result;
    }

    private void helper(int n, int open, int close, StringBuilder builder, List<String> result) {
        if (open < n) {
            builder.append("(");
            helper(n, open + 1, close, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(")");
            helper(n, open, close + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (open == n && close == n) {
            result.add(builder.toString());
        }
    }

}
