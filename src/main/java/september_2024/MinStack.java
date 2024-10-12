package september_2024;


import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack(3);
        minStack.push(1);
        minStack.push(5);
        minStack.push(-3);
        System.out.println("minStack : stack");
        System.out.println(minStack.min() + " : " + minStack.peek());
        minStack.pop();
        System.out.println(minStack.min() + " : " + minStack.peek());
        minStack.pop();
        System.out.println(minStack.min() + " : " + minStack.peek());
    }

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    int capacity;

    public MinStack(int capacity) {
        stack = new Stack<>();
        minStack = new Stack<>();
        this.capacity = capacity;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        if (stack.isEmpty()) {
            stack.push(value);
            minStack.push(value);
        } else {
            Integer min = minStack.peek();
            if (min < value) {
                minStack.push(min);
            } else {
                minStack.push(value);
            }
            stack.push(value);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Integer result = stack.pop();
        minStack.pop();
        return result;
    }

    public int min() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek();
    }

    private boolean isFull() {
        return stack.size() == capacity;
    }

    private boolean isEmpty() {
        return stack.size() == 0;
    }
}
