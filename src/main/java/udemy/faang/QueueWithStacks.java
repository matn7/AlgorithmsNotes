package udemy.faang;

import java.util.Stack;

public class QueueWithStacks {

    public Stack<Integer> in;
    public Stack<Integer> out;

    public QueueWithStacks() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void enqueue(int val) {
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        in.push(val);
    }

    public int dequeue() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        if (out.isEmpty()) {
            throw new RuntimeException("Try to dequeue from empty stack");
        }
        return out.pop();
    }

    public int peek() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        if (out.isEmpty()) {
            throw new RuntimeException("Try to peek from empty stack");
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        QueueWithStacks queue = new QueueWithStacks();
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(3);
        queue.peek();
        System.out.println(queue.empty());
    }

}
