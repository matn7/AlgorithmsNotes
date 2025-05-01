package april_2025;

import october_2024.CoinChange;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println(result);
    }

    // O(2^n) time | O(2^n) space
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(n, n, builder, result);
        return result;
    }

    private void helper(int open, int close, StringBuilder builder, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(builder.toString());
            return;
        }
        if (open > 0) {
            builder.append("(");
            helper(open - 1, close, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close > open) {
            builder.append(")");
            helper(open, close - 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
