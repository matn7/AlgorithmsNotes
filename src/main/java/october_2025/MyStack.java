package october_2025;

import java.util.ArrayDeque;

class MyStack {

    ArrayDeque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.removeLast();
    }

    public int top() {
        return queue.getLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}

