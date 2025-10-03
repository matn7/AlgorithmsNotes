package september_2025;

import java.util.ArrayDeque;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
    }

    // LIFO
    ArrayDeque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>(); // [val, min]
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            int topMin = stack.getFirst()[1];
            stack.addFirst(new int[] {val, Math.min(val, topMin)});
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        stack.removeFirst();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return stack.getFirst()[0];
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return stack.getFirst()[1];
    }

}
