package july_2025;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(n);
        System.out.println(result);
    }

    // O(2^n) time | O(n) space
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(n, n, builder, result);
        return result;
    }

    private void helper(int opening, int closing, StringBuilder builder, List<String> result) {
        if (opening > 0) {
            builder.append("(");
            helper(opening - 1, closing, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (opening < closing) {
            builder.append(")");
            helper(opening, closing - 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (opening == 0 && closing == 0) {
            result.add(builder.toString());
        }
    }

}
