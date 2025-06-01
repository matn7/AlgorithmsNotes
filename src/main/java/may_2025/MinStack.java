package may_2025;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minStack.add(val);
        } else {
            int min = Math.min(minStack.peek(), val);
            minStack.add(min);
        }
        stack.add(val);

    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

}
