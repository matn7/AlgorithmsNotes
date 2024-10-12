package october_2024;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(3);
        System.out.println(strings);
    }

    // O(2^n) time | O(2^n) space
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);
        return result;
    }

    private void helper(int opening, int closing, String curr, List<String> result) {
        if (opening > 0) {
            String newRes = curr + "(";
            helper(opening - 1, closing, newRes, result);
        }
        if (closing > opening) {
            String newRes = curr + ")";
            helper(opening, closing - 1, newRes, result);
        }
        if (closing == 0) {
            result.add(curr);
        }
    }

}
