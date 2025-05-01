package april_2025;

import java.util.Stack;

public class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            int currMax = stack.peek()[1];
            stack.push(new int[] {val, Math.min(currMax, val)});
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        stack.pop();

    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack.peek()[0];
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack.peek()[1];
    }
}
