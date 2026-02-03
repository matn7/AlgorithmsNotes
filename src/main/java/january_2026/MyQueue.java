package january_2026;

import java.util.ArrayDeque;

public class MyQueue {

    ArrayDeque<Integer> forwardQueue;
    ArrayDeque<Integer> reverseQueue;

    public MyQueue() {
        forwardQueue = new ArrayDeque<>();
        reverseQueue = new ArrayDeque<>();
    }

    public void push(int x) {
//        while (!reverseQueue.isEmpty()) {
//            forwardQueue.addLast(reverseQueue.removeLast());
//        }
        forwardQueue.addLast(x);
    }

    public int pop() {
        if (reverseQueue.isEmpty()) {
            while (!forwardQueue.isEmpty()) {
                reverseQueue.addLast(forwardQueue.removeLast());
            }
        }
        int removed = reverseQueue.removeLast();
        return removed;
    }

    public int peek() {
        if (reverseQueue.isEmpty()) {
            while (!forwardQueue.isEmpty()) {
                reverseQueue.addLast(forwardQueue.removeLast());
            }
        }
        int removed = reverseQueue.getLast();
        return removed;

    }

    public boolean empty() {
        return forwardQueue.isEmpty() && reverseQueue.isEmpty();
    }

}
