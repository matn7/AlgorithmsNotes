package january_2026;

import java.util.ArrayDeque;
import java.util.Stack;

public class MaxStack2 {

    public static void main(String[] args) {
        MaxStack2 maxStack = new MaxStack2();
        maxStack.push(5);
        maxStack.push(1);

        System.out.println();
        maxStack.popMax();
        System.out.println();
    }

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack2() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            maxStack.push(Math.max(x, maxStack.peek()));
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();

        // zdejmujemy elementy aż trafimy na max
        while (stack.peek() != max) {
            buffer.push(pop());
        }

        // usuwamy max
        pop();

        // odkładamy pozostałe elementy
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return max;
    }

}
