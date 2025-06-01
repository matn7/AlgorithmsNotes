package may_2025;

import java.util.*;
import java.util.function.BiFunction;

public class EvalRPN {

    public static void main(String[] args) {
//        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens = {"4","13","5","/","+"};
        EvalRPN evalRPN = new EvalRPN();
        int result = evalRPN.evalRPN(tokens);
        System.out.println(result);
    }

    Map<String, BiFunction<Integer, Integer, Integer>> op;
    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        op = new HashMap<>();
        op.put("+", (a, b) -> a + b);
        op.put("-", (a, b) -> a - b);
        op.put("*", (a, b) -> a * b);
        op.put("/", (a, b) -> a / b);
        List<String> tokensArr = new ArrayList<>(Arrays.asList(tokens));

        return helper(tokensArr);
    }

    private int helper(List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);
        if (!op.containsKey(token)) {
            return Integer.parseInt(token);
        }
        int b = helper(tokens);
        int a = helper(tokens);
        return op.get(token).apply(a, b);
    }

    // O(n) time | O(n) space
    public int evalRPN2(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Map<String, BiFunction<Integer, Integer, Integer>> op = new HashMap<>();
        op.put("+", (a, b) -> a + b);
        op.put("-", (a, b) -> a - b);
        op.put("*", (a, b) -> a * b);
        op.put("/", (a, b) -> a / b);

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (op.containsKey(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int val = op.get(token).apply(a, b);
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
