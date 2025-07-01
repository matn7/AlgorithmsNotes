package june_2025;

import java.util.Stack;

public class MinStack2 {

    Stack<int[]> stack;

    public MinStack2() {
        stack = new Stack<>();
    }

    // O(1) time | O(1) space
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            int min = stack.peek()[1];
            stack.push(new int[] {val, Math.min(min, val)});
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
