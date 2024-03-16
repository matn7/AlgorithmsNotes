package october_2023;

import java.util.Stack;

public class MaximumInAStack {

    public static void main(String[] args) {
        MaximumInAStack maximumInAStack = new MaximumInAStack();
    }

    Stack<Integer> stack = new Stack<>();    // [1, -100]
    Stack<Integer> maxStack = new Stack<>(); // [1,    1]

    public int push(int value) {
        stack.push(value);
        if (maxStack.isEmpty()) {
            stack.push(value);
        } else {
            Integer top = maxStack.peek(); // 1
            if (top > value) { // 1 > -100
                maxStack.push(top);
            } else {
                maxStack.push(value);
            }
        }
        return value;
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        maxStack.pop();
        return stack.pop();
    }

    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return maxStack.peek();
    }


}
