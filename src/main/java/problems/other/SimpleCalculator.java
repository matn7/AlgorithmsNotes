package problems.other;

public class SimpleCalculator {

    public static void main(String[] args) {
        String expression = "3 + 2 + 7";
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int eval = simpleCalculator.calculate(expression);
        System.out.println(eval);

    }

    // O(n) time | O(n) space
    public int calculate(String expression) {
        return eval_helper(expression, 0)[0];
    }

    private int[] eval_helper(String expression, int index) {
        char op = '+';
        int[] res = new int[2];
        int result = 0;
        while (index < expression.length()) {
            char c = expression.charAt(index);
            if (c == '+' || c == '-') {
                op = c;
            } else {
                int value = 0;
                if (Character.isDigit(c)) {
                    value = Character.getNumericValue(c);
                } else if (c == '(') {
                    int[] recRes = eval_helper(expression, index + 1);
                    value = recRes[0];
                    index = recRes[1];
                }
                if (op == '+') {
                    result += value;
                }
                if (op == '-') {
                    result -= value;
                }
            }
            index += 1;
        }
        res[0] = result;
        res[1] = index;
        return res;
    }



}
