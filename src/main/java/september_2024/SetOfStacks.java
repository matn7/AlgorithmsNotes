package september_2024;

import java.util.Stack;

public class SetOfStacks {


    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);

        for (int i = 0; i <= 10; i++) {
            setOfStacks.push(i);
        }
        System.out.println(setOfStacks.size());
        setOfStacks.pop();
        setOfStacks.pop();
        System.out.println();
        setOfStacks.pop();
        System.out.println();
    }

    Stack<Stack<Integer>> parentStack;

    int childStackCapacity;

    public SetOfStacks(int childStackCapacity) {
        this.childStackCapacity = childStackCapacity;
        this.parentStack = new Stack<>();
    }

    public void push(int value) {
        if (parentStack.isEmpty()) {
            Stack<Integer> newChildStack = new Stack<>();
            newChildStack.push(value);
            parentStack.push(newChildStack);
        } else {
            Stack<Integer> topChildStack = parentStack.peek();
            if (topChildStack.size() == childStackCapacity) {
                // we need a new child stack
                Stack<Integer> newChildStack = new Stack<>();
                newChildStack.push(value);
                parentStack.push(newChildStack);
            } else {
                topChildStack.push(value);
            }
        }
    }

    public int pop() {
        if (parentStack.isEmpty()) {
            throw new RuntimeException("There is no elements in stack");
        }
        Stack<Integer> topChildStack = parentStack.peek();
        Integer valueToReturn = topChildStack.pop();
        if (topChildStack.isEmpty()) {
            parentStack.pop();
        }
        return valueToReturn;
    }

    public int peek() {
        if (parentStack.isEmpty()) {
            throw new RuntimeException("There is no elements in stack");
        }
        Stack<Integer> topChildStack = parentStack.peek();
        return topChildStack.peek();
    }

    public int size() {
        if (parentStack.isEmpty()) {
            return 0;
        }
        int fullChildStackSizes = (parentStack.size() - 1) * childStackCapacity;
        return fullChildStackSizes + parentStack.peek().size();
    }
}
