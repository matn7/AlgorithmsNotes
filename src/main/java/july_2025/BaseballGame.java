package july_2025;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] operations = {"5","2","C","D","+"};

        BaseballGame baseballGame = new BaseballGame();
        int result = baseballGame.calPoints(operations);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                int prev = stack.pop();
                stack.push(prev);
                stack.push(prev * 2);
            } else if (op.equals("+")) {
                int prev1 = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2);
                stack.push(prev1);
                stack.push(prev1 + prev2);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
