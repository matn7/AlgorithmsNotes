package november_2025;

import java.util.ArrayDeque;

public class MyQueue {

    // O(n) time | O(n) space
    ArrayDeque<Integer> addQueue;
    ArrayDeque<Integer> removeQueue;

    public MyQueue() {
        addQueue = new ArrayDeque<>();
        removeQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        addQueue.addLast(x);
    }

    public int pop() {
        if (removeQueue.isEmpty()) {
            while (!addQueue.isEmpty()) {
                removeQueue.addLast(addQueue.removeLast());
            }
        }
        return removeQueue.isEmpty() ? -1 : removeQueue.removeLast();
    }

    public int peek() {
        if (removeQueue.isEmpty()) {
            while (!addQueue.isEmpty()) {
                removeQueue.addLast(addQueue.removeLast());
            }
        }
        return removeQueue.isEmpty() ? -1 : removeQueue.getLast();
    }

    public boolean empty() {
        return addQueue.isEmpty() && removeQueue.isEmpty(); // [], ["a"]
    }

}
