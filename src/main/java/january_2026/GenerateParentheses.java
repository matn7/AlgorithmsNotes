package january_2026;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(n);
        System.out.println(strings);
    }

    // O(2^n) time | O(2^n) space
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(n, n, builder, result);

        return result;
    }

    private void backtrack(int open, int close, StringBuilder builder, List<String> result) {
        if (open > 0) {
            builder.append("(");
            backtrack(open - 1, close, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close > open) {
            builder.append(")");
            backtrack(open, close - 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if(open == 0 && close == 0) {
            result.add(builder.toString());
        }
    }

}
