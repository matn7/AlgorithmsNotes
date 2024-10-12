package november_2023;

import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String[] args) {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.enqueue(2);
        queueUsingStacks.enqueue(4);
        queueUsingStacks.enqueue(5);
        int peek = queueUsingStacks.peek();
        System.out.println(peek);
        queueUsingStacks.dequeue();
        System.out.println(queueUsingStacks.peek());
        queueUsingStacks.enqueue(6);
        queueUsingStacks.dequeue();
        queueUsingStacks.dequeue();
        System.out.println(queueUsingStacks.peek());
    }

    Stack<Integer> forward = new Stack<>();
    Stack<Integer> reverse = new Stack<>();

    // O(n) time | O(n) space
    public int enqueue(int value) {
        while (!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }
        forward.push(value);
        return value;
    }

    public int dequeue() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return reverse.pop();
    }

    public int peek() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return reverse.peek();
    }
}
