package coderpro;

import java.util.Stack;

public class MaxInStack2 {

    public static void main(String[] args) {
        MaxInStack2 maxInStack2 = new MaxInStack2();
        int[] values = {1, 2, 3, 2};

        for (int val : values) {
            maxInStack2.addToStack(val);
        }

        System.out.println(maxInStack2.getMax());
        maxInStack2.pop();

        System.out.println(maxInStack2.getMax());
        maxInStack2.pop();

        System.out.println(maxInStack2.getMax());
        maxInStack2.pop();

        System.out.println(maxInStack2.getMax());
        maxInStack2.pop();

        System.out.println(maxInStack2.getMax());
        maxInStack2.pop();
    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    // stack :  1   2   3   2
    // max   :  1   2   3   3

    public void addToStack(int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            maxStack.push(value);
        } else {
            Integer currMax = maxStack.peek(); // 3
            stack.push(value);
            if (value > currMax) {
                maxStack.push(value);
            } else {
                maxStack.push(currMax);
            }
        }
    }

    // O(1) time | O(1) space
    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException("Max stack is empty");
        }
        return maxStack.peek();
    }

    // (1) time | O(1) space
    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        maxStack.pop();
        return stack.pop();

    }


}
