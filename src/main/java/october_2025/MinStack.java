package october_2025;

import java.util.ArrayDeque;

public class MinStack {

    // O(1) time | O(n) space
    ArrayDeque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int[] newElement = new int[2];
        if (stack.isEmpty()) {
            newElement[1] = val;
        } else {
            int top = stack.getLast()[1];
            newElement[1] = Math.min(top, val);
        }
        newElement[0] = val;
        stack.addLast(newElement);
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        stack.removeLast();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return stack.getLast()[0];

    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return stack.getLast()[1];
    }

}
