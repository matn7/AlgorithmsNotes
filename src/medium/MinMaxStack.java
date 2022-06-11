package medium;

import java.util.LinkedList;

public class MinMaxStack {

    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(5);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.peek());
        System.out.println();

        minMaxStack.push(5);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        System.out.println();

        minMaxStack.push(5);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        System.out.println();
        minMaxStack.pop();
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());

    }

    LinkedList<Integer> minStack = new LinkedList<>();
    LinkedList<Integer> maxStack = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();


    public int peek() {
        // Write your code here.
        return stack.peek();
    }

    public int pop() {
        // Write your code here.
        if (minStack.isEmpty() || maxStack.isEmpty()) {
            return -1;
        }
        Integer pop = stack.pop();
        if (pop == minStack.peek()) {
            minStack.pop();
        } else if (pop == maxStack.peek()) {
            maxStack.pop();
        } else {
            minStack.pop();
            maxStack.pop();
        }
        return pop;
    }

    public void push(Integer number) {
        // Write your code here.
        stack.push(number);
        if (minStack.isEmpty() || maxStack.isEmpty()) {
            minStack.push(number);
            maxStack.push(number);
            return;
        }

        int currentMax = maxStack.peek();
        int currentMin = minStack.peek();
        if (number > currentMax) {
            maxStack.push(number);
        } else if (number < currentMin) {
            minStack.push(number);
        } else {
            minStack.push(number);
            maxStack.push(number);
        }
    }

    public int getMin() {
        // Write your code here.
        return minStack.peek();
    }

    public int getMax() {
        // Write your code here.
        return maxStack.peek();
    }
}
