package december_2023;

public class SimpleCalculator {

    public static void main(String[] args) {
        String expression = "- ( 3 + ( 2 - 1 ) )";

        int result = eval(expression);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int eval(String expression) {
        return evalHelper(expression, 0).result;
    }

    private static EvalInfo evalHelper(String expression, int index) {
        char op = '+';
        int result = 0;

        while (index < expression.length()) {
            char character = expression.charAt(index);
            if (character == '+' || character == '-') {
                op = character;
            } else {
                int value = 0;
                if (Character.isDigit(character)) {
                    value = character - '0';
                } else if (character == '(') {
                    EvalInfo info = evalHelper(expression, index + 1);
                    value = info.result;
                    index = info.index;
                }
                if (op == '+') {
                    result += value;
                }
                if (op == '-') {
                    result -= value;
                }
            }
            index++;
        }

        return new EvalInfo(result, index);
    }

    static class EvalInfo {
        int result;
        int index;

        public EvalInfo(int result, int index) {
            this.result = result;
            this.index = index;
        }
    }


}
