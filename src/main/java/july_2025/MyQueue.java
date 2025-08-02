package july_2025;


import java.util.Stack;

public class MyQueue {

    Stack<Integer> forward;
    Stack<Integer> reverse;

    public MyQueue() {
        forward = new Stack<>();
        reverse = new Stack<>();
    }

    public void push(int x) {
        while (!reverse.isEmpty()) {
            forward.add(reverse.pop());
        }
        forward.add(x);
    }

    public int pop() {
        while (!forward.isEmpty()) {
            reverse.add(forward.pop());
        }
        return reverse.pop();
    }

    public int peek() {
        while (!forward.isEmpty()) {
            reverse.add(forward.pop());
        }
        return reverse.peek();
    }

    public boolean empty() {
        return forward.isEmpty() && reverse.isEmpty();
    }

}
