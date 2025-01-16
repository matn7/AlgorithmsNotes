package november_2024;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);
        return result;
    }

    private void helper(int opening, int closing, String curr, List<String> result) {
        if (opening > 0) {
            String newCurr = curr + "(";
            helper(opening - 1, closing, newCurr, result);
        }
        if (closing > opening) {
            String newCurr = curr + ")";
            helper(opening, closing - 1, newCurr, result);
        }
        if (closing == 0) {
            result.add(curr);
        }
    }

}
