package june_2025;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(3);
        System.out.println(result);
    }

    // O(2^n) time | O(2^n) space
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(0, 0, n, builder, result);
        return result;
    }

    private void dfs(int open, int close, int n, StringBuilder builder, List<String> result) {
        if (open < n) {
            builder.append("(");
            dfs(open + 1, close, n, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(")");
            dfs(open, close + 1, n, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (open == n && close == n) {
            result.add(builder.toString());
        }
    }


}
