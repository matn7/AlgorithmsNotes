package october_2024;

import java.util.Stack;

class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int[] elem = new int[2];
        if (stack.isEmpty()) {
            elem[1] = val;
        } else {
            int min = stack.peek()[1];
            elem[1] = Math.min(val, min);
        }
        elem[0] = val;
        stack.add(elem);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

