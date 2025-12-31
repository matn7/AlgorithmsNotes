package december_2025;

import java.util.ArrayDeque;

public class MyQueue {

    ArrayDeque<Integer> forwardQueue; // add elements
    ArrayDeque<Integer> reverseQueue; // remove elements

    public MyQueue() {
        forwardQueue = new ArrayDeque<>();
        reverseQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        forwardQueue.addLast(x);
    }

    public int pop() {
        if (reverseQueue.isEmpty()) {
            while (!forwardQueue.isEmpty()) {
                reverseQueue.addLast(forwardQueue.removeLast());
            }
        }
        return reverseQueue.removeLast();
    }

    public int peek() {
        if (reverseQueue.isEmpty()) {
            while (!forwardQueue.isEmpty()) {
                reverseQueue.addLast(forwardQueue.removeLast());
            }
        }
        return reverseQueue.getLast();
    }

    public boolean empty() {
        return forwardQueue.isEmpty() && reverseQueue.isEmpty();
    }

}
