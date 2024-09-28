package problems.other;

import java.util.Stack;

public class Queue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public Queue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void enqueue(int val) {
        s1.push(val);
    }

    public int dequeue() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.pop();
    }
}
