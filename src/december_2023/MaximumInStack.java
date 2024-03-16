package december_2023;

import java.util.Stack;

public class MaximumInStack {

    public static void main(String[] args) {
        MaximumInStack maximumInStack = new MaximumInStack();

        int[] nums = {1, 2, 3, 2};
        for (int num : nums) {
            maximumInStack.push(num);
        }

        System.out.println(maximumInStack.max());
        maximumInStack.pop();
        System.out.println(maximumInStack.max());
        maximumInStack.pop();
        System.out.println(maximumInStack.max());
    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> max = new Stack<>();

    public int push(int val) {
        if (max.isEmpty()) {
            max.push(val);
        } else {
            Integer currMax = max.peek();
            if (val > currMax) {
                max.push(val);
            } else {
                max.push(currMax);
            }
        }
        stack.push(val);
        return val;
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Integer removed = stack.pop();
        max.pop();
        return removed;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek();
    }

    public int max() {
        if (max.isEmpty()) {
            throw new RuntimeException("Max Stack is empty");
        }
        return max.peek();
    }

}
