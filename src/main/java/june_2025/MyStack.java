package june_2025;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    Deque<Integer> addQueue;
    Deque<Integer> getQueue;

    public MyStack() {
        addQueue = new ArrayDeque<>();
        getQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!getQueue.isEmpty()) {
            addQueue.addFirst(getQueue.pollLast());
        }
        addQueue.addFirst(x);
    }

    public int pop() {
        while (!addQueue.isEmpty()) {
            getQueue.addLast(addQueue.pollFirst());
        }
        if (getQueue.isEmpty()) {
            throw new RuntimeException("Queue empty");
        }
        return getQueue.poll();
    }

    public int top() {
        while (!addQueue.isEmpty()) {
            getQueue.addLast(addQueue.pollFirst());
        }
        if (getQueue.isEmpty()) {
            throw new RuntimeException("Queue empty");
        }
        return getQueue.peek();
    }

    public boolean empty() {
        return getQueue.isEmpty();
    }
}
