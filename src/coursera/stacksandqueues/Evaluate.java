package coursera.stacksandqueues;

public class Evaluate {

    // Dijkstras 2 Stacks algorithm
    public static void main(String[] args) {
        StackArray<Character> ops = new StackArray<>();
        StackArray<Double> vals = new StackArray<>();

        String expression = "(1+((2+3)*(4*5)))";

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                continue;
            } else if (ch == '+') {
                ops.push(ch);
            } else if (ch == '*') {
                ops.push(ch);
            } else if (ch == ')') {
                Character op = ops.pop();
                if (op == '+') {
                    vals.push(vals.pop() + vals.pop());
                } else if (op == '*') {
                    vals.push(vals.pop() * vals.pop());
                }
            } else {
                vals.push(Double.parseDouble(String.valueOf(ch)));
            }
        }

        System.out.println(vals.pop());
    }

}
