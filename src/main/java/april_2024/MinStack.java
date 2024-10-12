package april_2024;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(6);
        minStack.push(10);
        minStack.push(1);
        System.out.println();
        minStack.pop();
        System.out.println();

    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
        stack.push(num);
        if (!minStack.isEmpty() && minStack.peek() < num) { // 5 < 100
            minStack.push(minStack.peek());
        } else {
            minStack.push(num);
        }

    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        Integer pop = stack.pop();
        minStack.pop();
        return pop;
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Min Stack is Empty");
        }
        return minStack.peek();
    }
}
