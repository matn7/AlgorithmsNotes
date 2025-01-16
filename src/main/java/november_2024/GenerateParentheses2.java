package november_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses2 {

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses2 generateParentheses = new GenerateParentheses2();
        List<String> result = generateParentheses.generateParenthesis(n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, result);
        return result;
    }

    private void helper(int opening, int closing, StringBuilder sb, List<String> result) {
        if (opening == 0 && closing == 0) {
            result.add(sb.toString());
            return;
        }

        if (opening > 0) {
            sb.append("(");
            helper(opening - 1, closing, sb, result);  // Recurse with one less open parenthesis
            sb.deleteCharAt(sb.length() - 1);  // Backtrack by removing the last character
        }

        if (closing > opening) {
            sb.append(")");
            helper(opening, closing - 1, sb, result);  // Recurse with one less close parenthesis
            sb.deleteCharAt(sb.length() - 1);  // Backtrack by removing the last character
        }
    }

}
