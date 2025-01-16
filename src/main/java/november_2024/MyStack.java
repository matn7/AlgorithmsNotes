package november_2024;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }

    ArrayDeque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            Integer top = queue.removeFirst();
            queue.addLast(top);
        }
        return queue.removeFirst();
    }

    public int top() {
        return queue.getLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }


}
