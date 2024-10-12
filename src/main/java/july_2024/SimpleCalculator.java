package july_2024;

public class SimpleCalculator {

    public static void main(String[] args) {
        int result = eval("3 + 2 + 7");
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static int eval(String expression) {
        return evalHelper(expression, 0)[0];
    }

    private static int[] evalHelper(String expression, int index) {
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
                } else if ( c == '(') {
                    int[] recRes = evalHelper(expression, index + 1);
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
            index++;
        }
        res[0] = result;
        res[1] = index;
        return res;
    }

}
