package april_2025;

import java.util.Stack;

public class MyQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();
        myQueue.empty();
    }

    Stack<Integer> forward;
    Stack<Integer> reverse;

    public MyQueue() {
        forward = new Stack<>();
        reverse = new Stack<>();
    }

    public void push(int x) {
        while (!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }
        forward.push(x);
    }

    public int pop() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        return reverse.pop();
    }

    public int peek() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        return reverse.peek();
    }

    public boolean empty() {
        return forward.isEmpty() && reverse.isEmpty();
    }

}
