package coderpro;

import java.util.Stack;

public class MaximumInAStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};

        MaximumInAStack maximumInAStack = new MaximumInAStack();

        for (int num : nums) {
            maximumInAStack.push(num);
        }

        maximumInAStack.pop();
        System.out.println(maximumInAStack.max());
        maximumInAStack.pop();
        System.out.println(maximumInAStack.max());
    }

    public void push(int val) {
        stack.push(val);
        if (!maxStack.isEmpty() && maxStack.peek() > val) {
            maxStack.push(maxStack.peek());
        } else {
            maxStack.push(val);
        }
    }

    public int pop() {
        if (!maxStack.isEmpty()) {
            maxStack.pop();
        }
        Integer top = stack.pop();
        return top;
    }

    public int max() {
        return maxStack.peek();
    }

    // O(n) time | O(n) space
    public int maximumInAStack2(int num) {

        if (stack.isEmpty()) {
            maxStack.push(num);
        } else {
            Integer currMax = maxStack.peek();
            if (currMax > num) {
                maxStack.push(currMax);
            } else {
                maxStack.push(num);
            }
        }
        stack.push(num);
        return maxStack.peek();
    }

}
